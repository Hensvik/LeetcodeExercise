package MapAndSet;

//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
//
//你返回所有和为 0 且不重复的三元组。
//
//注意：答案中不可以包含重复的三元组。
//
//示例 1：
//
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
//示例 2：
//
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
//示例 3：
//
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0
//
//提示：
//3 <= nums.length <= 3000
//-105 <= nums[i] <= 105
//

//https://programmercarl.com/0015.%E4%B8%89%E6%95%B0%E4%B9%8B%E5%92%8C.html#%E5%8F%8C%E6%8C%87%E9%92%88

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class question15三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        //结果集
        List<List<Integer>> result = new ArrayList<>();
        //先做排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //如果排序后的首位就大于0，则不可能满足题目要求，不存在符合条件的结果集
            if(nums[0]>0){
                return result;
            }

            //a的去重操作
            if(i>0&&nums[i] == nums[i-1]){
                continue;
            }

            int left = i+1;
            int right = nums.length-1;
            while(right>left){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum>0){
                    right--;
                }else if(sum<0){
                    left++;
                }else{
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //b和c的去重需要在找到某个符合条件的结果之后
                    //注意此时比较的时候是当前节点与后一个节点对比，因此不进入条件的话，需要手动--或者++
                    while(right>left && nums[right]==nums[right-1]){
                        right--;
                    }
                    while(right>left && nums[left]==nums[left+1]){
                        left++;
                    }
                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
