package LinkList;

//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
//
//
//示例 1：
//
//
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
//示例 2：
//
//输入：head = []
//输出：[]
//示例 3：
//
//输入：head = [1]
//输出：[1]
//
//提示：
//
//链表中节点的数目在范围 [0, 100] 内
//0 <= Node.val <= 100
//

public class question24两两交换链表中的节点 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val) {
            this.val=val;
        }
    }

    //反例：没有注意中间节点的变动
    /*public static ListNode swapPairs(ListNode head) {
        ListNode cur = new ListNode();
        ListNode pre = new ListNode();
        cur = head;
        while(cur!=null && cur.next!=null){
            pre = cur.next;
            ListNode temp = pre.next;
            pre.next = cur;
            if(temp==null){
                cur=null;
            }else{
                cur.next = temp;
                cur=cur.next;
            }
        }
        if(cur==null){
            return pre;
        }else{
            cur.next = pre;
            return cur;
        }
    }*/

    //递归解法
    //递归的终止条件是链表中没有节点，或者链表中只有一个节点，此时无法进行交换。
    public static ListNode swapPairs1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //新头节点为头节点的下一个节点
        ListNode newHead = head.next;

        head.next = swapPairs1(newHead.next);
        newHead.next = head;
        return newHead;
    }

    //同递归法，写法比较好理解
    public static ListNode swapPairs2(ListNode head) {
        if(head != null || head.next != null){
            return head;
        }
        ListNode nodeOne = head;
        ListNode nodeTwo = nodeOne.next;
        ListNode nodeThree = nodeTwo.next;

        nodeTwo.next = nodeOne;
        nodeOne.next = swapPairs2(nodeThree);

        return nodeTwo;
    }

    //代码随想录
    public ListNode swapPairs3(ListNode head) {
        ListNode dumyhead = new ListNode(-1); // 设置一个虚拟头结点
        dumyhead.next = head; // 将虚拟头结点指向head，这样方面后面做删除操作
        ListNode cur = dumyhead;    //将当前节点赋值为虚拟头结点
        ListNode temp; // 临时节点，保存两个节点后面的节点
        ListNode firstnode; // 临时节点，保存两个节点之中的第一个节点
        ListNode secondnode; // 临时节点，保存两个节点之中的第二个节点
        //当当前节点的下两个节点均不为空
        while (cur.next != null && cur.next.next != null) {
            //保存下一个循环的开始节点到temp
            temp = cur.next.next.next;
            //赋值cur的下面两个节点
            firstnode = cur.next;
            secondnode = cur.next.next;

            //将当前的下一个节点赋值为节点二
            cur.next = secondnode;       // 步骤一
            //节点二指向节点一
            secondnode.next = firstnode; // 步骤二
            //节点一指向temp（下一个循环）
            firstnode.next = temp;      // 步骤三
            //同时将cur赋值节点一，相当于第一个循环中的虚拟头节点
            cur = firstnode; // cur移动，准备下一轮交换
        }
        return dumyhead.next;
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

        swapPairs2(node1);
        System.out.println("node1:"+node1.val+" "+"next:"+node1.next.val);
        System.out.println("node2:"+node2.val+" "+"next:"+node2.next.val);
        System.out.println("node3:"+node3.val+" "+"next:"+node3.next.val);
        System.out.println("node4:"+node4.val+" "+"next:"+node4.next.val);
    }
}
