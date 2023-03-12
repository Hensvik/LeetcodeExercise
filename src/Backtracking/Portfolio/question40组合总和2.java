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
import java.util.LinkedList;
import java.util.List;

public class question40组合总和2 {
    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    //自己写的，会存在重复结果，因为candidate中存在两个1，所以会出现两个1,7
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
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

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        combinationSum2(candidates,8);
    }
}
