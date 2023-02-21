package LinkList;

//给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回null。
//
//如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
//
//不允许修改 链表。
//
//示例 1：
//
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
//示例2：
//
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
//示例 3：
//
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
//
//提示：
//
//链表中节点的数目范围在范围 [0, 104] 内
//-105 <= Node.val <= 105
//pos 的值为 -1 或者链表中的一个有效索引
//
//进阶：你是否可以使用 O(1) 空间解决此题？
//

public class question142环形链表2 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //这个只能查出是否有交集，不能查询出交点
    public static ListNode detectCycle(ListNode head) {
        if(head==null || head.next == null){
            return null;
        }

        ListNode quick = head.next;
        ListNode slow = head;

        while(quick.next!=null && quick.next.next!=null){
            while(quick==slow){
                return slow;
            }
            quick = quick.next.next;
            slow = slow.next;
        }
        return null;
    }

    //代码随想录
    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {// 有环
                //此时相遇时，置两个指针分别从相遇点和头节点开始走，再次相遇时即为环入口
                ListNode index1 = fast;
                ListNode index2 = head;
                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        detectCycle(node1);
    }
}
