package Tree;

//给定一个 N 叉树，找到其最大深度。
//
//最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
//
//N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
//
//示例 1：
//
//输入：root = [1,null,3,2,4,null,5,6]
//输出：3
//示例 2：
//
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
//输出：5
//
//提示：
//
//树的深度不会超过1000 。
//树的节点数目位于 [0,104] 之间。

import java.util.*;

public class question559n叉树的最大深度 {
    /*递归法，后序遍历求root节点的高度*/
    public int maxDepth1(Node root) {
        if (root == null) return 0;

        int depth = 0;
        if (root.children != null){
            for (Node child : root.children){
                depth = Math.max(depth, maxDepth1(child));
            }
        }
        return depth + 1; //中节点
    }

    /**
     * 迭代法，使用层序遍历
     */
    public int maxDepth2(Node root) {
        if (root == null)   return 0;
        int depth = 0;
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty())
        {
            depth ++;
            int len = que.size();
            while (len > 0)
            {
                Node node = que.poll();
                for (int i = 0; i < node.children.size(); i++)
                    if (node.children.get(i) != null)
                        que.offer(node.children.get(i));
                len--;
            }
        }
        return depth;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        System.out.println(deque.pop());

        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
    }
}
