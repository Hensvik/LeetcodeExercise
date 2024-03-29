package Tree.Backtracking;

//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//
//示例 1：
//
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
//示例 2：
//
//
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
//示例 3：
//
//输入：root = [1,2], p = 1, q = 2
//输出：1
//
//提示：
//
//树中节点数目在范围 [2, 105] 内。
//-109 <= Node.val <= 109
//所有 Node.val 互不相同 。
//p != q
//p 和 q 均存在于给定的二叉树中。

//回溯思路
//利用后序遍历

import Tree.BinarySearchTree.question501二叉搜索树中的众树;

public class question236二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return afterProcess(root,p,q);
    }

    public static TreeNode afterProcess(TreeNode node,TreeNode p,TreeNode q){
        if(node==null){
            return null;
        }
        if(node==p || node==q){
            return node;
        }
        TreeNode left = afterProcess(node.left,p,q);        //左
        TreeNode right = afterProcess(node.right,p,q);      //右

        //中
        if(left!=null && right!=null){
            return node;
        }
        if(left!=null && right==null){
            return left;
        }
        if(left==null && right!=null){
            return right;
        }
        if(left==null && right==null){
            return null;
        }
        return null;
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
