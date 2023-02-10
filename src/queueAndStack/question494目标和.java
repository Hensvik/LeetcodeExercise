package queueAndStack;

//给你一个整数数组 nums 和一个整数 target 。
//
//向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
//
//例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
//返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
//
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
//

//这题的难点在于如何设计遍历逻辑
//如果采用双指针的话

//该题的BFS和DFS解法会超时

//如何转化为01背包问题呢。
//假设加法的总和为x，那么减法对应的总和就是sum - x。
//所以我们要求的是 x - (sum - x) = target
//x = (target + sum) / 2

import java.util.Queue;

public class question494目标和 {

    //深度遍历写法
    static int count = 0;
    public static int findTargetSumWays(int[] nums, int target) {
        if(nums.length==0){
            return 0;
        }

        //统计符合条件的次数
        DFS(nums,target,0,0);
        System.out.println("count="+count);
        return count;
    }

    public static void DFS(int[] nums,int target,int index,int sum){
        //注意此处的终结条件，index==nums.length意味着此时已经遍历完
        if(index==nums.length){
            if(sum==target){
                count++;
            }
            return;
        }
        DFS(nums,target,index+1,sum+nums[index]);
        DFS(nums,target,index+1,sum-nums[index]);
    }

    public static void main(String[] args) {
        int []nums={1,1,1,1,1};
        findTargetSumWays(nums,3);
    }

    //动态规划解法
    /*public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //sum为所有数求和，如果sum依旧小于目标或者结果为奇数，但target为偶数，则无解
        if (sum < target || (sum + target) % 2 == 1) {
            return 0;
        }

        //w为所有数累计和与目标值的平均值
        int w = (sum + target) / 2;
        int[] dp = new int[w + 1];
        dp[0] = 1;
        for (int num : nums) {      //遍历数组
            for (int j = w; j >= num; j--) {        //
                dp[j] += dp[j - num];       //计算总和
            }
        }
        return dp[w];
    }*/
}
