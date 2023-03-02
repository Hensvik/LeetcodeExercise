package Tree;

//给定一个二叉树，找出其最小深度。
//
//最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
//说明：叶子节点是指没有子节点的节点。
//
//示例 1：
//
//输入：root = [3,9,20,null,null,15,7]
//输出：2
//示例 2：
//
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
//
//提示：
//
//树中节点数的范围在 [0, 105] 内
//-1000 <= Node.val <= 1000

public class question111二叉树的最小深度 {
    public static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return getMinDepth(root,0,0);
    }

    public static int getMinDepth(TreeNode root,int leftDepth,int rightDepth){
        if(root==null){
            return Math.min(leftDepth,rightDepth);
        }
        if (root.left==null && root.right!=null){
            return 1+rightDepth;
        }
        if (root.left!=null && root.right==null){
            return 1+leftDepth;
        }
        return Math.min(leftDepth,rightDepth);
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
        TreeNode Node1 = new TreeNode(3);
        TreeNode Node2 = new TreeNode(9);
        TreeNode Node3 = new TreeNode(20);
        TreeNode Node4 = new TreeNode(15);
        TreeNode Node5 = new TreeNode(7);
        Node1.left=Node2;
        Node1.right=Node3;
        Node3.left=Node4;
        Node3.right=Node5;

        System.out.println(minDepth(Node1));
    }
}
