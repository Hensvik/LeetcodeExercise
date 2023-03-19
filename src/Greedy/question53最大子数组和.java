package Greedy;

//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//子数组 是数组中的一个连续部分。
//
//示例 1：
//
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组[4,-1,2,1] 的和最大，为6 。
//示例 2：
//
//输入：nums = [1]
//输出：1
//示例 3：
//
//输入：nums = [5,4,-1,7,8]
//输出：23
//
//提示：
//
//1 <= nums.length <= 105
//-104 <= nums[i] <= 104
//
//进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。

public class question53最大子数组和 {
    public static int maxSubArray(int[] nums) {
        //res用来记录最大值
        int res = 0;
        //count用于计算临时值
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            //如果直接遇到了比res更高的值，那么直接将最高值置为这个值
            if(count > res){
                res = count;
            }
            if(count<=0){
                count = 0;
            }
        }
        return res;
    }

    //动态规划
    public int maxSubArray2(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        ans = dp[0];

        for (int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            ans = Math.max(dp[i], ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        int []nums = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);
    }
}
