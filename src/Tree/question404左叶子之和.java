package Tree;

//给定二叉树的根节点root，返回所有左叶子之和。
//
//示例 1：
//
//输入: root = [3,9,20,null,null,15,7]
//输出: 24
//解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
//示例2:
//
//输入: root = [1]
//输出: 0
//
//提示:
//
//节点数在[1, 1000]范围内
//-1000 <= Node.val <= 1000

import java.util.Stack;

public class question404左叶子之和 {
    //递归法
    public int sumOfLeftLeaves1(TreeNode root) {
        if(root==null){
            return 0;
        }
        int midValue = 0;
        if(root.left!=null && root.left.left == null && root.left.right == null){
            midValue += root.left.val;
        }
        int leftValue = sumOfLeftLeaves1(root.left);     //左
        int rightValue = sumOfLeftLeaves1(root.right);   //右
        return leftValue+rightValue+midValue;            //中
    }

    //迭代法
    public int sumOfLeftLeaves2(TreeNode root) {
        if(root==null){
            return 0;
        }
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur.left!=null && cur.left.left==null && cur.left.right==null){
                return sum+=cur.left.val;
            }
            if(cur.left!=null){
                stack.push(cur.left);
            }
            if(cur.right!=null){
                stack.push(cur.right);
            }
        }
        return sum;
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
