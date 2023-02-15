package QueueAndStack;

//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。

//示例 1：
//
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

import java.util.ArrayList;
import java.util.List;

public class question94二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        preorder(root.left, res);
        res.add(root.val);
        preorder(root.right, res);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
