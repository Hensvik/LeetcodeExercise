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





        for (int i = 1; i < to; i++) {
            cur = cur.next;
        }



    }
}
