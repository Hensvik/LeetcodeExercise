package Tree;

//给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
//
//示例 1：
//
//输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
//示例 2：
//
//输入：root = [2,1,3]
//输出：[2,3,1]
//示例 3：
//
//输入：root = []
//输出：[]
//
//提示：
//
//树中节点数目范围在 [0, 100] 内
//-100 <= Node.val <= 100

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class question226翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        reverseTree(root);
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

    public static void reverseTree(TreeNode root){
        if (root == null){
            return;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<Integer>();
            int len = que.size();
            //这个地方不能写成quequ.size()>0
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
        }
    }
}
