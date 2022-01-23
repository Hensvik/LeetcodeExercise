package easy;//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
//
// 
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
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class question977有序数组的平方 {
    /*public int[] sortedSquares(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i]=(int)Math.pow(Math.abs(nums[i]),2);
        }
        Arrays.sort(nums);
        return nums;
    }*/

    //时间复杂度O(nlogn) 空间复杂度O(logn)

    public int[] sortedSquares(int[] nums) {
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
}
