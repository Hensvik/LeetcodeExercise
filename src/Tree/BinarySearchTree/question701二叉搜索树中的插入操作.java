package Tree.BinarySearchTree;

//给定二叉搜索树（BST）的根节点root和要插入树中的值value，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
//注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
//
//示例 1：
//
//输入：root = [4,2,7,1,3], val = 5
//输出：[4,2,7,1,3,5]
//解释：另一个满足题目要求可以通过的树是：
//
//示例 2：
//
//输入：root = [40,20,60,10,30,50,70], val = 25
//输出：[40,20,60,10,30,50,70,null,null,25]
//示例 3：
//
//输入：root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
//输出：[4,2,7,1,3,5]
//
//提示：
//
//树中的节点数将在[0,104]的范围内。
//-108<= Node.val <= 108
//所有值Node.val是独一无二的。
//-108<= val <= 108
//保证val在原始BST中不存在。

public class question701二叉搜索树中的插入操作 {
    static TreeNode pre = null;
    //自己写的递归法
    public static TreeNode insertIntoBST1(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        process(root,val);
        return root;
    }

    public static void process(TreeNode root, int val){
        if(root==null){
            if(pre.val>val){
                pre.left=new TreeNode(val);
                return;
            }else{
                pre.right=new TreeNode(val);
                return;
            }
        }
        pre = root;
        if(root.val>val){
            process(root.left,val);
        }else if(root.val<val){
            process(root.right,val);
        }
    }

    //代码随想录 递归法
    public static TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) // 如果当前节点为空，也就意味着val找到了合适的位置，此时创建节点直接返回。
            return new TreeNode(val);

        if (root.val < val){
            root.right = insertIntoBST2(root.right, val); // 递归创建右子树
        }else if (root.val > val){
            root.left = insertIntoBST2(root.left, val); // 递归创建左子树
        }
        return root;
    }

    //代码随想录 迭代方法
    public static TreeNode insertIntoBST3(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode newRoot = root;
        TreeNode pre = root;
        while (root != null) {
            pre = root;
            if (root.val > val) {
                root = root.left;
            } else if (root.val < val) {
                root = root.right;
            }
        }
        if (pre.val > val) {
            pre.left = new TreeNode(val);
        } else {
            pre.right = new TreeNode(val);
        }

        return newRoot;
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
        insertIntoBST1(node1,5);
    }
}
