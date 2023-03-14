package Backtracking.Portfolio;

//给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
//数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
//
//示例 1：
//
//输入：nums = [4,6,7,7]
//输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
//示例 2：
//
//输入：nums = [4,4,3,2,1]
//输出：[[4,4]]
//
//提示：
//
//1 <= nums.length <= 15
//-100 <= nums[i] <= 100

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class question491递增子序列 {
    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    public static List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums,0);
        return res;
    }

    public static void backtracking(int[] nums,int index){
        if(index==nums.length && path.size()>=2){
            res.add(path);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums,i+1);
            path.removeLast();
        }
    }
}
