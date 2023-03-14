package Backtracking.Portfolio;

//给你一个整数数组nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
//
//示例 1：
//
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//示例 2：
//
//输入：nums = [0]
//输出：[[],[0]]
//
//提示：
//
//1 <= nums.length <= 10
//-10 <= nums[i] <= 10
//nums 中的所有元素 互不相同

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class question78子集 {
    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        combineHelper(nums,0);
        return res;
    }

    public static void combineHelper(int[] nums,int index){
        res.add(new ArrayList<>(path));
        if(index>=nums.length){ //终止条件可以不加
            return;
        }

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            combineHelper(nums,i+1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int []nums = {1,2,3};
        subsets(nums);
    }
}
