package Tree;

//给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
//
//完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~2h个节点。
//
//示例 1：
//
//输入：root = [1,2,3,4,5,6]
//输出：6
//示例 2：
//
//输入：root = []
//输出：0
//示例 3：
//
//输入：root = [1]
//输出：1
//
//提示：
//
//树中节点的数目范围是[0, 5 * 104]
//0 <= Node.val <= 5 * 104
//题目数据保证输入的树是 完全二叉树
//
//
//进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？

import java.util.LinkedList;
import java.util.Queue;

public class question222完全二叉树的节点个数 {
    //递归法
    public static int countNodes2(TreeNode root) {
        if(root == null){
            return 0;
        }
        int count = 1;
        int leftNum = countNodes2(root.left);
        int rightNum = countNodes2(root.right);
        return count+leftNum+rightNum;
    }

    //迭代法
    public static int countNodes1(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int count = 1;
        while(!deque.isEmpty()) {
            int len = deque.size();
            while (len > 0)
            {
                TreeNode node = deque.poll();
                if (node.left != null){
                    count++;
                    deque.offer(node.left);
                }else{
                    return count;
                }
                if (node.right != null){
                    count++;
                    deque.offer(node.right);
                }else{
                    return count;
                }
            }
        }
        return count;
    }

    /**
     * 针对完全二叉树的解法
     * 满二叉树的结点数为：2^depth - 1
     * https://programmercarl.com/0222.%E5%AE%8C%E5%85%A8%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E8%8A%82%E7%82%B9%E4%B8%AA%E6%95%B0.html#%E5%AE%8C%E5%85%A8%E4%BA%8C%E5%8F%89%E6%A0%91
     * 比较难理解
     */
    public int countNodes3(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0, rightDepth = 0; // 这里初始为0是有目的的，为了下面求指数方便
        while (left != null) {  // 求左子树深度
            left = left.left;
            leftDepth++;
        }
        while (right != null) { // 求右子树深度
            right = right.right;
            rightDepth++;
        }
        if (leftDepth == rightDepth) {
            return (2 << leftDepth) - 1; // 注意(2<<1) 相当于2^2，所以leftDepth初始为0
        }
        return countNodes3(root.left) + countNodes3(root.right) + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
