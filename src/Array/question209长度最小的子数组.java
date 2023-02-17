package Array;

//给定一个含有n个正整数的数组和一个正整数 target 。
//
//找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
//
//
//示例 1：
//
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组[4,3]是该条件下的长度最小的子数组。
//示例 2：
//
//输入：target = 4, nums = [1,4,4]
//输出：1
//示例 3：
//
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
//
//提示：
//
//1 <= target <= 109
//1 <= nums.length <= 105
//1 <= nums[i] <= 105
//
//进阶：
//
//如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
public class question209长度最小的子数组 {
    public static int minSubArrayLen(int target, int[] nums) {
        int L = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        //外层循环为右指针的遍历，每次达不到目标数就往右扩容增值
        for (int R = 0; R < nums.length; R++) {
            sum += nums[R];
            //内层循环为左指针的遍历，达到目标就往右减值

            //这个位置的边界条件为什么一定要带=号呢
            //如果不带=号，符合条件target==sum时没计算min，所以会导致结果为最小值+1
            while (target<=sum){
                min = Math.min(min,R-L+1);
                sum -= nums[L++];
            }
        }
        return Integer.MAX_VALUE==min?0:min;
    }

    public static void main(String[] args) {
        int []nums = {2,3,1,2,4,3,1};
        System.out.println(minSubArrayLen(7,nums));
    }
}
