package LinkList;

//设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val和next。val是当前节点的值，next是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性prev以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
//
//在链表类中实现这些功能：
//
//get(index)：获取链表中第index个节点的值。如果索引无效，则返回-1。
//addAtHead(val)：在链表的第一个元素之前添加一个值为val的节点。插入后，新节点将成为链表的第一个节点。
//addAtTail(val)：将值为val 的节点追加到链表的最后一个元素。
//addAtIndex(index,val)：在链表中的第index个节点之前添加值为val 的节点。如果index等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
//deleteAtIndex(index)：如果索引index 有效，则删除链表中的第index 个节点。
//
//示例：
//
//MyLinkedList linkedList = new MyLinkedList();
//linkedList.addAtHead(1);
//linkedList.addAtTail(3);
//linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//linkedList.get(1);            //返回2
//linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//linkedList.get(1);            //返回3
//
//
//提示：
//
//0 <= index, val <= 1000
//请不要使用内置的 LinkedList 库。
//get,addAtHead,addAtTail,addAtIndex和deleteAtIndex的操作次数不超过2000。
//

public class question707设计链表 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val) {
            this.val=val;
        }
    }

    public static class MyLinkedList {
        private int size;
        private ListNode head;

        public MyLinkedList() {
            size = 0;
            head = new ListNode();
        }

        public int get(int index) {
            if (index < 0 || index >size) {
                return -1;
            }
            int i = 0;
            ListNode cur = head;
            while (index != i) {
                if (cur == null) {
                    return -1;
                }
                cur = cur.next;
                i++;
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            ListNode node = new ListNode();
            node.val = val;
            node.next = head;
        }

        public void addAtTail(int val) {
            ListNode node = new ListNode();
            node.val = val;
            node.next = head;
            if(head == null){
                head = node;
            }
            ListNode cur = head;
            while(cur.next!=null){
                cur = cur.next;
            }
            cur.next = node;
        }

        public void addAtIndex(int index, int val) {
            if(index<0 || index>size){
                return;
            }
            ListNode node = new ListNode();
            node.val = val;
            node.next = head;
            int i = 0;
            ListNode cur = head;
            while (i != index - 1) {
                if (cur != null) {
                    node.next = cur.next.next;
                    cur.next = node;
                } else {
                    return;
                }
                i++;
            }
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            size--;
            if (index == 0) {
                head = head.next;
                return;
            }
            ListNode pred = head;
            for (int i = 0; i < index ; i++) {
                pred = pred.next;
            }
            pred.next = pred.next.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3
        linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.get(1);            //返回3
    }
}
