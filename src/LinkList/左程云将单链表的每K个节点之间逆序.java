package LinkList;

import java.util.Stack;

public class 左程云将单链表的每K个节点之间逆序 {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node reverseKNode1(Node head, int k) {
        if (k<=1){
            return head;
        }
        Stack<Node> stack = new Stack<>();
        Node newHead = head;
        Node cur = head;
        Node pre = null;
        Node next = null;
        while(cur != null){
            next = cur.next;
            stack.push(cur);
            if(stack.size() == k){
                pre = resign1(stack,pre,next);
                newHead = newHead == head ? cur : newHead;
            }
            cur = next;
        }
        return newHead;
    }

    //将栈中的元素逆序
    public static Node resign1(Stack<Node> stack, Node left, Node right){
        Node cur = stack.pop();
        if(left != null){
            left.next = cur;
        }
        Node next = null;
        while(!stack.isEmpty()){
            next = stack.pop();
            cur.next = next;
            cur = next;
        }
        cur.next = right;
        return cur;
    }

    public Node reverseKNode2(Node head, int k) {
        if (k <= 1) {
            return head;
        }
        Node cur = head;
        Node start = null;
        Node pre = null;
        Node next = null;
        int count = 1;
        while(cur != null){
            next = cur.next;
            if(count == k){
                start = pre == null ? head : pre.next;
                head = pre == null ? cur : head;
                resign2(pre,start,cur,next);
                pre = start;
                count = 0;
            }
            count++;
            cur = next;
        }
        return head;
    }

    public void resign2(Node left, Node start, Node end, Node right){
        Node cur = start;
        Node next = null;
        Node pre = start.next;
        while(cur != right){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if(left != null){
            left.next = end;
        }
        start.next = right;
    }
}
