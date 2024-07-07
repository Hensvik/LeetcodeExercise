package LinkList;

import java.util.Stack;

public class 左程云判断一个链表是否为回文结构 {
    
    public static class Node {
        public int value;
        public Node next;
        public Node(int data) {
            this.value = data;
        }
    }
    
    //方法1：将链表压入栈中，然后依次弹出，判断是否相等
    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //利用快慢指针定位中节点和尾节点后，从中节点至尾节点推入数据，然后和头节点的数据进行比较
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node fast = head.next;
        Node slow = head;
        //利用快慢指针定位尾节点和中节点
        while (slow.next != null && slow.next.next != null) {
            fast = fast.next;
            slow = slow.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while (fast != null) {
            stack.push(fast);
            fast = fast.next;
        }
        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        //利用快慢指针定位尾节点和中节点
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;   // n1 -> 中部
            n2 = n2.next.next;  // n2 -> 结尾
        }
        n2 = n1.next;   //n2 -> 右部分第一个节点
        n1.next = null; //mid.next -> null
        Node n3 = null;
        //右半区反转
        while (n2 != null) {
            n3 = n2.next;   // n3 -> 保存下一个节点
            n2.next = n1;   // 下一个反转节点
            n1 = n2;    // n1 移动
            n2 = n3;    // n2 移动
        }
        n3 = n1;    // n3 -> 保存最后一个节点
        n2 = head;  // n2 -> 左部分第一个节点
        boolean res = true;
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        //恢复列表
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }
}
