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
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class question47全排列2 {
    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    static boolean[] used;
    public static List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        //所有填充为false
        Arrays.fill(used, false);
        Arrays.sort(nums);
        backTracking(nums,used);
        return res;
    }

    private static void backTracking(int[] nums, boolean[] used) {
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // used[i - 1] == true，说明同⼀树⽀nums[i - 1]使⽤过
            // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过
            // 如果同⼀树层nums[i - 1]使⽤过则直接跳过
            //如果和前一位相等并且前一位为false(没有使用改数字)
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            // used[i - 1] == true，说明同一树枝nums[i - 1]使用过
            // used[i - 1] == false，说明同一树层nums[i - 1]使用过
            // 如果同一树层nums[i - 1]使用过则直接跳过
            if (used[i] == false) {
                used[i] = true;//标记同⼀树⽀nums[i]使⽤过，防止同一树枝重复使用
                path.add(nums[i]);
                backTracking(nums, used);
                path.remove(path.size() - 1);//回溯，说明同⼀树层nums[i]使⽤过，防止下一树层重复
                used[i] = false;//回溯
            }
        }
    }

    public static void main(String[] args) {
        int []nums = {1,1,2};
        permuteUnique(nums);
    }
}
