package LinkList;

//给你两个单链表的头节点headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
//图示两个链表在节点 c1 开始相交：
//题目数据 保证 整个链式结构中不存在环。
//
//注意，函数返回结果后，链表必须 保持其原始结构 。
//
//示例 1：
//
//输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
//输出：Intersected at '8'
//解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
//在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
//示例2：
//
//输入：intersectVal= 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
//输出：Intersected at '2'
//解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
//在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
//示例3：
//
//输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
//由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
//这两个链表不相交，因此返回 null 。
//
//提示：
//
//listA 中节点数目为 m
//listB 中节点数目为 n
//0 <= m, n <= 3 * 104
//1 <= Node.val <= 105
//0 <= skipA <= m
//0 <= skipB <= n
//如果 listA 和 listB 没有交点，intersectVal 为 0
//如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1]
//
//进阶：你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？
//

public class question160链表相交 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //自己写的
    //注意点1:这是比较是否是同一个节点，而不是比较二者的值是否相等
    //注意点2:相交的两个链表的结尾一定是相等的
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int sizeA = 0;
        int sizeB = 0;

        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA!=null && tempA.next!=null){
            sizeA ++;
            tempA = tempA.next;
        }

        while(tempB!=null && tempB.next!=null){
            sizeB ++;
            tempB = tempB.next;
        }

        if(sizeA<=sizeB){
            ListNode tempLN = new ListNode(0);
            tempLN = headA;
            headA = headB;
            headB = tempLN;

            int tempSize = sizeA;
            sizeA = sizeB;
            sizeB = tempSize;
        }

        int sizeGap = sizeA - sizeB;

        tempA = headA;
        tempB = headB;
        for (int i = 0; i < sizeGap; i++) {
            tempA = tempA.next;
        }

        while (tempA != null) {
            if (tempA == tempB) {
                return tempA;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return null;
    }

    //代码随想录
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;
        while (curA != null) { // 求链表A的长度
            lenA++;
            curA = curA.next;
        }
        while (curB != null) { // 求链表B的长度
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        // 让curA为最长链表的头，lenA为其长度
        if (lenB > lenA) {
            //1. swap (lenA, lenB);
            int tmpLen = lenA;
            lenA = lenB;
            lenB = tmpLen;
            //2. swap (curA, curB);
            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }
        // 求长度差
        int gap = lenA - lenB;
        // 让curA和curB在同一起点上（末尾位置对齐）
        while (gap-- > 0) {
            curA = curA.next;
        }
        // 遍历curA 和 curB，遇到相同则直接返回
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
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

        ListNode node6 = new ListNode(8);

        node6.next = node3;

        getIntersectionNode1(node1,node6);
    }
}
