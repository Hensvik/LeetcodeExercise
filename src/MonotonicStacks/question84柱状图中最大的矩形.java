package MonotonicStacks;

//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//求在该柱状图中，能够勾勒出来的矩形的最大面积。
//
//示例 1:
//
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
//示例 2：
//
//输入： heights = [2,4]
//输出： 4
//
//提示：
//
//1 <= heights.length <=105
//0 <= heights[i] <= 104

import java.util.Stack;

public class question84柱状图中最大的矩形 {
    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] minLeftIndex = new int[len];
        int[] minRightIndex = new int[len];

        // 记录每个柱子 左边第一个小于该柱子的下标
        minLeftIndex[0] = -1; // 注意这里初始化，防止下面while死循环
        for (int i = 1; i < len; i++) {
            int t = i - 1;
            // 这里不是用if，而是不断向左寻找的过程
            while (t >= 0 && heights[t] >= heights[i]) t = minLeftIndex[t];
            minLeftIndex[i] = t;
        }

        // 记录每个柱子 右边第一个小于该柱子的下标
        // 从右往左
        minRightIndex[len - 1] = len; // 注意这里初始化，防止下面while死循环
        for (int i = len - 2; i >= 0; i--) {
            int t = i + 1;
            // 这里不是用if，而是不断向右寻找的过程
            while (t < len && heights[t] >= heights[i]) t = minRightIndex[t];
            minRightIndex[i] = t;
        }

        // 求和
        int result = 0;
        for (int i = 0; i < len; i++) {
            int sum = heights[i] * (minRightIndex[i] - minLeftIndex[i] - 1);
            result = Math.max(sum, result);
        }
        return result;
    }

    //单调栈
    int largestRectangleArea2(int[] heights) {
        Stack<Integer> st = new Stack<Integer>();

        // 数组扩容，在头和尾各加入一个元素
        int [] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++){
            newHeights[index + 1] = heights[index];
        }

        heights = newHeights;

        st.push(0);
        int result = 0;
        // 第一个元素已经入栈，从下标1开始
        for (int i = 1; i < heights.length; i++) {
            // 注意heights[i] 是和heights[st.top()] 比较 ，st.top()是下标
            if (heights[i] > heights[st.peek()]) {
                st.push(i);
            } else if (heights[i] == heights[st.peek()]) {
                st.pop(); // 这个可以加，可以不加，效果一样，思路不同
                st.push(i);
            } else {
                while (heights[i] < heights[st.peek()]) { // 注意是while
                    int mid = st.peek();
                    st.pop();
                    int left = st.peek();
                    int right = i;
                    int w = right - left - 1;
                    int h = heights[mid];
                    result = Math.max(result, w * h);
                }
                st.push(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int []heights = {2,1,5,6,2,3};
        largestRectangleArea(heights);
    }
}
