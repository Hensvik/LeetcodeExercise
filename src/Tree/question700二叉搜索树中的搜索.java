package Tree;

//给定二叉搜索树（BST）的根节点root和一个整数值val。
//
//你需要在 BST 中找到节点值等于val的节点。 返回以该节点为根的子树。 如果节点不存在，则返回null。
//
//示例 1:
//
//输入：root = [4,2,7,1,3], val = 2
//输出：[2,1,3]
//示例 2:
//
//
//输入：root = [4,2,7,1,3], val = 5
//输出：[]
//
//
//提示：
//
//数中节点数在[1, 5000]范围内
//1 <= Node.val <= 107
//root是二叉搜索树
//1 <= val <= 107

public class question700二叉搜索树中的搜索 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }

        if(root.val>val){
            return searchBST(root.left,val);
        }else{
            return searchBST(root.right,val);
        }
    }

    //leetcode两行解法
    public TreeNode searchBST2(TreeNode root, int val) {
        if(root == null ||root.val == val) return root;
        return root.val > val? searchBST2(root.left,val):searchBST2(root.right,val);
    }

    //迭代法
    public static TreeNode searchBST3(TreeNode root, int val) {
        while(root!=null){
            if(root.val==val){
                return root;
            }
            if(root.val>val){
                root = root.left;
            }else if(root.val<val){
                //注意这里一定要用else if，如果单独拎出去if会报错，因为此时root已经为root.left了，有可能为null
                root = root.right;
            }
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

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        searchBST3(node1,5);
    }
}
