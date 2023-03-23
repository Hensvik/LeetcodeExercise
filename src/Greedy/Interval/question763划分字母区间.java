package Greedy.Interval;

//给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
//注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
//返回一个表示每个字符串片段的长度的列表。
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
//提示：
//
//S的长度在[1, 500]之间。
//S只包含小写字母 'a' 到 'z' 。

import java.util.*;

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

    public static List<Integer> partitionLabels1(String S) {
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

    public static List<Integer> partitionLabels2(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        List<Integer> res = new ArrayList<>();

        char []temp = s.toCharArray();
        Integer []word = new Integer[26];
        int []pos = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            word[temp[i]-'a']=i;
        }

        for (int i = 0; i < temp.length; i++) {
            pos[i]=word[temp[i]-'a'];
        }

        int count = 0;
        int max = -1;
        for (int i = 1; i <= temp.length; i++) {
            count++;
            max = Math.max(pos[i-1],max);
            if(i-1==max){
                res.add(count);
                count = 0;
            }
        }
        return res;
    }

    //代码随想录
    /*解法二： 上述c++补充思路的Java代码实现*/
    public  int[][] findPartitions(String s) {
        List<Integer> temp = new ArrayList<>();
        int[][] hash = new int[26][2];//26个字母2列 表示该字母对应的区间

        for (int i = 0; i < s.length(); i++) {
            //更新字符c对应的位置i
            char c = s.charAt(i);
            if (hash[c - 'a'][0] == 0){
                hash[c - 'a'][0] = i;
            }

            hash[c - 'a'][1] = i;

            //第一个元素区别对待一下
            hash[s.charAt(0) - 'a'][0] = 0;
        }


        List<List<Integer>> h = new LinkedList<>();
        //组装区间
        for (int i = 0; i < 26; i++) {
            //if (hash[i][0] != hash[i][1]) {
            temp.clear();
            temp.add(hash[i][0]);
            temp.add(hash[i][1]);
            //System.out.println(temp);
            h.add(new ArrayList<>(temp));
            // }
        }
        // System.out.println(h);
        // System.out.println(h.size());
        int[][] res = new int[h.size()][2];
        for (int i = 0; i < h.size(); i++) {
            List<Integer> list = h.get(i);
            res[i][0] =  list.get(0);
            res[i][1] =  list.get(1);
        }

        return res;

    }

    public  List<Integer> partitionLabels(String s) {
        int[][] partitions = findPartitions(s);
        List<Integer> res = new ArrayList<>();
        Arrays.sort(partitions, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int right = partitions[0][1];
        int left = 0;
        for (int i = 0; i < partitions.length; i++) {
            if (partitions[i][0] > right) {
                //左边界大于右边界即可纪委一次分割
                res.add(right - left + 1);
                left = partitions[i][0];
            }
            right = Math.max(right, partitions[i][1]);

        }
        //最右端
        res.add(right - left + 1);
        return res;

    }

    public static void main(String[] args) {
        String s="ababcbacadefegdehijhklij";
        partitionLabels2(s);
    }
}
