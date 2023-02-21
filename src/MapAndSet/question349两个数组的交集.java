package MapAndSet;

//给定两个数组nums1和nums2 ，返回 它们的交集。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
//
//
//
//示例 1：
//
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
//示例 2：
//
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//解释：[4,9] 也是可通过的
//
//
//提示：
//
//1 <= nums1.length, nums2.length <= 1000
//0 <= nums1[i], nums2[i] <= 1000

import java.util.HashSet;
import java.util.Set;

public class question349两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        //两个数组做转换
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        //遍历数组1
        for (int i : nums1) {
            set1.add(i);
        }
        //遍历数组2的过程中判断哈希表中是否存在该元素
        for (int i : nums2) {
            if (set1.contains(i)) {
                resSet.add(i);
            }
        }

        //方法1：将结果集合转为数组

        return resSet.stream().mapToInt(x -> x).toArray();

        //方法2：另外申请一个数组存放setRes中的元素,最后返回数组
        /*int[] arr = new int[setRes.size()];
        int j = 0;
        for(int i : setRes){
            arr[j++] = i;
        }*/

        //return arr;
    }
}
