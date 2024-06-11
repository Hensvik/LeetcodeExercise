package QueueAndStack;

//给定一个整型矩阵map，其中的值只有0和1两种，求其中全是1的所有矩形区域中，最大的矩形区域为1的数量

import java.util.Stack;

public class 左程云求最大矩阵的大小 {

    public int maxRecSize(int[][] map){
        if(map == null || map.length == 0 || map[0].length == 0){
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];
        //以每行为切面，统计如果以当前行开始为1的位置，往上的值也为1的高度
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            //将每个height[j]进行查询
            maxArea = Math.max(maxRecFromBottom(height),maxArea);
        }
        return maxArea;
    }

    public int maxRecFromBottom(int[] height){
        if(height == null || height.length == 0){
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        //遍历height，如果当前值大于等于栈顶，则入栈，否则出栈，直到当前值小于栈顶
        for(int i = 0; i < height.length; i++){
            while(!stack.isEmpty() && height[stack.peek()] > height[i]){
                int j = stack.pop();
                //在某个元素出栈时，计算以当前元素为高的矩形面积，如果栈为空，

                //左边为栈的前一个元素+1，表示以当前高度最远往左能延申到的位置
                int left = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - left - 1) * height[j];
                maxArea = Math.max(maxArea,curArea);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int j = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (height.length - left - 1) * height[j];
            maxArea = Math.max(maxArea,curArea);
        }
        return maxArea;
    }
}
