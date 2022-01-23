package easy;

public class question704二分查找 {
    public static int search(int[] nums, int target) {
        return process(nums,0,nums.length-1,target);
    }

    public static int process(int[] arr, int L,int R,int target){
        if(L > R){
            return -1;
        }else if(L == R && target != arr[L]){
            return -1;
        }
        int mid = L + ((R-L) >> 1);

        if(target == arr[mid]){
            return mid;
        }else if(target > arr[mid]){
            return process(arr,mid+1,R,target);
        }else{
            return process(arr,L,mid,target);
        }
    }

    public static void main(String[] args) {
        int []nums= {-1,0,3,5,9,12};
        int result = search(nums,13);
        System.out.println(result);
    }
}
