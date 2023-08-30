package Array.DoublePointer;

//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
//
//示例 1：
//
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100]
//示例 2：
//
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
//
//提示：
//
//1 <= nums.length <= 104
//-104 <= nums[i] <= 104
//nums 已按 非递减顺序 排序
//
//
//进阶：
//
//请你设计时间复杂度为 O(n) 的算法解决本问题

public class question977有序数组的平方 {
    /*public int[] sortedSquares(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i]=(int)Math.pow(Math.abs(nums[i]),2);
        }
        Arrays.sort(nums);
        return nums;
    }*/

    //时间复杂度O(nlogn) 空间复杂度O(logn)

    public int[] sortedSquares1(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int[] res = new int[nums.length];
        int count = nums.length;
        while(left!=right){
            if(nums[left]>nums[right]){
                res[count]=(int)Math.pow(nums[left],2);
                count--;
                left++;
            }else{
                res[count]=(int)Math.pow(nums[right],2);
                count--;
                right--;
            }
        }
        return res;
    }

    //双指针，分别从左右往中间遍历
    public static int[] sortedSquares2(int[] nums) {
        int L=0;
        int R=nums.length-1;
        //结果集
        int[] res = new int[nums.length];
        //结果集序号
        int count = nums.length-1;
        while(L<R){
            if(Math.abs(nums[L])>Math.abs(nums[R])){
                res[count]=(int)Math.pow(nums[L++],2);
            }else{
                res[count]=(int)Math.pow(nums[R--],2);
            }
            count--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        int[] res = sortedSquares2(nums);
        for (int item : res) {
            System.out.println(item + " ");
        }
    }
}
