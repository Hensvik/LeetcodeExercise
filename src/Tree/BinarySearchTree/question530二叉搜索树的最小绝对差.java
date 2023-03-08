package Tree.BinarySearchTree;

//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
//差值是一个正数，其数值等于两值之差的绝对值。
//
//示例 1：
//
//输入：root = [4,2,6,1,3]
//输出：1
//示例 2：
//
//输入：root = [1,0,48,null,null,12,49]
//输出：1
//
//提示：
//
//树中节点的数目范围是 [2, 104]
//0 <= Node.val <= 105
//
//
//注意：本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同

//二叉搜索树与中序遍历有很密切的关系
//构建中序遍历集合后，遍历一遍就可以获得

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class question530二叉搜索树的最小绝对差 {

    //自己写的，利用中序遍历与二叉搜索树的特性实现
    public static int getMinimumDifference1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(list,root);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            res = Math.min(res,Math.abs(list.get(i)-list.get(i-1)));
        }
        return res;
    }

    public static void inOrder(List<Integer> list,TreeNode root){
        if(root == null){
            return;
        }
        inOrder(list,root.left);
        list.add(root.val);
        inOrder(list,root.right);
    }

    //代码随想录 遍历校验
    static TreeNode pre = null;
    static int res = Integer.MAX_VALUE;
    public int getMinimumDifference2(TreeNode root) {
        traversal(root);
        return res;
    }

    void traversal(TreeNode cur) {
        if (cur == null){
            return;
        }
        traversal(cur.left);   // 左
        if (pre != null){       // 中
            res = Math.min(res, cur.val - pre.val);
        }
        pre = cur; // 记录前一个 相当于回溯操作
        traversal(cur.right);  // 右
    }

    //代码随想录 迭代法
    public static int getMinimumDifference3(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int result = Integer.MAX_VALUE;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur); // 将访问的节点放进栈
                cur = cur.left; // 左
            }else {
                cur = stack.pop();
                if (pre != null) { // 中
                    result = Math.min(result, cur.val - pre.val);
                }
                pre = cur;
                cur = cur.right; // 右
            }
        }
        return result;
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
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(48);
        TreeNode node4 = new TreeNode(12);
        TreeNode node5 = new TreeNode(49);
        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;
        System.out.println(getMinimumDifference3(node1));
    }
}
