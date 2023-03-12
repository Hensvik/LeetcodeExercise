package Tree.BinarySearchTree;

//给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node的新值等于原树中大于或等于node.val的值之和。
//提醒一下，二叉搜索树满足下列约束条件：
//
//节点的左子树仅包含键 小于 节点键的节点。
//节点的右子树仅包含键 大于 节点键的节点。
//左右子树也必须是二叉搜索树。
//注意：本题和 1038:https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同
//
//示例 1：
//
//输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
//输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
//示例 2：
//
//输入：root = [0,null,1]
//输出：[1,null,1]
//示例 3：
//
//输入：root = [1,0,2]
//输出：[3,3,2]
//示例 4：
//
//输入：root = [3,2,4,1]
//输出：[7,9,4,10]
//
//提示：
//
//树中的节点数介于 0和 104之间。
//每个节点的值介于 -104和104之间。
//树中的所有值 互不相同 。
//给定的树为二叉搜索树。

import Tree.treeinit;

import java.util.Stack;

public class question538把二叉搜索树转换为累加树 {
    //自己写的方法（错误）
    public static TreeNode convertBST(TreeNode root) {
        if(root==null){
            return null;
        }
        root.val=calculate(root);
        return root;
    }

    public static int calculate(TreeNode node){
        if (node == null) {
            return 0;
        }
        if(node.right!=null){
            node.right.val = calculate(node.right);
            node.val +=node.right.val;
        }
        if(node.left!=null){
            node.left.val = node.val + calculate(node.left);
        }
        return node.val;
    }

    //代码随想录 递归
    int sum;
    public TreeNode convertBST2(TreeNode root) {
        sum = 0;
        calculate2(root);
        return root;
    }

    // 按右中左顺序遍历，累加即可
    public void calculate2(TreeNode root) {
        if (root == null) {
            return;
        }
        calculate2(root.right);
        sum += root.val;
        root.val = sum;
        calculate2(root.left);
    }

    //迭代法 和逆 中序遍历很像
    int pre;
    public TreeNode convertBST3(TreeNode root) {
        pre = 0;
        traversal2(root);
        return root;
    }

    void traversal2(TreeNode root) {
        Stack<TreeNode> st= new Stack<>();
        TreeNode cur = root;
        while (cur != null || !st.empty()) {
            if (cur != null) {
                st.push(cur);
                cur = cur.right;   // 右
            } else {
                cur = st.peek();     // 中
                st.pop();
                cur.val += pre;
                pre = cur.val;
                cur = cur.left;    // 左
            }
        }
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

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(3);
        TreeNode node9 = new TreeNode(8);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        node3.right=node7;
        node5.right=node8;
        node7.right=node9;
        convertBST(node1);
    }
}
