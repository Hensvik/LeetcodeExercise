package Tree;

//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
//
//有效 二叉搜索树定义如下：
//
//节点的左子树只包含 小于 当前节点的数。
//节点的右子树只包含 大于 当前节点的数。
//所有左子树和右子树自身必须也是二叉搜索树。
//
//示例 1：
//
//
//输入：root = [2,1,3]
//输出：true
//示例 2：
//
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
//
//
//提示：
//
//树中节点数目范围在[1, 104] 内
//-231 <= Node.val <= 231 - 1

public class question98验证二叉搜索树 {
    public static boolean isValidBST1(TreeNode root) {
        if(root == null){
            return true;
        }else if(root.left.val>root.val || root.right.val<root.val){
            return false;
        }
        boolean leftSide = isValidBST1(root.left);
        boolean rightSide = isValidBST1(root.left);
        return leftSide && rightSide;
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
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        //TreeNode node5 = new TreeNode(6);
        node1.left=node2;
        node1.right=node3;
        node3.right=node4;
        //node3.right=node5;
        isValidBST1(node1);
    }
}
