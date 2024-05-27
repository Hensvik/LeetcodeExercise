package LinkList;

//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
//示例 1：
//
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
//示例 2：
//
//输入：head = [1,2]
//输出：[2,1]
//示例 3：
//
//输入：head = []
//输出：[]
//
//提示：
//
//链表中节点的数目范围是 [0, 5000]
//-5000 <= Node.val <= 5000
//

public class question206反转链表 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val) {
            this.val=val;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode cur = null;
        ListNode pre = null;
        while(head!=null){
            //保存下一个节点
            pre = head.next;
            //让头节点指向null或上一个节点
            head.next = cur;
            //让cur为当前头节点
            cur = head;
            //让下一个节点即pre指向当前头节点，
            head = pre;
            //进入下一个循环前，cur为前一个节点，head=pre
        }
        //注意这里是返回cur而非pre
        return cur;
    }

    public static ListNode reverseList2(ListNode head) {
        ListNode cur = null;
        ListNode pre = null;
        while(head!=null){
            pre = head.next;
            head.next = cur;
            cur = head;
            head = pre;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        reverseList(node1);
        System.out.println(node5);
    }
}
