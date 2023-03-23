package Greedy.Interval;

//给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
//注意:
//
//可以认为区间的终点总是大于它的起点。
//区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
//示例 1:
//
//输入: [ [1,2], [2,3], [3,4], [1,3] ]
//
//输出: 1
//
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
//示例 2:
//
//输入: [ [1,2], [1,2], [1,2] ]
//
//输出: 2
//
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
//示例 3:
//
//输入: [ [1,2], [2,3] ]
//
//输出: 0
//
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。

import java.util.Arrays;
import java.util.Comparator;

public class question435无重叠区间 {
    //左程云
    public static int eraseOverlapIntervals1(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }

        //先按照右边界排序，再按照左边界排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return Integer.compare(o1[1],o2[1]);
                } else {
                    return Integer.compare(o1[0],o2[0]);
                }
            }
        });

        int count = 1;
        int edge = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (edge <= intervals[i][0]){
                count ++; //non overlap + 1
                edge = intervals[i][1];
            }
        }
        return intervals.length - count;
    }

    //自己写的，但是效率好像有一点低
    public static int eraseOverlapIntervals2(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> {
            return Integer.compare(a[0],b[0]);
        });

        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]<intervals[i-1][1]){
                count++;
                //此题贪心指的是当两个区间有交集时，取右区间小的，这样可以尽可能保证下次不会有交集
                intervals[i][1] = Math.min(intervals[i-1][1],intervals[i][1]);
            }
        }
        return count;
    }

    //代码随想录
    public int eraseOverlapIntervals3(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> {
            return Integer.compare(a[0],b[0]);
        });
        //count表示
        int count = 1;
        for(int i = 1;i < intervals.length;i++){
            //如果左边界与前一个区间的有边界相交
            if(intervals[i][0] < intervals[i-1][1]){
                //将当前区间的右边界设置为二者最小
                intervals[i][1] = Math.min(intervals[i - 1][1], intervals[i][1]);
                continue;
            }else{
                //否则count++
                count++;
            }
        }
        return intervals.length - count;
    }



    public static void main(String[] args) {
        int[][] intervals={{1,2},{2,3},{3,4},{1,3}};
        eraseOverlapIntervals2(intervals);
    }
}
