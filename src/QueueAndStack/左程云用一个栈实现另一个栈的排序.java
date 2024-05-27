package QueueAndStack;

import java.util.Stack;

/**
 * 要求栈顶到栈底 由大到小
 * 可以申请一个栈和新的变量，但不能申请额外的数据结构
 */

public class 左程云用一个栈实现另一个栈的排序 {

    public static void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()){
            Integer cur = stack.pop();
            //当help不为空，并且help顶端的值大于cur，则将help顶端的值取出来放进stack，然后将cur放入help
            while (!help.isEmpty() && help.peek() > cur){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(4);
        stack.push(3);
        stack.push(6);
        stack.push(5);
        sortStackByStack(stack);
        System.out.println(stack);
    }
}
