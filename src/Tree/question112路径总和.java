package Tree;

//给你二叉树的根节点root 和一个表示目标和的整数targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。如果存在，返回 true ；否则，返回 false 。
//叶子节点 是指没有子节点的节点。
//
//示例 1：
//
//
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//输出：true
//解释：等于目标和的根节点到叶节点路径如上图所示。
//示例 2：
//
//输入：root = [1,2,3], targetSum = 5
//输出：false
//解释：树中存在两条根节点到叶子节点的路径：
//(1 --> 2): 和为 3
//(1 --> 3): 和为 4
//不存在 sum = 5 的根节点到叶子节点的路径。
//示例 3：
//
//输入：root = [], targetSum = 0
//输出：false
//解释：由于树是空的，所以不存在根节点到叶子节点的路径。
//
//提示：
//
//树中节点的数目在范围 [0, 5000] 内
//-1000 <= Node.val <= 1000
//-1000 <= targetSum <= 1000

import java.util.ArrayDeque;
import java.util.Deque;

public class question112路径总和 {
    //自己完成的 递归方法
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        return countSum(root,targetSum,root.val);
    }

    public boolean countSum(TreeNode node, int targetSum,int tempSum){
        if(node.left == null && node.right == null){
            return tempSum==targetSum;
        }
        boolean leftSituation = false;
        boolean rightSituation = false;
        if(node.left!=null){
            leftSituation = countSum(node.left,targetSum,tempSum+node.left.val);
        }
        if(node.right!=null){
            rightSituation = countSum(node.right,targetSum,tempSum+node.right.val);
        }
        return leftSituation || rightSituation;
    }

    //代码随想录 递归方法
    public boolean hasPathSum2(TreeNode root, int targetsum) {
        if (root == null) {
            return false; // 为空退出
        }
        // 叶子节点判断是否符合
        if (root.left == null && root.right == null) {
            return root.val == targetsum;
        }

        // 求两侧分支的路径和
        return hasPathSum2(root.left, targetsum - root.val) || hasPathSum2(root.right, targetsum - root.val);
    }

    public boolean hasPathSum3(TreeNode root, int targetsum) {
        if (root == null) {
            return false;
        }
        targetsum -= root.val;
        // 叶子结点
        if (root.left == null && root.right == null) {
            return targetsum == 0;
        }
        if (root.left != null) {
            boolean left = hasPathSum3(root.left, targetsum);
            if (left) {      // 已经找到
                return true;
            }
        }
        if (root.right != null) {
            boolean right = hasPathSum3(root.right, targetsum);
            if (right) {     // 已经找到
                return true;
            }
        }
        return false;
    }


    //迭代方法
    public boolean hasPathSum4(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        int tempSum = root.val;
        deque.add(root);
        while(!deque.isEmpty()){
            TreeNode cur = deque.pop();
            if(tempSum+cur.val == targetSum){
                return true;
            }
            if(cur.left!=null){
                tempSum += cur.left.val;
                deque.add(cur.left);
            }
            if(cur.right!=null){
                tempSum += cur.right.val;
                deque.add(cur.right);
            }
        }
        return false;
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
