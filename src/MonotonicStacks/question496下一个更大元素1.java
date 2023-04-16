package MonotonicStacks;

//nums1中数字x的 下一个更大元素 是指x在nums2 中对应位置 右侧 的 第一个 比x大的元素。
//给你两个 没有重复元素 的数组nums1 和nums2 ，下标从 0 开始计数，其中nums1是nums2的子集。
//对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
//返回一个长度为nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
//
//示例 1：
//
//输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
//输出：[-1,3,-1]
//解释：nums1 中每个值的下一个更大元素如下所述：
//- 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
//- 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
//- 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
//示例 2：
//
//输入：nums1 = [2,4], nums2 = [1,2,3,4].
//输出：[3,-1]
//解释：nums1 中每个值的下一个更大元素如下所述：
//- 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
//- 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
//
//
//提示：
//
//1 <= nums1.length <= nums2.length <= 1000
//0 <= nums1[i], nums2[i] <= 104
//nums1和nums2中所有整数 互不相同
//nums1 中的所有整数同样出现在 nums2 中

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class question496下一个更大元素1 {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> temp = new Stack<>();
        int[] res = new int[nums1.length];
        Arrays.fill(res,-1);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0 ; i< nums1.length ; i++){
            hashMap.put(nums1[i],i);
        }
        //将0添加入栈中
        temp.add(0);

        for (int i = 1; i < nums2.length; i++) {
            //从nums2[0]开始比较，如果后一位比栈顶的值小，则入栈（实际是遍历放入递减栈），否则
            if(nums2[i] <= nums2[temp.peek()]){
                temp.add(i);
            }else{
                //当栈不为空 且 栈顶的元素 小于 nums2的时候 记录序号
                while(!temp.isEmpty() && nums2[temp.peek()] < nums2[i]){
                    //如果nums1中存在nums2的栈顶最大值
                    if (hashMap.containsKey(nums2[temp.peek()])){
                        Integer index = hashMap.get(nums2[temp.peek()]);
                        res[index] = nums2[i];
                    }
                    //弹出
                    temp.pop();
                }
                temp.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int []nums1 = {4,1,2};
        int []nums2 = {1,3,4,2};
        nextGreaterElement(nums1,nums2);
    }
}
