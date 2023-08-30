package Array.Binary;

//给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
//
//示例 1:
//
//输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
//示例2:
//
//输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
//
//
//提示：
//
//你可以假设 nums中的所有元素是不重复的。
//n将在[1, 10000]之间。
//nums的每个元素都将在[-9999, 9999]之间。

public class question704二分查找 {

    //递归写法
    public static int search1(int[] nums, int target) {
        return process1(nums,0,nums.length-1,target);
    }

    public static int process1(int[] arr, int L,int R,int target){
        //循环跳出条件
        if(L > R){
            return -1;
        }else if(L == R && target != arr[L]){
            return -1;
        }
        int mid = L + ((R-L) >> 1);

        if(target == arr[mid]){
            return mid;
        }else if(target > arr[mid]){
            return process1(arr,mid+1,R,target);
        }else{
            return process1(arr,L,mid,target);
        }
    }

    //代码随想录-左闭右闭写法
    public static int search2(int[] nums, int target) {
        //越界条件判断
        if(target<nums[0] || target>nums[nums.length-1]){
            return -1;
        }
        int L = 0;
        int R = nums.length-1;
        //假设给与数组长度仅为1，所以可能会出现L和R为同一位置的情况
        while(L <= R){
            //>>的写法比/2的写法效率更高一些
            //int cur = L+((R-L)>>1);
            int cur = (L+R)>>1;
            if(nums[cur] < target){
                L = cur+1;
            }else if(nums[cur] > target){
                R = cur-1;
            }else{
                return cur;
            }
        }
        return -1;
    }

    //代码随想录-左闭右开写法
    public static int search3(int[] nums, int target) {
        //越界条件判断
        if(target<nums[0] || target>nums[nums.length-1]){
            return -1;
        }
        int L = 0;
        int R = nums.length;
        //注意左闭右开的情况是不会出现L==R的，因为R永远比cur的位置+1，L和R永远不重合
        while(L < R){
            //>>的写法比/2的写法效率更高一些
            int cur = (L+R)>>1;
            if(nums[cur] < target){
                L = cur+1;
            }else if(nums[cur] > target){
                //因为R需要保持为总比原区域大1，所以cur不需要-1了
                R = cur;
            }else{
                return cur;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int []nums= {-1,0,3,5,9,12};
        int result = search3(nums,9);
        System.out.println(result);
    }
}
