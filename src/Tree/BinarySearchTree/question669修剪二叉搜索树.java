package Tree.BinarySearchTree;

//给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树 不应该改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在唯一的答案。
//所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
//
//示例 1：
//
//输入：root = [1,0,2], low = 1, high = 2
//输出：[1,null,2]
//示例 2：
//
//输入：root = [3,0,4,null,2,null,null,1], low = 1, high = 3
//输出：[3,2,null,1]
//
//提示：
//
//树中节点数在范围 [1, 104] 内
//0 <= Node.val <= 104
//树中每个节点的值都是 唯一 的
//题目数据保证输入是一棵有效的二叉搜索树
//0 <= low <= high <= 104

public class question669修剪二叉搜索树 {
    //自己写的 递归法
    public TreeNode trimBST1(TreeNode root, int low, int high) {
        if(root==null){
            return null;
        }
        root = cut(root,low,high);
        return root;
    }

    public TreeNode cut(TreeNode node,int low,int high){
        // 每次遇到范围外的节点都需要继续往下遍历
        // 情况1：如果遇到的节点<low，返回它的右节点
        // 情况2：如果遇到的节点>high，返回它的左节点

        if (node == null){
            return null;
        }
        if(node.val<low){
            return cut(node.right,low,high);
        }
        if(node.val>high){
            return cut(node.left,low,high);
        }

        node.left = cut(node.left,low,high);
        node.right = cut(node.right,low,high);
        return node;
    }

    //迭代法
    public TreeNode trimBST2(TreeNode root, int low, int high) {
        if(root==null){
            return null;
        }

        //处理头节点，让root移动到[L,R]范围内，注意是左闭右闭
        //如果头节点就不在这个范围内，那么只需要处理一边就可以了
        while(root != null && (root.val<low || root.val>high)){
            if(root.val<low){
                root=root.right;
            }
            if(root.val>high){
                root=root.left;
            }
        }

        TreeNode cur = root;
        //此时root位于范围内
        while(cur!=null){
            //当左节点不为空并且左节点的值小于最小值
            while(cur.left!=null && cur.left.val<low){
                //往右找异常情况
                cur.left = cur.left.right;
            }
            //否则继续往左
            cur = cur.left;
        }

        //复原
        cur = root;

        while(cur!=null){
            //当右节点不为空并且右节点的值小于最小值
            while(cur.right!=null && cur.right.val>high){
                //往左找异常情况
                cur.right = cur.right.left;
            }
            //否则继续往右
            cur = cur.right;
        }

        return root;
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
