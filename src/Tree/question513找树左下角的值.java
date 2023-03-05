package Tree;

//给定一个二叉树的 根节点 root，请找出该二叉树的最底层最左边节点的值。
//
//假设二叉树中至少有一个节点。
//
//示例 1:
//
//输入: root = [2,1,3]
//输出: 1
//示例 2:
//
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
//
//提示:
//
//二叉树的节点个数的范围是 [1,104]
//-231<= Node.val <= 231- 1

//注意：最深的位置的最左节点不一定是左节点

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class question513找树左下角的值 {
    //需要定义全局变量
    //存当前树的最深深度
    private int Deep = -1;
    //存值
    private int value = 0;

    //代码随想录 递归
    public int findBottomLeftValue(TreeNode root) {
        value = root.val;
        findLeftValue1(root,0);
        return value;
    }

    private void findLeftValue1 (TreeNode root,int deep) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            //如果当前深度>最深深度
            //此处不需要比较其它地方，因为递归时value总是存最深位置的第一个值
            if (deep > Deep) {
                //更新最深深度和值
                value = root.val;
                Deep = deep;
            }
        }
        //如果左节点不为空，查找左节点的值
        if (root.left != null) findLeftValue1(root.left,deep + 1);
        //如果右节点不为空，查找右节点的值
        if (root.right != null) findLeftValue1(root.right,deep + 1);
    }

    //代码随想录 迭代
    private int findBottomLeftValue2 (TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == 0) {
                    res = poll.val;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return res;
    }

    //很强的迭代方法
    public int findBottomLeftValue3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            root = queue.poll();
            //只要先进右节点，那么最后剩下的就是左节点
            if (root.right != null) queue.offer(root.right);
            if (root.left != null) queue.offer(root.left);
        }
        return root.val;
    }

    public static class TreeNode {
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
}
