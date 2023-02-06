package easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class question637二叉树的层平均值 {
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

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<Double>();

        if(root == null){
            return list;
        }

        int sums;
        Queue<TreeNode> queue= new ArrayDeque<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            sums=0;
            //List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for(int i=1;i<=currentLevelSize;i++){
                TreeNode node = queue.poll();
                //level.add(node.val);
                sums+=node.val;

                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            list.add(Double.valueOf(sums/currentLevelSize));
        }
        return list;
    }
}
