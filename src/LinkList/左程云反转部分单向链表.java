package LinkList;

public class 左程云反转部分单向链表 {

    public static class Node {
        public int value;
        public Node next;
        public Node(int data) {
            this.value = data;
        }
    }

    public static Node reversePart(Node head, int from, int to) {
        int len = 0;
        Node before = null;
        Node after = null;

        Node node = head;
        while(node!=null) {
            len++;
            //将pre置为from前一个节点
            before = from-1 == len ? node : before;
            //将cur置为to后一个节点
            after = to+1 == len ? node : after;

            node = node.next;
        }
        if(from>to || from<1 || to>len){
            return head;
        }

        //pre记录from对应节点
        Node pre = null;
        //cur记录to对应节点
        Node cur = null;

        pre = before == null ? head : before.next;
        cur = pre.next;
        pre.next = after;
        //新建临时变量
        Node next = null;
        //将中间部分反转
        while(cur!=after) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //此时需要将最开始的before节点指向反转部分的头节点
        if(before!=null) {
            before.next = pre;
            return head;
        }
        return pre;

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head = reversePart(head, 2, 5);
        while(head!=null) {
            System.out.println(head.value);
            head = head.next;
        }
    }
}
