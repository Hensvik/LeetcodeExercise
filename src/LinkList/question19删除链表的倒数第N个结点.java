package LinkList;

//给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
//
//示例 1：
//
//
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
//示例 2：
//
//输入：head = [1], n = 1
//输出：[]
//示例 3：
//
//输入：head = [1,2], n = 1
//输出：[1]
//
//提示：
//
//链表中结点的数目为 sz
//1 <= sz <= 30
//0 <= Node.val <= 100
//1 <= n <= sz
//
//进阶：你能尝试使用一趟扫描实现吗？
//

import java.util.Deque;
import java.util.LinkedList;

public class question19删除链表的倒数第N个结点 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

    //第一张遍历一遍获得长度，然后第二遍达成目标
    //复杂度分析
    //
    //时间复杂度：O(L)，其中 L 是链表的长度。
    //
    //空间复杂度：O(1)。
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    //方法二：栈方法
    //复杂度分析
    //
    //时间复杂度：O(L)，其中 L 是链表的长度。
    //
    //空间复杂度：O(L)，其中 L 是链表的长度。主要为栈的开销。
    /*public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }*/

    //方法三：双指针方法
    /*public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }*/

    //方法四：递归写法
    /*public static ListNode removeNthFromEnd(ListNode head, int n) {
        return removeNode(head,n)==n?head.next:head;
    }
    public static int removeNode(ListNode node,int n) {
        if(node.next == null)  return 1;
        int m = removeNode(node.next, n);
        if(m == n)
            if(m == 1) node.next = null;
            else node.next = node.next.next;
        return m+1;
    }*/

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        int t = 0;
        ListNode temp = head;
        while(temp.next != null){
            t++;
            temp = temp.next;
        }

        ListNode cur = new ListNode(-1,head);
        for (int i = 0; i < t; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;

        return head;
    }

    //代码随想录
    public static ListNode removeNthFromEnd4(ListNode head, int n){
        //虚拟节点，指向头节点
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode fastIndex = dummyNode;
        ListNode slowIndex = dummyNode;

        //让快指针先跑n个节点
        for(int i = 0;i<n;i++){
            fastIndex = fastIndex.next;
        }

        while (fastIndex.next != null){
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }

        slowIndex.next = slowIndex.next.next;
        return dummyNode.next;
    }

    public static void main(String[] args) {
        /*ListNode e = new ListNode(5);
        ListNode d = new ListNode(4, e);
        ListNode c = new ListNode(3, d);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(1, b);
        removeNthFromEnd2(a,2);*/

        ListNode e = new ListNode(1);
        removeNthFromEnd(e,2);
    }
}
