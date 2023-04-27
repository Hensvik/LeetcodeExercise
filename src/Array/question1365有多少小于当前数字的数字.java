package Array;

//给你一个数组nums，对于其中每个元素nums[i]，请你统计数组中比它小的所有数字的数目。
//换而言之，对于每个nums[i]你必须计算出有效的j的数量，其中 j 满足j != i 且 nums[j] < nums[i]。
//以数组形式返回答案。
//
//示例 1：
//
//输入：nums = [8,1,2,2,3]
//输出：[4,0,1,1,3]
//解释： 
//对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。 
//对于 nums[1]=1 不存在比它小的数字。
//对于 nums[2]=2 存在一个比它小的数字：（1）。 
//对于 nums[3]=2 存在一个比它小的数字：（1）。 
//对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
//示例 2：
//
//输入：nums = [6,5,4,8]
//输出：[2,1,0,3]
//示例 3：
//
//输入：nums = [7,7,7,7]
//输出：[0,0,0,0]
//
//提示：
//
//2 <= nums.length <= 500
//0 <= nums[i] <= 100

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class question1365有多少小于当前数字的数字 {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int []res = Arrays.copyOf(nums,len);
        Arrays.sort(res);

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (!map.containsKey(res[i])) { // 遇到了相同的数字，那么不需要更新该 number 的情况
                map.put(res[i], i);
            }
        }

        for (int i = 0; i < len; i++) {
            res[i]=map.get(nums[i]);
        }
        return res;
    }

    public static int[] smallerNumbersThanCurrent2(int[] nums) {
        int[] arrays = new int[101];
        //出现某个数，arrays的那一位就加一
        for (int num : nums)
            arrays[num] += 1;
        //从1开始遍历，array加上前一位的值
        for (int i = 1; i < arrays.length; i++)
            arrays[i] += arrays[i - 1];
        //从0开始遍历nums，如果 某一位不为0，则将array对应前一位的值赋值，否则置为0
        for (int i = 0; i < nums.length; i++)
            nums[i] = nums[i] != 0 ? arrays[nums[i] - 1] : 0;
        return nums;
    }

    public static void main(String[] args) {
        int []nums = {8,1,2,2,3};
        smallerNumbersThanCurrent2(nums);
    }
}
