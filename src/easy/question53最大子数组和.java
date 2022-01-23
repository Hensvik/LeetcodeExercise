package easy;

public class question53最大子数组和 {
    public static int maxSubArray(int[] nums) {
        int maxSum=nums[0];   //之前最大值的和
        for(int i=0;i<nums.length;i++){
            if(maxSum>0){
                maxSum+=nums[i];
                nums[i]=maxSum;
            }else{
                maxSum=nums[i];
            }
        }
        for(int i:nums){
            System.out.println(i);
            maxSum=Math.max(i,maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);
    }
}
