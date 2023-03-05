package Tree;

//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
//
//叶子节点 是指没有子节点的节点。
//
//示例 1：
//
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
//示例 2：
//
//输入：root = [1]
//输出：["1"]
//
//提示：
//
//树中节点的数目在范围 [1, 100] 内
//-100 <= Node.val <= 100

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class question257二叉树的所有路径 {
    //自己写的递归法
    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null){
            return new ArrayList<>();
        }
        progress(root,res,""+root.val);
        return res;
    }

    public void progress(TreeNode node,List<String> path,String temp){
        if(node.left==null && node.right==null){
            path.add(temp);
        }
        if(node.left!=null){
            progress(node.left,path,temp+"->"+node.left.val);
        }
        if(node.right!=null){
            progress(node.right,path,temp+"->"+node.right.val);
        }
    }

    /**
     * 迭代法
     */
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<Object> stack = new Stack<>();
        // 节点和路径同时入栈
        stack.push(root);
        stack.push(root.val + "");

        while (!stack.isEmpty()) {
            // 节点和路径同时出栈
            String path = (String) stack.pop();
            TreeNode node = (TreeNode) stack.pop();
            // 若找到叶子节点
            if (node.left == null && node.right == null) {
                result.add(path);
            }
            //右子节点不为空
            if (node.right != null) {
                stack.push(node.right);
                stack.push(path + "->" + node.right.val);
            }
            //左子节点不为空
            if (node.left != null) {
                stack.push(node.left);
                stack.push(path + "->" + node.left.val);
            }
        }
        return result;
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
