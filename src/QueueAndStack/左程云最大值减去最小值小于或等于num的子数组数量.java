package QueueAndStack;

//给定数组arr和整数num，共返回有多少个子数组满足如下情况
//max(arr[i...j])-min(arr[i...j]) <= num
//max(arr[i...j])表示子数组arr[i...j]中的最大值，min(arr[i...j])表示子数组arr[i...j]中的最小值

import java.util.LinkedList;

public class 左程云最大值减去最小值小于或等于num的子数组数量 {
    public static int getNum(int[] arr, int num) {
        if(arr == null || arr.length == 0 || num < 0){
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        int i = 0;
        int j = 0;
        int res = 0;
        while(i < arr.length){
            while(j < arr.length){
                if (qmin.isEmpty() || qmin.peekLast() != j){
                    //如果qmin不为空 且 最后一个元素大于等于arr[j]，则弹出
                    while(!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]){
                        qmin.pollLast();
                    }
                    qmin.addLast(j);
                    //如果qmax不为空 且 最后一个元素小于等于arr[j]，则弹出
                    while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]){
                        qmax.pollLast();
                    }
                    qmax.addLast(j);
                }
                //如果qmax的所维护的数组的最大值 - qmin的所维护的数组的最小值 大于num，则说明不符合条件，跳出循环
                if(arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num){
                    break;
                }
                j++;
            }
            //因为每次j都是从0开始统计，只是i是在递增的，所以j-1就是i到j-1的子数组数量
            res += j-1;
            if(qmin.peekFirst() == i){
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == i){
                qmax.pollFirst();
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, 6};
        System.out.println(getNum(arr, 7));
    }
}
