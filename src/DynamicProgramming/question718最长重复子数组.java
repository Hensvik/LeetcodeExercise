package DynamicProgramming;

//给两个整数数组nums1和nums2，返回 两个数组中 公共的 、长度最长的子数组的长度。
//
//示例 1：
//
//输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//输出：3
//解释：长度最长的公共子数组是 [3,2,1] 。
//示例 2：
//
//输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
//输出：5
//
//
//提示：
//
//1 <= nums1.length, nums2.length <= 1000
//0 <= nums1[i], nums2[i] <= 100

public class question718最长重复子数组 {
    public static int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int res=0;
        //表示以nums[n]结尾的最长重复子数组的长度
        int [][]dp = new int[len1+1][len2+1];
        for (int i = 1; i < len1+1; i++) {
            for (int j = 1; j < len2+1; j++) {
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    res = Math.max(res,dp[i][j]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[]nums1={1,2,3,2,1};
        int[]nums2={3,2,1,4,7};
        findLength(nums1,nums2);
    }
}
