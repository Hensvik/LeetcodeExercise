package Backtracking.Portfolio;

//回溯问题通用解题模板

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BacktrackingModel {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();  //初始化为LinkedList才可以removeLast
    public List<List<Integer>> solution(int[] nums) {
        backtracking(nums,0);
        return res;
    }

    public void backtracking(int[] nums,int index){
        if(index==nums.length){
            //某些问题在边界到达后还需要做额外条件处理，详情question17
            res.add(new ArrayList<>(path));
            //此处的return取决于达到条件后需不需要继续往下遍历
            return;
        }

        //i=index影响着同样的节点能否复用
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums,i+1);
            path.removeLast();
        }
    }
}
