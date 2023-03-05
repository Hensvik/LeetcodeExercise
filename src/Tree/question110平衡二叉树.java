package Tree;

//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
//本题中，一棵高度平衡二叉树定义为：
//
//一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1 。
//
//示例 1：
//
//输入：root = [3,9,20,null,null,15,7]
//输出：true
//示例 2：
//
//
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
//示例 3：
//
//输入：root = []
//输出：true
//
//提示：
//
//树中的节点数在范围 [0, 5000] 内
//-104 <= Node.val <= 104

import java.util.Stack;

public class question110平衡二叉树 {
    //递归法
    public boolean isBalanced1(TreeNode root) {
        if(root==null){
            return true;
        }
        return getDepth(root) != -1;
    }

    public int getDepth(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftHeight = getDepth(node.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getDepth(node.right);
        if (rightHeight == -1) {
            return -1;
        }
        // 左右子树高度差大于1，return -1表示已经不是平衡树了
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * 迭代法，效率较低，计算高度时会重复遍历
     * 时间复杂度：O(n^2)
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root!= null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode inNode = stack.peek();
            // 右结点为null或已经遍历过
            if (inNode.right == null || inNode.right == pre) {
                // 比较左右子树的高度差，输出
                if (Math.abs(getDepth(inNode.left) - getDepth(inNode.right)) > 1) {
                    return false;
                }
                stack.pop();
                pre = inNode;
                root = null;// 当前结点下，没有要遍历的结点了
            } else {
                root = inNode.right;// 右结点还没遍历，遍历右结点
            }
        }
        return true;
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
