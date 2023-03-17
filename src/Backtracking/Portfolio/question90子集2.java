package Backtracking.Portfolio;

//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
//解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
//
//示例 1：
//
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
//示例 2：
//
//输入：nums = [0]
//输出：[[],[0]]
//
//提示：
//
//1 <= nums.length <= 10
//-10 <= nums[i] <= 10

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class question90子集2 {
    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    static boolean[] used;
    //自己写的
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        used = new boolean[nums.length];
        Arrays.fill(used,false);
        Arrays.sort(nums);
        backTracking(nums,0);
        return res;
    }

    public static void backTracking(int[] nums,int index){
        res.add(new ArrayList<>(path));
        if(index>=nums.length){ //终止条件可以不加
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if(i>0 && nums[i]==nums[i-1] && used[i-1]==false){
                continue;
            }
            used[i]=true;
            path.add(nums[i]);
            backTracking(nums,i+1);
            used[i]=false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int []nums = {1,2,2};
        subsetsWithDup(nums);
    }
}
