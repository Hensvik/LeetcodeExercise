package DynamicProgramming;

//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
//
//示例 1：
//
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
//示例 2：
//
//输入：nums = [0,1,0,3,2,3]
//输出：4
//示例 3：
//
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
//
//提示：
//
//1 <= nums.length <= 2500
//-104 <= nums[i] <= 104
//
//进阶：
//
//你能将算法的时间复杂度降低到O(n log(n)) 吗?

import java.util.Arrays;

public class question300最长递增子序列 {
    public static int lengthOfLIS(int[] nums) {

        //dp[i]表示i之前包括i的以nums[i]结尾的最长递增子序列的长度

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        //i的遍历是在dp上
        //j的遍历是从第二个数字开始，依次与之前的
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
    }
        return res;
    }

    public static void main(String[] args) {
        int []nums = {10,9,2,5,3,7,101,18};
        lengthOfLIS(nums);
    }
}
