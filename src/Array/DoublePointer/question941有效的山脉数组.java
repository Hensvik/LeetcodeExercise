package Array.DoublePointer;

//给定一个整数数组 arr，如果它是有效的山脉数组就返回true，否则返回 false。
//让我们回顾一下，如果 arr满足下述条件，那么它是一个山脉数组：
//
//arr.length >= 3
//在0 < i< arr.length - 1条件下，存在i使得：
//arr[0] < arr[1] < ... arr[i-1] < arr[i]
//arr[i] > arr[i+1] > ... > arr[arr.length - 1]
//
//示例 1：
//
//输入：arr = [2,1]
//输出：false
//示例 2：
//
//输入：arr = [3,5,5]
//输出：false
//示例 3：
//
//输入：arr = [0,3,2,1]
//输出：true
//
//
//提示：
//
//1 <= arr.length <= 104
//0 <= arr[i] <= 104

public class question941有效的山脉数组 {
    public static boolean validMountainArray(int[] arr) {
        int len = arr.length;

        if(len<3){
            return false;
        }

        int left = 0;
        int right = arr.length-1;

        while (left<right){
            if(arr[left]<arr[left+1]){
                left++;
            }else if(arr[right-1]>arr[right]){
                right--;
            }else{
                return false;
            }
        }

        if(left!=0 && right != arr.length-1){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        int []arr = {0,1,2,3,4,8,9,10,11,12,11};
        validMountainArray(arr);
    }
}
