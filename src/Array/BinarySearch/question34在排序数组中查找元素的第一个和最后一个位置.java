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
        int left = 0;
        int right = nums.length - 1;
        int first = -1;
        int last = -1;
        // 找第一个等于target的位置
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                //由于目标是找起始位置，所以此处设置first=middle，表示起始位置可能为mid或mid左侧
                first = middle;
                right = middle - 1; //重点
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        // 最后一个等于target的位置
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                //由于目标是找结束位置，所以此处设置last=middle，表示结束位置可能为mid或mid右侧
                last = middle;
                left = middle + 1; //重点
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return new int[]{first, last};
    }



    public static void main(String[] args) {
        int []nums = {5,7,7,8,8,10};
        searchRange(nums,8);
    }
}
