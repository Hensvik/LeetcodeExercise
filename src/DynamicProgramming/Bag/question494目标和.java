package DynamicProgramming.Bag;

//给你一个整数数组 nums 和一个整数 target 。
//向数组中的每个整数前添加'+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
//
//例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
//返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
//
//示例 1：
//
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
//示例 2：
//
//输入：nums = [1], target = 1
//输出：1
//
//提示：
//
//1 <= nums.length <= 20
//0 <= nums[i] <= 1000
//0 <= sum(nums[i]) <= 1000
//-1000 <= target <= 1000

//如何转化为01背包问题呢。
//假设加法的总和为x，那么减法对应的总和就是sum - x。
//所以我们要求的是 x - (sum - x) = target
//x = (target + sum) / 2

public class question494目标和 {
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //如果取和了仍比target小或者sum和target有且仅有一个为奇数，则无解
        if (sum < target || (sum + target) % 2 == 1) {
            return 0;
        }

        //既然为target，那么就一定有 left组合 - right组合 = target。
        //left + right = sum，而sum是固定的。right = sum - left
        //公式来了， left - (sum - left) = target 推导出 left = (target + sum)/2 。
        //target是固定的，sum是固定的，left就可以求出来。
        //此时问题就是在集合nums中找出和为left的组合。

        int w = (sum + target) / 2;
        int[] dp = new int[w + 1];
        dp[0] = 1;

        for (int num : nums) {      //遍历数组
            for (int j = w; j >= num; j--) {
                dp[j] += dp[j - num];       //计算总和
            }
        }
        return dp[w];
    }

    public static void main(String[] args) {
        int []nums = {2,2,7,3,4};
        findTargetSumWays(nums,14);
    }
}
