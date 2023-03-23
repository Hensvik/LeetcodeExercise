package Greedy.Interval;

//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
// 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
//
//示例 1：
//
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//示例2：
//
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
//
//提示：
//
//1 <= intervals.length <= 104
//intervals[i].length == 2
//0 <= starti <= endi <= 104

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class question56合并区间 {
    public static int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]<o2[1]){
                    return -1;
                }else{
                    return 1;
                }
            }
        });

        int rightEdge=intervals[0][1];
        int leftEdge=intervals[0][0];
        Boolean last=false;
        for(int i=0;i< intervals.length;i++){
            if(rightEdge>=intervals[i][0]){
                rightEdge = Math.max(rightEdge,intervals[i][1]);
                leftEdge = Math.min(leftEdge,intervals[i][0]);
                if(i== intervals.length-1){
                    last=true;
                }
            }else{
                list.add(new int[]{leftEdge,rightEdge});
                leftEdge= intervals[i][0];
                rightEdge= intervals[i][1];
            }
        }
        if(!last){
            list.add(new int[]{leftEdge,rightEdge});
        }

        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        merge(intervals);
    }
}
