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

import java.util.*;

public class question226翻转二叉树 {
    public static TreeNode invertTree1(TreeNode root) {
        reverseTree(root);
        return root;
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

    //自己的方法(通过)
    public static void reverseTree(TreeNode root){
        if (root == null){
            return;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int len = que.size();
            //这个地方不能写成quequ.size()>0
            while (len > 0) {
                TreeNode tmpNode = que.poll();
                if (tmpNode!=null) {
                    que.offer(tmpNode.left);
                    que.offer(tmpNode.right);
                    TreeNode temp = tmpNode.left;
                    tmpNode.left = tmpNode.right;
                    tmpNode.right = temp;
                }
                len--;
            }
        }
    }

    //递归法leetcode解法
    public TreeNode invertTree2(TreeNode root) {
        //递归函数的终止条件，节点为空时返回
        if(root==null) {
            return null;
        }
        //下面三句是将当前节点的左右子树交换
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        //递归交换当前节点的 左子树
        invertTree2(root.left);
        //递归交换当前节点的 右子树
        invertTree2(root.right);
        //函数返回时就表示当前这个节点，以及它的左右子树
        //都已经交换完了
        return root;
    }

    /**
     * 代码随想录DFS递归解法
     * 前后序遍历都可以
     * 中序不行，因为先左孩子交换孩子，再根交换孩子（做完后，右孩子已经变成了原来的左孩子），再右孩子交换孩子（此时其实是对原来的左孩子做交换）
     */
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree3(root.left);
        invertTree3(root.right);
        swapChildren(root);
        return root;
    }

    //BFS
    public TreeNode invertTree4(TreeNode root) {
        if (root == null) {return null;}
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode node = deque.poll();
                swap(node);
                if (node.left != null){
                    deque.offer(node.left);
                }
                if (node.right != null){
                    deque.offer(node.right);
                }
            }
        }
        return root;
    }

    public void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    private void swapChildren(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        root.left = node2;
        invertTree1(root);
    }
}
