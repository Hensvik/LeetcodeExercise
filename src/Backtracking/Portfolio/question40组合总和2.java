package Backtracking.Portfolio;

//给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
//
//candidates中的每个数字在每个组合中只能使用一次。
//
//注意：解集不能包含重复的组合。
//
//示例1:
//
//输入: candidates =[10,1,2,7,6,1,5], target =8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
//示例2:
//
//输入: candidates =[2,5,2,1,2], target =5,
//输出:
//[
//[1,2,2],
//[5]
//]
//
//提示:
//
//1 <=candidates.length <= 100
//1 <=candidates[i] <= 50
//1 <= target <= 30

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class question40组合总和2 {
    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    //自己写的，会存在重复结果，因为candidate中存在两个1，所以会出现两个1,7
    public static List<List<Integer>> combinationSum21(int[] candidates, int target) {
        combineHelper(candidates,target,0,0);
        return res;
    }

    public static void combineHelper(int[] candidates,int target,int tempSum,int index){
        if(target==tempSum){
            res.add(new ArrayList<>(path));
            return;
        }

        if(target<tempSum){
            return;
        }

        //index也必须要传，如果不传index置为0的话，会出现比如 [2,5] [5,2]的重复情况
        for (int i = index; i < candidates.length; i++) {
            tempSum+=candidates[i];
            path.add(candidates[i]);
            combineHelper(candidates,target,tempSum,i+1);
            tempSum-=candidates[i];
            path.removeLast();
        }
    }

    //代码随想录 使用标记数组去重版本
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] used;
    int sum = 0;

    public List<List<Integer>> combinationSum22(int[] candidates, int target) {
        used = new boolean[candidates.length];
        // 加标志数组，用来辅助判断同层节点是否已经遍历
        Arrays.fill(used, false);
        // 为了将重复的数字都放到一起，所以先进行排序
        Arrays.sort(candidates);
        backTracking(candidates, target, 0);
        return ans;
    }

    private void backTracking(int[] candidates, int target, int startIndex) {
        if (sum == target) {
            ans.add(new ArrayList(path));
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            // 出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            sum += candidates[i];
            path.add(candidates[i]);
            // 每个节点仅能选择一次，所以从下一位开始
            backTracking(candidates, target, i + 1);
            used[i] = false;
            sum -= candidates[i];
            path.removeLast();
        }
    }



    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        //combinationSum2(candidates,8);
    }
}
