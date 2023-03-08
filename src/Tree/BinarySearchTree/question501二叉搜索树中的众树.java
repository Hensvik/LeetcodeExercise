package Tree.BinarySearchTree;

//给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
//如果树中有不止一个众数，可以按 任意顺序 返回。
//假定 BST 满足如下定义：
//
//结点左子树中所含节点的值 小于等于 当前节点的值
//结点右子树中所含节点的值 大于等于 当前节点的值
//左子树和右子树都是二叉搜索树
//
//示例 1：
//
//输入：root = [1,null,2,2]
//输出：[2]
//示例 2：
//
//输入：root = [0]
//输出：[0]
//
//提示：
//
//树中节点的数目在范围 [1, 104] 内
//-105 <= Node.val <= 105
//
//进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）

//使用额外空间的方法是通过遍历，然后用Map进行统计
//不使用额外空间的方法是利用搜索二叉树的特性，中序遍历期间，出现频率最高的数字必定相邻
//需要比较的一般都需要在函数外定义变量pre

import java.util.ArrayList;

public class question501二叉搜索树中的众树 {
    ArrayList<Integer> resList;
    int maxCount;
    int count;
    TreeNode pre;
    public int[] findMode(TreeNode root) {
        resList = new ArrayList<>();
        maxCount = 0;
        count = 0;
        pre = null;
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    public void inOrder(TreeNode node){
        if (node == null) {
            return;
        }
        inOrder(node.left);

        int rootValue = node.val;

        //当之前的node为null或者值不相等，就将count置1，否则++
        if(pre==null || rootValue != pre.val){
            count = 1;
        }else{
            count++;
        }

        //更新结果以及maxCount
        //当统计到比当前最大的数量还要大时
        if(count > maxCount){
            resList.clear();
            //记录下
            resList.add(rootValue);
            maxCount = count;
        }else if(count ==maxCount){
            resList.add(rootValue);
        }
        pre = node;

        inOrder(node.right);
    }

    public static class TreeNode {
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
