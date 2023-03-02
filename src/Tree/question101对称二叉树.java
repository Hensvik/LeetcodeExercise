package Tree;

//给你一个二叉树的根节点 root ， 检查它是否轴对称。
//
//示例 1：
//
//输入：root = [1,2,2,3,4,4,3]
//输出：true
//示例 2：
//
//输入：root = [1,2,2,null,3,null,3]
//输出：false
//
//提示：
//
//树中节点数目在范围 [1, 1000] 内
//-100 <= Node.val <= 100
//
//进阶：你可以运用递归和迭代两种方法解决这个问题吗？

import java.util.LinkedList;
import java.util.Queue;

public class question101对称二叉树 {
    //自己的递归解法
    public boolean isSymmetric1(TreeNode root) {
        return compare(root.left,root.right);
    }

    public boolean compare(TreeNode left,TreeNode right){
        //注意此处比较的顺序，如果不优先比较空指针的话可能会报空指针异常
        if((left == null && right !=null) || (left != null && right ==null)){
            return false;
        }else if(left == null && right ==null){
            return true;
        }else if(left.val!=right.val){
            return false;
        }

        boolean outside = compare(left.left,right.right);
        boolean inside = compare(left.right,right.left);
        return outside && inside;                    // 左子树：中、 右子树：中 （逻辑处理）
    }

    //官方的迭代解法
    public boolean isSymmetric2(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode u, TreeNode v) {
        //新建的队列
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
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
