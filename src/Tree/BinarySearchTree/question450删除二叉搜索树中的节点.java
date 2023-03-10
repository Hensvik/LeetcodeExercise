package Tree.BinarySearchTree;

//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的key对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
//一般来说，删除节点可分为两个步骤：
//首先找到需要删除的节点；
//如果找到了，删除它。
//
//示例 1:
//
//输入：root = [5,3,6,2,4,null,7], key = 3
//输出：[5,4,6,2,null,null,7]
//解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//
//示例 2:
//
//输入: root = [5,3,6,2,4,null,7], key = 0
//输出: [5,3,6,2,4,null,7]
//解释: 二叉树不包含值为 0 的节点
//示例 3:
//
//输入: root = [], key = 0
//输出: []
//
//
//提示:
//
//节点数的范围[0, 104].
//-105<= Node.val <= 105
//节点值唯一
//root是合法的二叉搜索树
//-105<= key <= 105

public class question450删除二叉搜索树中的节点 {

    static TreeNode pre = null;
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        root = delete(root,key);
        return root;
    }

    public TreeNode delete(TreeNode node,int key){
        //第二种情况
        if (node == null){
            return null;
        }

        if (node.val > key) {
            //node的值>key，往左边去找
            node.left = delete(node.left,key);
        } else if (node.val < key) {
            //node的值<key，往右边去找
            node.right = delete(node.right,key);
        } else {
            //找到了key
            //第一种情况：没找到删除的节点，遍历到空节点直接返回了
            //找到删除的节点
            //第二种情况：左右孩子都为空（叶子节点），直接删除节点， 返回NULL为根节点
            //第三种情况：删除节点的左孩子为空，右孩子不为空，删除节点，右孩子补位，返回右孩子为根节点
            //第四种情况：删除节点的右孩子为空，左孩子不为空，删除节点，左孩子补位，返回左孩子为根节点
            //第五种情况：左右孩子节点都不为空，则将删除节点的左子树头结点（左孩子）放到删除节点的右子树的最左面节点的左孩子上，返回删除节点右孩子为新的根节点。

            //第三种情况
            if (node.left == null){
                return node.right;
            }
            //第四种情况
            if (node.right == null){
                return node.left;
            }

            //第五种情况，left和right都不为空
            //tmp暂存root的右节点
            TreeNode tmp = node.right;
            //当temp的左节点不为空
            while (tmp.left != null) {
                //让tmp指向最左的node
                tmp = tmp.left;
            }
            //将最左的node替换node
            node.val = tmp.val;
            node.right = delete(node.right,tmp.val);
        }
        return node;
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
