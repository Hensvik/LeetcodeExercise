package Array.Binary;

//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
//你可以假设数组中无重复元素。
//
//示例 1:
//
//输入: [1,3,5,6], 5
//输出: 2
//示例 2:
//
//输入: [1,3,5,6], 2
//输出: 1
//示例 3:
//
//输入: [1,3,5,6], 7
//输出: 4
//示例 4:
//
//输入: [1,3,5,6], 0
//输出: 0

//常规遍历方法，其实效率就已经很高了
public class question35搜索插入位置 {
    //常规遍历方法，其实效率就已经很高了
    public static int searchInsert1(int[] nums, int target) {
        if(nums.length==0){
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==target || nums[i]>target){
                return i;
            }else if(i+1==nums.length){
                return i+1;
            }
        }
        return -1;
    }

    //二分法解法，使用二分法需要时刻注意范围，左闭右闭写法
    public static int searchInsert2(int[] nums, int target) {
        int L = 0;
        int R = nums.length-1;
        //这种写法可以保证int不越界
        while(L<R){
            int M = L+((R-L)>>1);
            if(nums[M]>target){
                R=M-1;
            }else if(nums[M]<target){
                L=M+1;
            }else{
                return M;
            }
        }
        return L;
    }

    //二分法解法，使用二分法需要时刻注意范围，左闭右开写法
    public static int searchInsert3(int[] nums, int target) {
        int L = 0;
        int R = nums.length;
        //这种写法可以保证int不越界
        while(L<R){
            int M = L+((R-L)>>1);
            if(nums[M]>target){
                R=M;
            }else if(nums[M]<target){
                L=M+1;
            }else{
                return M;
            }
        }
        return R;
    }

    public static void main(String[] args) {
        int []nums = {1,3,5,6};
        System.out.println(searchInsert3(nums,2));
    }
}
