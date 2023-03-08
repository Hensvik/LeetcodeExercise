package Tree.Traversal;

import java.util.*;

//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
//
//示例 1：
//
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
//示例 2：
//
//输入：root = [1]
//输出：[[1]]
//示例 3：
//
//输入：root = []
//输出：[]
//
//提示：
//
//树中节点数目在范围 [0, 2000] 内
//-1000 <= Node.val <= 1000
public class question102二叉树的层序遍历 {

    //左程云方法
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        if(root == null){
            return list;
        }

        Queue<TreeNode> queue= new ArrayDeque<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            list.add(level);
        }
        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //代码随想录
    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder2(TreeNode root) {
        //checkFun01(root,0);
        checkFun02(root);

        return resList;
    }

    //DFS--递归方式
    public void checkFun01(TreeNode node, Integer deep) {
        if (node == null){
            return;
        }
        deep++;

        if (resList.size() < deep) {
            //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<Integer>();
            resList.add(item);
        }
        resList.get(deep - 1).add(node.val);

        checkFun01(node.left, deep);
        checkFun01(node.right, deep);
    }

    //BFS--迭代方式--借助队列
    public void checkFun02(TreeNode node) {
        if (node == null){
            return;
        }
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(node);

        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<Integer>();
            int len = que.size();

            while (len > 0) {
                TreeNode tmpNode = que.poll();
                itemList.add(tmpNode.val);

                if (tmpNode.left != null) {
                    que.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    que.offer(tmpNode.right);
                }
                len--;
            }
            resList.add(itemList);
        }
    }
}
