package easy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class question1005K次取反后最大化的数组和 {
    public static int largestSumAfterKNegations(int[] nums, int k) {
        // 将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //从前向后遍历，遇到负数将其变为正数，同时K--
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        // 如果K还大于0，那么反复转变数值最小的元素，将K用完

        if (k % 2 == 1) nums[len - 1] = -nums[len - 1];
        return Arrays.stream(nums).sum();
    }

    public static void main(String[] args) {
        int []nums = {-2,9,9,8,4};
        largestSumAfterKNegations(nums,5);
    }
}
