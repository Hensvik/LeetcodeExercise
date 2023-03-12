package Backtracking.Portfolio;

//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//
//你可以按 任何顺序 返回答案。
//
//示例 1：
//
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
//示例 2：
//
//输入：n = 1, k = 1
//输出：[[1]]
//
//
//提示：
//
//1 <= n <= 20
//1 <= k <= n

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class question77组合 {
    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        combineHelper(n, k, 1);
        return res;
    }

    public static void combineHelper(int n,int k,int start){
        //终止条件
        if(path.size()==k){
            res.add(path);
            return;
        }
        //小于的条件可以优化：当离k还差若干，但n已经不满足时
        for (int i = start; i <= n - (k - path.size()) + 1; i++){
            path.add(i);
            combineHelper(n, k, i + 1);
            path.removeLast();
        }
        /*for (int i = start; i <= n; i++) {
            path.add(i);
            combineHelper(n,k,start+1);
            path.removeLast();
        }*/
    }
}
