package Tree.BinarySearchTree;

//给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
//
//高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
//
//示例 1：
//
//输入：nums = [-10,-3,0,5,9]
//输出：[0,-3,9,-10,null,5]
//解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
//
//示例 2：
//
//输入：nums = [1,3]
//输出：[3,1]
//解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
//
//
//提示：
//
//1 <= nums.length <= 104
//-104 <= nums[i] <= 104
//nums 按 严格递增 顺序排列

import java.util.LinkedList;
import java.util.Queue;

public class question108将有序数组转换为二叉搜索树 {
    public static TreeNode sortedArrayToBST1(int[] nums) {
        return construct(nums,0,nums.length-1);
    }

    //代码随想录 递归
    public static TreeNode construct(int[] nums,int left,int right){
        if(left>right){
            return null;
        }
        //注意，+号的优先级要大于>>，所以必须在(right-left)>>1上外加多一层括号
        int mid = left+((right-left)>>1);
        TreeNode root = new TreeNode(nums[mid]);

        root.left = construct(nums,left,mid-1);
        root.right = construct(nums,mid+1,right);
        return root;
    }

    //代码随想录 迭代
    public static TreeNode sortedArrayToBST2(int[] nums) {
        if(nums.length==0){
            return null;
        }

        TreeNode root = new TreeNode(-1);
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> leftQueue = new LinkedList<>();
        Queue<Integer> rightQueue = new LinkedList<>();

        //根节点入队列
        nodeQueue.offer(root);
        //0为左区间下标初始位置
        leftQueue.offer(0);
        //nums.size()-1为右区间下标初始位置
        rightQueue.offer(nums.length-1);

        while(!nodeQueue.isEmpty()){
            TreeNode currNode = nodeQueue.poll();
            int left = leftQueue.poll();
            int right = rightQueue.poll();
            int mid = left + ((right-left)>>1);

            //将mid对应的元素给中间节点
            currNode.val = nums[mid];

            //处理左区间
            //如果左节点和mid重合，就不处理了
            if(left <= mid-1){
                currNode.left = new TreeNode(-1);
                nodeQueue.offer(currNode.left);
                leftQueue.offer(left);
                rightQueue.offer(mid-1);
            }

            //处理右区间
            if (right >= mid + 1) {
                currNode.right = new TreeNode(-1);
                nodeQueue.offer(currNode.right);
                leftQueue.offer(mid + 1);
                rightQueue.offer(right);
            }
        }
        return root;
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

    public static void main(String[] args) {
        int []nums = {-10,-3,0,5,9};
    }
}
