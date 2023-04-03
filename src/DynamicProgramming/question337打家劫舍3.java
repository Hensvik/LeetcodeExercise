package DynamicProgramming;

//小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为root。
//除了root之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
//给定二叉树的root。返回在不触动警报的情况下，小偷能够盗取的最高金额。
//
//示例 1:
//
//输入: root = [3,2,3,null,3,null,1]
//输出: 7 
//解释:小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
//示例 2:
//
//输入: root = [3,4,5,1,3,null,1]
//输出: 9
//解释:小偷一晚能够盗取的最高金额 4 + 5 = 9
//
//提示：
//
//树的节点数在[1, 104] 范围内
//0 <= Node.val <= 104

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class question337打家劫舍3 {

    //递归法 超时了
    public int rob1(TreeNode root) {
        if(root==null){
            return 0;
        }

        int money = root.val;
        if(root.left!=null){
            money += rob1(root.left.left)+rob1(root.left.right);
        }
        if(root.right!=null){
            money += rob1(root.right.left)+rob1(root.right.right);
        }

        return Math.max(money,rob1(root.left)+rob1(root.right));
    }

    //递归，使用Map暂存数据
    public int rob2(TreeNode root){
        Map<TreeNode, Integer> memo = new HashMap<>();
        return robAction(root, memo);
    }

    int robAction(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root == null){
            return 0;
        }
        //如果Map曾经记录过root，返回
        if (memo.containsKey(root)){
            return memo.get(root);
        }
        int money = root.val;
        if (root.left != null) {
            money += robAction(root.left.left, memo) + robAction(root.left.right, memo);
        }
        if (root.right != null) {
            money += robAction(root.right.left, memo) + robAction(root.right.right, memo);
        }
        int res = Math.max(money, robAction(root.left, memo) + robAction(root.right, memo));
        memo.put(root, res);
        return res;
    }

    //动态规划
    // 不偷：Max(左孩子不偷，左孩子偷) + Max(右孩子不偷，右孩子偷)
    // root[0] = Math.max(rob(root.left)[0], rob(root.left)[1]) +
    // Math.max(rob(root.right)[0], rob(root.right)[1])
    // 偷：左孩子不偷+ 右孩子不偷 + 当前节点偷

    public int rob3(TreeNode root) {
        int[] res = robAction1(root);
        return Math.max(res[0], res[1]);
    }

    int[] robAction1(TreeNode root) {
        int res[] = new int[2];
        if (root == null){
            return res;
        }

        int[] left = robAction1(root.left);
        int[] right = robAction1(root.right);

        //表示左孩子不偷或偷时的最大值+右孩子不偷或偷时的最大值
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //表示左右孩子都不偷时的最大值+当前节点的值
        res[1] = root.val + left[0] + right[0];
        return res;
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
