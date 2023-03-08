package Tree.Traversal;

//145. 二叉树的后序遍历
//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
//
//示例 1：
//
//输入：root = [1,null,2,3]
//输出：[3,2,1]
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
//树中节点的数目在范围 [0, 100] 内
//-100 <= Node.val <= 100
//
//进阶：递归算法很简单，你可以通过迭代算法完成吗？

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class question145二叉树的后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        afterorder(root, res);
        return res;
    }

    //递归写法
    public void afterorder(TreeNode root,List<Integer> res){
        if(root == null){
            return;
        }
        afterorder(root.left, res);
        afterorder(root.right, res);
        res.add(root.val);
    }

    //迭代写法
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root!=null){
            //推入父节点
            stack.push(root);
            while(!stack.isEmpty()){
                //推出父节点，并放入结果集
                root = stack.pop();
                res.add(root.val);
                //当父节点的左节点不为空，则推入左节点
                if(root.left!=null){
                    stack.push(root.left);
                }
                //当父节点的右节点不为空，则推入右节点
                if(root.right!=null){
                    stack.push(root.right);
                }
                //因为左节点是后入先出，所以结果集紧跟着是左节点，然后才是右节点
            }
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
