package easy;

import java.util.ArrayDeque;
import java.util.Queue;

public class question104二叉树的最大深度 {
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
    public static int maxDepth(TreeNode root) {
        int depth=1;
        return depthProcess(root,depth);
    }

    public static int depthProcess(TreeNode root,int depth){
        if(root == null){
            return depth;
        }

        if(root.left!=null || root.right!=null){
            depth+=1;
            depth =Math.max(depthProcess(root.left,depth),depthProcess(root.right,depth));
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode b = new TreeNode(9,null,null);
        TreeNode d = new TreeNode(15,null,null);
        TreeNode e = new TreeNode(7,null,null);
        TreeNode c = new TreeNode(20,d,e);
        TreeNode a = new TreeNode(3,b,c);
        System.out.println(maxDepth(a));

        Queue<Integer> queue= new ArrayDeque<Integer>();
        //queue.offer();
    }
}
