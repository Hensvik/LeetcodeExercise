package Backtracking.Arrangement;

//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//示例 1：
//
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
//示例 2：
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
//提示：
//
//1 <= nums.length <= 8
//-10 <= nums[i] <= 10

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class question47全排列2 {
    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    static boolean[] used;
    public static List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        backTracking(nums);
        return res;
    }

    private static void backTracking(int[] nums) {
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(used[i]){
                continue;
            }
            used[i]=true;
            path.add(nums[i]);
            backTracking(nums);
            path.removeLast();
            used[i]=false;
        }
    }

    public static void main(String[] args) {
        int []nums = {1,1,2};
        permuteUnique(nums);
    }
}
