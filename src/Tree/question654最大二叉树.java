package Tree;

//给定一个不重复的整数数组nums 。最大二叉树可以用下面的算法从nums 递归地构建:
//
//创建一个根节点，其值为nums 中的最大值。
//递归地在最大值左边的子数组前缀上构建左子树。
//递归地在最大值 右边 的子数组后缀上构建右子树。
//返回nums 构建的 最大二叉树 。
//
//示例 1：
//
//输入：nums = [3,2,1,6,0,5]
//输出：[6,3,5,null,2,0,null,null,1]
//解释：递归调用如下所示：
//- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
//    - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
//        - 空数组，无子节点。
//        - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
//            - 空数组，无子节点。
//            - 只有一个元素，所以子节点是一个值为 1 的节点。
//    - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
//        - 只有一个元素，所以子节点是一个值为 0 的节点。
//        - 空数组，无子节点。
//示例 2：
//
//输入：nums = [3,2,1]
//输出：[3,null,2,null,1]
//
//提示：
//
//1 <= nums.length <= 1000
//0 <= nums[i] <= 1000
//nums 中的所有整数 互不相同

public class question654最大二叉树 {
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        int maxValueIndex = -1;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(maxValue<nums[i]){
                maxValue = Math.max(maxValue,nums[i]);
                maxValueIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxValue);

        process(nums,root,maxValueIndex-1,maxValueIndex+1);
        return root;
    }

    public static void process(int[] nums,TreeNode node,Integer leftEnd,Integer rightStart){
        /*if(leftEnd<0 || rightStart>nums.length){
            return ;
        }*/

        if(leftEnd==0){
            node.left=new TreeNode(nums[0]);
        }
        if(rightStart.equals(nums.length)){
            node.right=new TreeNode(nums[rightStart]);
        }
        int maxValueLeftIndex = -1;
        int maxValueLeft=Integer.MIN_VALUE;
        for (int i = 0; i <= leftEnd; i++) {
            if(maxValueLeft<nums[i]){
                maxValueLeft = Math.max(maxValueLeft,nums[i]);
                maxValueLeftIndex = i;
            }
        }

        int maxValueRightIndex = -1;
        int maxValueRight=Integer.MIN_VALUE;
        for (int i = rightStart; i <= nums.length-1; i++) {
            if(maxValueRight<nums[i]){
                maxValueRight = Math.max(maxValueRight,nums[i]);
                maxValueRightIndex = i;
            }
        }
        if(maxValueLeftIndex!=-1){
            TreeNode leftPoint = new TreeNode(nums[maxValueLeftIndex]);
            process(nums, leftPoint,maxValueLeftIndex-1,maxValueLeftIndex+1);
        }

        if(maxValueRightIndex!= nums.length){
            TreeNode rightPoint = new TreeNode(nums[maxValueRightIndex]);
            process(nums, rightPoint,maxValueRightIndex-1,maxValueRightIndex+1);
        }

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
        int []nums = {3,2,1,6,0,5};
        constructMaximumBinaryTree(nums);
    }
}
