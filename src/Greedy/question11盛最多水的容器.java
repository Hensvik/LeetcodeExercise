package Greedy;

//给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
//找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
//返回容器可以储存的最大水量。
//说明：你不能倾斜容器。
//
//示例 1：
//
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。
//示例 2：
//
//输入：height = [1,1]
//输出：1
//
//
//提示：
//
//n == height.length
//2 <= n <= 105
//0 <= height[i] <= 104

public class question11盛最多水的容器 {

    //自己写的
    public static int maxArea(int[] height) {
        int L=0;
        int R=height.length-1;
        int max=0;
        while(L<R){
            int low = Math.min(height[L],height[R]);
            max = Math.max(max,low*(R-L));

            if(height[L]<height[R]){
                L++;
            }else if(height[L]>height[R]){
                R--;
            }else{
                L++;
                R--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int []height = new int[]{1,8,6,2,5,4,8,3,7};
        maxArea(height);
    }
}
