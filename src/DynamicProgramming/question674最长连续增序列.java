package DynamicProgramming;

//给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
//连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
//
//示例 1：
//
//输入：nums = [1,3,5,4,7]
//输出：3
//解释：最长连续递增序列是 [1,3,5], 长度为3。
//尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。 
//示例 2：
//
//输入：nums = [2,2,2,2,2]
//输出：1
//解释：最长连续递增序列是 [2], 长度为1。
//
//提示：
//
//1 <= nums.length <= 104
//-109 <= nums[i] <= 109

import java.util.Arrays;

public class question674最长连续增序列 {
    public static int findLengthOfLCIS1(int[] nums) {
        if(nums.length<1){
            return 0;
        }
        int d = 0;
        int max = 1;
        for(int i =1;i<nums.length;i++){
            if(nums[i] > nums[i-1]){
                max = Math.max(i - d + 1,max);
            }else{
                d = i;
            }
        }
        return max;
    }

    public static int findLengthOfLCIS2(int[] nums) {
        //dp的含义为：以nums[i]结尾的最大连续增序列的数量
        int len = nums.length;
        int []dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            if(nums[i]>nums[i-1]){
                dp[i]=dp[i-1]+1;
            }
        }
        int max=0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        int []nums = {1,3,5,4,7};
        findLengthOfLCIS2(nums);
    }
}
