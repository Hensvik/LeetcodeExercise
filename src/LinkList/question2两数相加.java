package LinkList;

//给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
//请你将两个数相加，并以相同形式返回一个表示和的链表。
//你可以假设除了数字 0 之外，这两个数都不会以 0开头。
//
//示例 1：
//
//
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
//示例 2：
//
//输入：l1 = [0], l2 = [0]
//输出：[0]
//示例 3：
//
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
//
//提示：
//
//每个链表中的节点数在范围 [1, 100] 内
//0 <= Node.val <= 9
//题目数据保证列表表示的数字不含前导零

import easy.question876链表的中间结点;

public class question2两数相加 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int count = 0;//保存进价位

        while(l1!=null || l2!=null || count !=0){
            if(l1!=null){
                count += l1.val;
            }
            if (l2 != null) {
                count += l2.val;
            }
            cur.next =  new ListNode(count>=10?count-10:count);
            cur = cur.next;
            count = count>=10?1:0;

            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null) {
                l2 = l2.next;
            }
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode i = new ListNode(7);
        ListNode h = new ListNode(5,i);
        ListNode g = new ListNode(3,h);
        ListNode f = new ListNode(8,g);
        ListNode e = new ListNode(6,f);
        ListNode d = new ListNode(5,e);
        ListNode c = new ListNode(6,d);
        ListNode b = new ListNode(6,c);
        ListNode a = new ListNode(0,b);

        ListNode s = new ListNode(7);
        ListNode r = new ListNode(9,s);
        ListNode q = new ListNode(8,r);
        ListNode p = new ListNode(5,q);
        ListNode o = new ListNode(8,p);
        ListNode n = new ListNode(0,o);
        ListNode m = new ListNode(8,n);
        ListNode l = new ListNode(7,m);
        ListNode k = new ListNode(6,l);

        addTwoNumbers(a,k);
    }


    public static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
