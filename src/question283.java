//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
//示例:
//
//输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//说明:
//
//必须在原数组上操作，不能拷贝额外的数组。
//尽量减少操作次数。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/move-zeroes
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class question283 {
    /*public static void moveZeroes(int[] nums) {
        int i=0;
        int j=0;   //记录0的位置
        while(i<nums.length){
            if(nums[i]!=0 && nums[j]==0 && nums[i]!=nums[j]){
                nums[i] = nums[i] ^ nums[j];
                nums[j] = nums[i] ^ nums[j];
                nums[i] = nums[i] ^ nums[j];
                j++;
            }
            if(nums[j]!=0){
                j++;
            }
            i++;
        }
        for (int k:nums) {
            System.out.println(k);
        }
    }*/

    //移位问题可以考虑覆写，如果覆写的值一定的话
    public static void moveZeroes(int[] nums) {
        int left=0;
        int right=0;
        //遍历只要不是0就从左往右覆盖
        while(right<nums.length){
            if(nums[right]!=0){
                nums[left++]=nums[right];
            }
            right++;
        }
        //最后再往最后补0
        while(left<nums.length){
            nums[left++] = 0;
        }
        for (int i:nums) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int []nums = {1,0,2,6,0,7};
        moveZeroes(nums);
    }
}
