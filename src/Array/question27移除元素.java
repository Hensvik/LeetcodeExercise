package Array;

//给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
//
//不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
//
//元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
//
//说明:
//
//为什么返回数值是整数，但输出的答案是数组呢?
//
//请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
//
//你可以想象内部操作如下:
//
//// nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
//int len = removeElement(nums, val);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
//for (int i = 0; i < len; i++) {
//  print(nums[i]);
//}
//
//
//示例 1：
//
//输入：nums = [3,2,2,3], val = 3
//输出：2, nums = [2,2]
//解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
//示例 2：
//
//输入：nums = [0,1,2,2,3,0,4,2], val = 2
//输出：5, nums = [0,1,4,0,3]
//解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。

//
//提示：
//
//0 <= nums.length <= 100
//0 <= nums[i] <= 50
//0 <= val <= 100
//

//思路：首先能想到的应该是快慢指针，慢指针从左出发找目标数，找到目标数后快指针从慢指针位置出发找非目标数，然后交换，直到快指针到达右侧
public class question27移除元素 {

    //移动次数较多，但相对顺序没有改变
    //双指针同一方向
    public static int removeElement1(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            //如果快指针不碰到目标值，则继续走，碰到了，则将慢指针赋值
            if(val != nums[fast]){
                nums[slow++] = nums[fast];
            }
        }

        for(int num: nums) {
            System.out.println(num+" ");
        }

        return slow;
    }

    //移动次数最少，但相对位置改变
    //采用分别向左移动和向右移动的双指针
    public static int removeElement2(int[] nums, int val) {
        int L = 0;
        int R = nums.length-1;
        //左指针和右指针未碰撞
        while(L<=R){
            //左指针找val
            while(nums[L]!=val){
                L++;
            }

            //右指针找非L
            while(nums[R]!=val){
                R--;
            }

            //交换值
            /*int temp = nums[L];
            nums[L++] = nums[R];
            nums[R--] = temp;*/

            //由于题目要求只需要保证删减后位数正确
            nums[L++] = nums[R--];
        }
        return L;
    }

    public static void main(String[] args) {
        int []nums = {2};
        int val = 3;
        System.out.println(removeElement1(nums,val));
    }
}
