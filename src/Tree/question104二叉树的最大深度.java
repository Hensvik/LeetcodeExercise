package Tree;

//给定一个二叉树，找出其最大深度。
//
//二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
//说明:叶子节点是指没有子节点的节点。
//
//示例：
//给定二叉树 [3,9,20,null,null,15,7]，
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//返回它的最大深度3 。

import java.util.Deque;
import java.util.LinkedList;

public class question104二叉树的最大深度 {
    //自己完成
    public int maxDepth1(TreeNode root) {
        if(root==null){
            return 0;
        }
        int depth=1;
        return depthProcess1(root,depth);
    }

    public static int depthProcess1(TreeNode root,int depth){
        if(root.left==null && root.right==null){
            return depth;
        }
        int leftDepth = 0;
        int rightDepth = 0;
        if(root.left!=null){
            leftDepth = depthProcess1(root.left,depth+1);
        }
        if(root.right!=null){
            rightDepth = depthProcess1(root.right,depth+1);
        }
        return Math.max(leftDepth,rightDepth);
    }

    //leetcode上
    public static int maxDepth2(TreeNode root) {
        if(root==null){
            return 0;
        }
        int depth=1;
        return depthProcess2(root,depth);
    }

    public static int depthProcess2(TreeNode root,int depth){
        if(root == null){
            return depth;
        }

        if(root.left!=null || root.right!=null){
            depth+=1;
            depth =Math.max(depthProcess2(root.left,depth),depthProcess2(root.right,depth));
        }
        return depth;
    }

    //代码随想录
    /**
     * 递归法
     */
    public int maxDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth3(root.left);
        int rightDepth = maxDepth3(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 迭代法，使用层序遍历
     */
    public int maxDepth4(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int depth = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        return depth;
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
