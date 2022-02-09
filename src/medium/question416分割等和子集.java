package medium;

//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
// 
//
//示例 1：
//
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。
//示例 2：
//
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
//提示：
//
//1 <= nums.length <= 200
//1 <= nums[i] <= 100
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class question416分割等和子集 {
    public static boolean canPartition(int[] nums) {
        int[] dp = new int[20001];
        int sum=0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }

        int target=sum/2;

        for(int i=0;i<nums.length;i++){   //遍历数组长度
            for(int j=target;j>=nums[i];j--){   //从大到小遍历，否则会重复遍历某个物品
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }

        if (dp[target] == target) return true;
        return false;
    }

    public static void main(String[] args) {
        int[] nums={1,5,11,5};
        canPartition(nums);
    }
}
