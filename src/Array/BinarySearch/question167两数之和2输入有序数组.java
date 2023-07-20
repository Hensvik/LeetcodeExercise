package Array.BinarySearch;

//给定一个已按照 非递减顺序排列 的整数数组numbers ，请你从数组中找出两个数满足相加之和等于目标数target 。
//函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
//你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
//
//示例 1：
//
//输入：numbers = [2,7,11,15], target = 9
//输出：[1,2]
//解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
//示例 2：
//
//输入：numbers = [2,3,4], target = 6
//输出：[1,3]
//示例 3：
//
//输入：numbers = [-1,0], target = -1
//输出：[1,2]
//
//提示：
//
//2 <= numbers.length <= 3 * 104
//-1000 <= numbers[i] <= 1000
//numbers 按 非递减顺序 排列
//-1000 <= target <= 1000
//仅存在一个有效答案
//通过次数348,993提交次数594,068

//从第1和第n分别向中间遍历，小了left右移，大了right左移
public class question167两数之和2输入有序数组 {
    public static int[] twoSum1(int[] numbers, int target) {
        int left;
        int right = numbers.length-1;
        int sum;
        for(left=0;left<right;){
            sum= numbers[left]+numbers[right];
            if(target>sum){
               left++;
            }else if(target<sum){
                right--;
            }else{
                break;
            }
        }
        return new int[]{left+1,right+1};
    }

    public static int[] twoSum2(int[] numbers, int target) {
        int L = 0;
        int R = numbers.length-1;
        while(L<R){
            int sum = numbers[L]+numbers[R];
            if(target<sum){
                R--;
            }else if(target>sum){
                L++;
            }else{
                break;
            }
        }
        return new int[]{L+1,R+1};
    }


    public static void main(String[] args) {
        int[]i = {2,7,9,11};
        int []j = twoSum2(i,11);
        for (int k:j) {
            System.out.println(k);
        }
        System.out.println(j);
    }
}
