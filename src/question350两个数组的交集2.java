import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
//
//示例 1：
//
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
//示例 2:
//
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9]
//
//
//提示：
//
//1 <= nums1.length, nums2.length <= 1000
//0 <= nums1[i], nums2[i] <= 1000
//
//
//进阶：
//
//如果给定的数组已经排好序呢？你将如何优化你的算法？
//如果nums1的大小比nums2 小，哪种方法更优？
//如果nums2元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class question350两个数组的交集2 {
    /*public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            //intersect(nums2,nums1)交换数组
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            //map.getOrDefault(num,0)表示map获取num的值，如果存在则返回key对应value，否则返回0
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        //Arrays.copyOfRange表示将intersection数组的0到index的内容复制到一个新数组中
        return Arrays.copyOfRange(intersection, 0, index);
    }*/

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[Math.min(length1, length2)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                intersection[index] = nums1[index1];
                index1++;
                index2++;
                index++;
            }
        }
        //因为intersection可能填不满，所以需要复制一下
        return Arrays.copyOfRange(intersection, 0, index);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,4,5,5};
        int[] nums2 = new int[]{2,3,4};
        int[] res = intersect(nums1,nums2);
        for (int r:res) {
            System.out.println(r);
        }
    }
}
