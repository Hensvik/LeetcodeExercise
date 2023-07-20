package Array.BinarySearch;

//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
//如果数组中不存在目标值 target，返回[-1, -1]。
//你必须设计并实现时间复杂度为O(log n)的算法解决此问题。
//
//示例 1：
//
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4]
//示例2：
//
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1]
//示例 3：
//
//输入：nums = [], target = 0
//输出：[-1,-1]
//
//提示：
//
//0 <= nums.length <= 105
//-109<= nums[i]<= 109
//nums是一个非递减数组
//-109<= target<= 109

public class question34在排序数组中查找元素的第一个和最后一个位置 {

    //不确立左右开闭原则的话，很容易写成死循环或者交界位置无法处理
    public static int[] searchRange(int[] nums, int target) {
        int []res = {-1,-1};

        int L = 0;
        int R = nums.length-1;

        while(L<=R){
            int mid = (L+R)/2;
            if(nums[mid]<target){
                L = mid+1;
            }else{
                R = mid-1;
            }
        }

        res[0]=L;
        res[1]=R;
        return res;
    }

    public static void main(String[] args) {
        int []nums = {5,7,7,8,8,10};
        searchRange(nums,8);
    }
}
