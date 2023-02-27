package Tree;

//给你二叉树的根节点 root ，返回它节点值的前序遍历。
//
//示例 1：
//
//输入：root = [1,null,2,3]
//输出：[1,2,3]
//示例 2：
//
//输入：root = []
//输出：[]
//示例 3：
//
//输入：root = [1]
//输出：[1]
//示例 4：
//
//输入：root = [1,2]
//输出：[1,2]
//示例 5：
//
//
//输入：root = [1,null,2]
//输出：[1,2]
//
//提示：
//
//树中节点数目在范围 [0, 100] 内
//-100 <= Node.val <= 100
//
//进阶：递归算法很简单，你可以通过迭代算法完成吗？

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class question144二叉树的前序遍历 {
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }

    //递归写法
    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    //迭代写法
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root!=null){
            stack.push(root);
            while(!stack.isEmpty()){
                root = stack.pop();
                res.add(root.val);
                if(root.right!=null){
                    stack.push(root.right);
                }
                if(root.left!=null){
                    stack.push(root.left);
                }
            }
        }
        return res;
    }

    //莫里斯遍历写法
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        TreeNode p1 = root, p2 = null;

        //当头节点p1不为空，则让p2为p1的左节点
        while (p1 != null) {
            p2 = p1.left;
            //当p2不为空
            if (p2 != null) {
                //当p2不为空并且p2的右节点不等于p1
                while (p2.right != null && p2.right != p1) {
                    p2 = p2.right;
                }
                if (p2.right == null) {
                    res.add(p1.val);
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                } else {
                    p2.right = null;
                }
            } else {
                res.add(p1.val);
            }
            p1 = p1.right;
        }
        return res;
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
}
