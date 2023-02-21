package MapAndSet;

//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
//注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
//
//示例1:
//
//输入: s = "anagram", t = "nagaram"
//输出: true
//示例 2:
//
//输入: s = "rat", t = "car"
//输出: false
//
//提示:
//
//1 <= s.length, t.length <= 5 * 104
//s 和 t仅包含小写字母
//
//
//进阶:如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class question242有效的字母异位词 {
    public static boolean isAnagram(String s, String t) {
        char []S = s.toCharArray();
        char []T = t.toCharArray();

        Map<Character,Integer> map = new HashMap<>();
        for (char item :S) {
            map.put(item,map.get(item)==null?1:map.get(item)+1);
        }

        for (char item :T) {
            Integer count = map.get(item);
            if(count == null || count==0){
                return false;
            }else{
                map.put(item,map.get(item)-1);
            }
        }

        Set<Character> chars = map.keySet();
        for (Character item : chars) {
            if(map.get(item)!=0){
                return false;
            }
        }

        return true;
    }

    //代码随想录的进阶写法
    //满足unicode的情况
    public boolean isAnagram2(String s, String t) {
        int[] record = new int[26];

        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;     // 并不需要记住字符a的ASCII，只要求出一个相对数值就可以了
        }

        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }

        for (int count: record) {
            if (count != 0) {               // record数组如果有的元素不为零0，说明字符串s和t 一定是谁多了字符或者谁少了字符。
                return false;
            }
        }
        return true;                        // record数组所有元素都为零0，说明字符串s和t是字母异位词
    }
}
