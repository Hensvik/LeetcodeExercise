package LinkList;

public class 左程云在单链表和双链表中删除第K个节点 {
    public static class Node {
        public int value;
        public Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    //单链表
    //从头开始遍历，到最后一个节点时，如果lastKth >= 0，则返回头节点就可以了
    //如果K<0，则从头开始遍历，每次下一个节点给K+1，如果遍历到K=0的位置，那么下一个节点就是要删除的节点
    //原因：假设N为链表长度，要删除第K个节点，我们实际上只需要找到K的前一个节点，那么K第一次遍历到最后时，lastKth = K-N+1，那么lastKth的前一个节点为K-N

    public static Node removeKthNode(Node head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            lastKth --;
            cur = cur.next;
        }
        if (lastKth == 0) {
            head = head.next;
        } else if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    //双链表
    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;
        public DoubleNode(int value) {
            this.value = value;
        }
    }

    public static DoubleNode removeKthNode(DoubleNode head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        DoubleNode cur = head;
        while (cur != null) {
            lastKth --;
            cur = cur.next;
        }
        if (lastKth == 0) {
            head = head.next;
            head.last = null;
        } else if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            DoubleNode newNext = cur.next.next;
            if (newNext != null) {
                newNext.last = cur;
            }
            cur.next = newNext;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head = removeKthNode(head, 2);
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }
}
