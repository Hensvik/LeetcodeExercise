package Tree;

//给定一个二叉树的根节点 root ，返回 它的 中序遍历 。
//
//示例 1：
//
//输入：root = [1,null,2,3]
//输出：[1,3,2]
//示例 2：
//
//输入：root = []
//输出：[]
//示例 3：
//
//输入：root = [1]
//输出：[1]
//
//提示：
//
//树中节点数目在范围 [0, 100] 内
//-100 <= Node.val <= 100
//
//进阶:递归算法很简单，你可以通过迭代算法完成吗？

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class question94二叉树的中序遍历 {
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    //递归写法
    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
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

    //迭代写法
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root!=null){
            //当stack不为空或root不为空
            while(!stack.isEmpty() || root != null){
                //当root不为空
                if (root != null) {
                    //将root push入stack
                    stack.push(root);
                    //将root置为root的左节点
                    root = root.left;
                } else {
                    //将root置为stack弹出的单位
                    root = stack.pop();
                    //插入root的值
                    res.add(root.val);
                    //将root置为root的右节点
                    root = root.right;
                }
            }
        }
        return res;
    }
}
