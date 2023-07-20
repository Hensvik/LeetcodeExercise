package MonotonicStacks;

//给定n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//示例 1：
//
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
//示例 2：
//
//输入：height = [4,2,0,3,2,5]
//输出：9
//
//提示：
//
//n == height.length
//1 <= n <= 2 * 104
//0 <= height[i] <= 105

import java.util.Stack;

public class question42接雨水 {

    //错误，横向计算没办法比较出2 0 2的情况
    public static int trap(int[] height) {
        int len = height.length;
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        stack.push(0);
        for (int i = 1; i < len; i++) {
            //如果栈为空 或 后一位比前一位小，则入栈
            if(stack.isEmpty() || height[i]<height[stack.peek()]){
                stack.push(i);
            }else if(height[i]==height[stack.peek()]) {
                stack.pop();
                stack.push(i);
            }else{
                while(!stack.isEmpty() && height[stack.peek()]<height[i]){

                    int mid = stack.pop();

                    if (!stack.isEmpty()){
                        int left = stack.peek();

                        int h = Math.min(height[left], height[i]) - height[mid];
                        int w = i - left - 1;
                        int hold = h * w;
                        if (hold > 0){
                            res += hold;
                        }
                        Integer stackTop = stack.peek();
                    }


                    int temp = stack.pop();
                    int heightTemp = height[temp];
                    res+=(i-temp-1)*Math.min(height[i],heightTemp);
                }
                stack.push(i);
            }
        }
        return res;
    }

    public static int trap2(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            // 第一个柱子和最后一个柱子不接水
            if(i==0 || i == height.length-1){
                continue;
            }

            int rHeight = height[i]; // 记录右边柱子的最高高度
            int lHeight = height[i]; // 记录左边柱子的最高高度
            for (int r = i+1; r < height.length; r++) {
                if(height[r] > rHeight){
                    rHeight = height[r];
                }
            }

            for (int l = i-1; l >= 0; l--) {
                if(height[l] < lHeight){
                    lHeight = height[l];
                }
            }

            //最小值减去当前高度，统计容量
            int h = Math.min(lHeight, rHeight) - height[i];
            if (h > 0) {
                sum += h;
            }
        }
        return sum;
    }

    //灵茶山做法1
    public static int trap3(int[] height){
        int n = height.length;
        int[] preMax = new int[n];  //表示从前数的最高高度
        int[] surMax = new int[n];  //表示从后数的最高高度
        preMax[0] = height[0];

        for (int i = 1; i < n; ++i) {
            //++i是因为第一个位置不会形成储水区
            preMax[i] = Math.max(preMax[i-1],height[i]);
        }

        surMax[n-1] = height[n-1];

        for (int i = n-2; i >= 0; --i) {
            //++i是因为第一个位置不会形成储水区
            surMax[i] = Math.max(surMax[i-1],height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.min(preMax[i],surMax[i])-height[i];
        }
        return ans;
    }

    //灵茶山做法2 双指针法
    public static int trap4(int[] height){
        int ans = 0;
        int L = 0;
        int R = height.length-1;
        int preMax = 0;
        int surMax = 0;

        while(L<=R){
            preMax = Math.max(preMax,height[L]);
            surMax = Math.max(surMax,height[R]);
            if(preMax<surMax){
                ans += preMax - height[L++];
            }else{
                ans += surMax - height[R--];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int []height = {0,1,0,2,1,0,1,3,2,1,2,1};
        trap4(height);
    }
}
