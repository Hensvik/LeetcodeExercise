package MonotonicStacks;

//给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，其中answer[i]是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用0 来代替。
//
//示例 1:
//
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出:[1,1,4,2,1,1,0,0]
//示例 2:
//
//输入: temperatures = [30,40,50,60]
//输出:[1,1,1,0]
//示例 3:
//
//输入: temperatures = [30,60,90]
//输出: [1,1,0]
//
//提示：
//
//1 <=temperatures.length <= 105
//30 <=temperatures[i]<= 100

import java.util.Deque;
import java.util.LinkedList;

//那有同学就问了，我怎么能想到用单调栈呢？ 什么时候用单调栈呢？
//通常是一维数组，要寻找任一个元素的右边或者左边第一个比自己大或者小的元素的位置，此时我们就要想到可以用单调栈了。时间复杂度为O(n)。

public class question739每日温度 {
    public int[] dailyTemperatures(int[] temperatures) {
        int lens=temperatures.length;
        int []res=new int[lens];

        /**
         如果当前遍历的元素 大于栈顶元素，表示 栈顶元素的 右边的最大的元素就是 当前遍历的元素，
         所以弹出 栈顶元素，并记录
         如果栈不空的话，还要考虑新的栈顶与当前元素的大小关系
         否则的话，可以直接入栈。
         注意，单调栈里 加入的元素是 下标。
         */

        Deque<Integer> stack=new LinkedList<>();
        stack.push(0);
        for(int i=1;i<lens;i++){
            if(temperatures[i]<=temperatures[stack.peek()]){
                stack.push(i);
            }else{
                while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                    res[stack.peek()]=i-stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return  res;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int lens=temperatures.length;
        int []res=new int[lens];
        Deque<Integer> stack=new LinkedList<>();
        for(int i=0;i<lens;i++){

            while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                res[stack.peek()]=i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        return  res;
    }
}
