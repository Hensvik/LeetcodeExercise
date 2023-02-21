package MapAndSet;

//给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：
//
//0 <= a, b, c, d< n
//a、b、c 和 d 互不相同
//nums[a] + nums[b] + nums[c] + nums[d] == target
//你可以按 任意顺序 返回答案 。
//
//示例 1：
//
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//示例 2：
//
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
//
//提示：
//
//1 <= nums.length <= 200
//-109 <= nums[i] <= 109
//-109 <= target <= 109

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class question18四数相加 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //结果集
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        //其实此处nums.length-n的条件并不太重要，因为就算left和right越界了，都会被while(right>left)的条件拦下来
        for (int i = 0; i < nums.length-3; i++) {

            // nums[i] > target 直接返回, 剪枝操作
            if (nums[i] > 0 && nums[i] > target) {
                return result;
            }

            if (i > 0 && nums[i - 1] == nums[i]) {    // 对nums[i]去重
                continue;
            }

            for (int j = i+1; j < nums.length-2; j++) {

                if (j > i + 1 && nums[j - 1] == nums[j]) {  // 对nums[j]去重
                    continue;
                }

                //如果前两位已经大于零，且数组由于已排序过的缘故，必定无解
                //nums[i]+nums[j]>=0的条件可以简化为nums[j]>=0
                if(nums[i]+nums[j]>target && nums[i]+nums[j]>=0){
                    break;
                }

                int left = j+1;
                int right = nums.length-1;
                while(right>left){
                    int sum = nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum>target){
                        right--;
                    } else if (sum < target) {
                        left++;
                    }else{
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
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
        }
        return result;
    }
}
