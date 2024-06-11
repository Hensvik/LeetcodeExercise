package QueueAndStack;

//给定一个不含有重复值的数组arr，找到arr中每个元素右侧离它最近且比它小的元素，返回所有位置相应的信息
//如果一个元素右侧没有比它大的元素，则为-1

//进阶 数组arr的条件为含有重复值

import java.util.Stack;

public class 左程云单调栈结构 {

    //自己写的
    //时间复杂度为O(n)的写法
    public int[][] rightWay(int[] arr) {
        int[][] ans = new int[arr.length][2];
        Stack<Integer> stack = new Stack();
        //总遍历，遍历中保持stack中存储的值所代表的序号是 从栈顶到栈底 逐渐减小
        //如果stack为空，则插入
        //如果stack不为空，则比较，如果当前值大于栈顶值，则弹出，否则插入
        //弹出时进行必要的赋值
        for (int i = 0; i < arr.length; i++) {
            if(stack.isEmpty()){
                ans[i][0] = -1;
                stack.push(i);
            }else if(arr[i]>arr[stack.peek()]){
                ans[i][0] = stack.peek();
                stack.push(i);
            }else {
                while (!stack.isEmpty() && arr[i]<arr[stack.peek()]){
                    ans[stack.peek()][1] = i;
                    ans[stack.pop()][1]=i;
                }
                stack.push(i);
            }
        }

        //可能遍历完后栈不为空，剩余的数据需要额外处理
        //剩余所有的值的[][1]都为-1，因为右边没有比他们小的值
        //剩余所有的值的[0][]则为栈内的下一个值
        while (!stack.isEmpty()){
            int index = stack.pop();
            ans[index][1] = -1;
            if(stack.isEmpty()){
                ans[index][0] = -1;
            }else {
                ans[index][0] = stack.peek();
            }
        }
        return ans;
    }

    //时间复杂度为O(N^2)的写法，不是最优
    public int[][] rightWay2(int[] arr) {
        int[][] ans = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            int leftLessIndex = -1;
            int rightLessIndex = -1;

            int cur = i-1;
            while (cur >= 0) {
                if (arr[cur] < arr[i]) {
                    leftLessIndex = cur;
                    break;
                }
                cur--;
            }
            cur = i+1;
            while (cur < arr.length) {
                if (arr[cur] < arr[i]) {
                    rightLessIndex = cur;
                    break;
                }
                cur++;
            }
            ans[i][0] = leftLessIndex;
            ans[i][1] = rightLessIndex;
        }
        return ans;
    }

    //左的写法
    public int[][] rightWay3(int[] arr) {
        int[][] ans = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                //弹出一个元素进行逻辑判断
                int popIndex = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
                ans[popIndex][0] = leftLessIndex;
                ans[popIndex][1] = i;
            }
            stack.push(i);
        }
        //遍历完成后对剩余元素进行处理
        while (!stack.isEmpty()) {
            int popIndex = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
            ans[popIndex][0] = leftLessIndex;
            ans[popIndex][1] = -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 5, 6, 2, 7};
        int[][] ans = new 左程云单调栈结构().rightWay3(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + " " + ans[i][1]);
        }
    }
}
