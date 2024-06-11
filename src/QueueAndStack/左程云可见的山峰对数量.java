package QueueAndStack;

//不含重复数据的数组中，收尾相连为环形山峰数组，数字代表高度，找出所有山峰对，即：一个山峰对为：一个山峰，另一个山峰比它高，且中间没有比二者更高的的山峰则代表能看见

//进阶：数组含重复数据

import java.util.Stack;

public class 左程云可见的山峰对数量 {

    //进阶问题解法
    public int getVisibleNum(int[] arr){
        if(arr == null || arr.length < 2){
            return 0;
        }
        int size = arr.length;
        int maxIndex = 0;
        // 先在环中找到其中一个最大值的位置，哪一个都行
        for(int i = 0; i < size; i++){
            maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;
        }

        Stack<Record> stack = new Stack<Record>();

        // 先把（最大值，1）入栈
        stack.push(new Record(arr[maxIndex],1));
        // 从最大值位置的下一个位置沿next方向遍历
        int index = nextIndex(maxIndex,size);
        // 用"小找大"的方式统计所有可见山峰对
        int res = 0;
        // 遍历阶段开始，当index再次回到maxIndex的时候，说明转了一圈，遍历阶段结束
        while(index != maxIndex){
            // 当前数字arr[index]要进栈，判断会不会破坏第一维的数字从顶到底依次变大
            // 如果破坏了，就一次弹出栈顶记录，并计算山峰对数量
            while(stack.peek().height < arr[index]){
                int k = stack.pop().count;
                // 弹出记录为(X,K)如果k==1，产生2对山峰对
                // 如果K>1，产生2*K + C(2,K)对
                res += getInternalSum(k) + 2*k;
            }
            // 当前数字arr[index]要进入栈了，如果和当前栈顶数字一样就合并
            // 不一样就把记录(arr[index],1)放入栈中
            if(stack.peek().height == arr[index]){
                stack.peek().count++;
            }else{
                stack.push(new Record(arr[index],1));
            }
            index = nextIndex(index,size);
        }
        // 清算阶段开始
        // 清算阶段第1小阶段
        while(stack.size() > 2){
            int count = stack.pop().count;
            res += getInternalSum(count) + 2*count;
        }
        // 清算阶段第2小阶段
        while(stack.size() > 1){
            int count = stack.pop().count;
            res += getInternalSum(count) + (stack.peek().count == 1 ? count:2*count);
        }
        // 清算阶段第3小阶段
        res += getInternalSum(stack.pop().count);
        return res;
    }

    // 如果k==1，返回0；如果k>1，返回(2,k)
    public int getInternalSum(int k){
        return k == 1 ? 0 : (k*(k-1)/2);
    }

    // 环形数组中当前位置为i，数组长度为sie，返回i的下一个位置
    public int nextIndex(int i,int size){
        return i < (size -1) ? (i+1) : 0;
    }

    public static class Record{
        public int height;
        public int count;
        public Record(int height, int count){
            this.height = height;
            this.count = count;
        }
    }
}
