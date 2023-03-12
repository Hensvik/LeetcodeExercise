package Backtracking.Portfolio;

//给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
//candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
//对于给定的输入，保证和为target 的不同组合数少于 150 个。
//
//示例1：
//输入：candidates = [2,3,6,7], target = 7
//输出：[[2,2,3],[7]]
//解释：
//2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
//7 也是一个候选， 7 = 7 。
//仅有这两种组合。
//
//示例2：
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]]
//示例 3：
//
//输入: candidates = [2], target = 1
//输出: []
//
//提示：
//
//1 <= candidates.length <= 30
//2 <= candidates[i] <= 40
//candidates 的所有元素 互不相同
//1 <= target <= 40

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class question39组合总和 {
    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            combineHelper(candidates,target,tempSum,i);
            tempSum-=candidates[i];
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int []candidates = {2,3,5};
        combinationSum(candidates,7);
    }
}
