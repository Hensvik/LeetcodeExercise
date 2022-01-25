package medium;

//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
//
// 
//
//示例：
//
//输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
// 
//
//提示：
//
//S的长度在[1, 500]之间。
//S只包含小写字母 'a' 到 'z' 。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/partition-labels
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class question763划分字母区间 {
    /*public static List<Integer> partitionLabels(String s) {
        Map<Character,Integer>map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        char[]c = s.toCharArray();
        for(int i=0;i<c.length;i++){
            map.put(c[i],i);
        }
        int max = -1;
        int start=0;
        int pre=0;
        for(int j=0;j<c.length;j++){
            max=Math.max(max,map.get(c[j]));
            if(j==max){
                list.add(max+1-pre);
                pre=max+1;
            }
        }
        return list;
    }*/

    public static List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }

        List<Integer> res = new ArrayList<>();
        int index, i, len = S.length();
        int[] cache = new int[26];
        for (i = 0; i < len; i++) {
            cache[S.charAt(i) - 'a'] = i;
        }
        i = 0;
        while (i < len) {
            index = cache[S.charAt(i) - 'a'];
            for (int j = i + 1; j < index && j < len; j++) {
                if (cache[S.charAt(j) - 'a'] > index) {
                    index = cache[S.charAt(j) - 'a'];
                }
            }
            res.add(index - i + 1);
            i = index + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        String s="ababcbacadefegdehijhklij";
        partitionLabels(s);
    }
}
