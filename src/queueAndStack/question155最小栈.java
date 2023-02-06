package queueAndStack;

//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
//实现 MinStack 类:
//
//MinStack() 初始化堆栈对象。
//void push(int val) 将元素val推入堆栈。
//void pop() 删除堆栈顶部的元素。
//int top() 获取堆栈顶部的元素。
//int getMin() 获取堆栈中的最小元素。

//示例 1:

//输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.

import java.util.Stack;

public class question155最小栈 {

    private ListNode head;

    public void push(int val) {
        if(head != null){
            head = new ListNode(val,val,null);
        }else{
            head = new ListNode(val,Math.min(val,head.min),head);
        }
    }

    public void pop() {
        if(head == null){
            throw new IllegalStateException("栈为空");
        }else{
            head = head.next;
        }
    }

    public int top() {
        if(head == null){
            throw new IllegalStateException("栈为空");
        }else{
            return head.val;
        }
    }

    public int getMin() {
        if(head == null){
            throw new IllegalStateException("栈为空");
        }else{
            return head.min;
        }
    }
}

class ListNode{
    public int val;
    public int min;
    public ListNode next;

    public ListNode(int val,int min,ListNode next){
        this.val = val;
        this.min = min;
        this.next = next;
    }
}

//以下是官方使用栈实现的方法
class MinStack {
    private Stack<StackNode> stack = new Stack<>();

    //压栈
    public void push(int x) {
        if (empty()) {
            stack.push(new StackNode(x, x));
        } else {
            stack.push(new StackNode(x, Math.min(x, getMin())));
        }
    }

    //出栈
    public void pop() {
        if (empty())
            throw new IllegalStateException("栈为空……");
        stack.pop();
    }

    public int top() {
        if (empty())
            throw new IllegalStateException("栈为空……");
        return stack.peek().val;
    }

    public int getMin() {
        if (empty())
            throw new IllegalStateException("栈为空……");
        return stack.peek().min;
    }

    //判断栈是否为空
    private boolean empty() {
        return stack.isEmpty();
    }
}

class StackNode {
    public int val;
    public int min;

    public StackNode(int val, int min) {
        this.val = val;
        this.min = min;
    }
}