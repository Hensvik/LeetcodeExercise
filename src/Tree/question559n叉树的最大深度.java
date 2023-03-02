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

import java.util.List;

public class question559n叉树的最大深度 {
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        int depth = 1;
        return depthProcess1(root,depth);
    }

    public int depthProcess1(Node root,int depth){
        if(root.children==null){
            return depth;
        }

        for (Node node:root.children) {
            depth = Math.max(depth,depthProcess1(node,depth+1));
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
    };
}
