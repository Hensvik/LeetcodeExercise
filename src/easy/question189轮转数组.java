package easy;//给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
//
// 
//
//示例 1:
//
//输入: nums = [1,2,3,4,5,6,7], k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右轮转 1 步: [7,1,2,3,4,5,6]
//向右轮转 2 步: [6,7,1,2,3,4,5]
//向右轮转 3 步: [5,6,7,1,2,3,4]
//示例 2:
//
//输入：nums = [-1,-100,3,99], k = 2
//输出：[3,99,-1,-100]
//解释:
//向右轮转 1 步: [99,-1,-100,3]
//向右轮转 2 步: [3,99,-1,-100]
// 
//
//提示：
//
//1 <= nums.length <= 105
//-231 <= nums[i] <= 231 - 1
//0 <= k <= 105
// 
//
//进阶：
//
//尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
//你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/rotate-array
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class question189轮转数组 {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        int []numsex = new int[2*nums.length-1];
        for(int i=0;i<2*nums.length-1;i++){
            numsex[i]=nums[i%nums.length];
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=numsex[numsex.length-i];
        }
    }
}
