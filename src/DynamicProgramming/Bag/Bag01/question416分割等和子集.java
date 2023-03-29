package DynamicProgramming.Bag.Bag01;

//给你一个 只包含正整数 的 非空 数组nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
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
//提示：
//
//1 <= nums.length <= 200
//1 <= nums[i] <= 100

public class question416分割等和子集 {

    //一维数组写法
    public static boolean canPartition(int[] nums) {
        int[] dp = new int[20001];
        int sum=0;

        //求和，做剪枝操作，如果是奇数，返回false
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }

        //只要里面的元素能达到目标值sum/2，就说明是true
        int target=sum/2;

        for(int i=0;i<nums.length;i++){   //遍历数组长度
            for(int j=target;j>=nums[i];j--){   //从大到小遍历，否则会重复遍历某个物品
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }

        if (dp[target] == target) return true;
        return false;
    }

    //二维数组写法
    public boolean canPartition2(int[] nums) {
        int len = nums.length;
        // 题目已经说非空数组，可以不做非空判断
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 特判：如果是奇数，就不符合要求
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        boolean[][] dp = new boolean[len][target + 1];

        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        // 再填表格后面几行
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                // 直接从上一行先把结果抄下来，然后再修正
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][target];
    }

    public static void main(String[] args) {
        int[] nums={1,5,11,5};
        canPartition(nums);
    }
}
