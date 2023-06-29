package Array;

//给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
//
//示例 1：
//
//输入：nums = [10,5,2,6], k = 100
//输出：8
//解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
//需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
//示例 2：
//
//输入：nums = [1,2,3], k = 0
//输出：0
//
//提示:
//
//1 <= nums.length <= 3 * 104
//1 <= nums[i] <= 1000
//0 <= k <= 106

//与209问题类似，注意事项:0的情况

public class question713乘积小于K的子数组 {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int L = 0;
        int count = 0;
        int mul = nums[0];
        if(k>mul){
            count++;
        }

        for (int R = 1; R < nums.length; R++) {
            mul = mul * nums[R];
            if(k>mul){
                count++;
            }else{
                mul = mul/nums[L++];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 100;
        numSubarrayProductLessThanK(nums,k);
    }
}
