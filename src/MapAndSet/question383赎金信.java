package MapAndSet;

//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
//
//如果可以，返回 true ；否则返回 false 。
//
//magazine 中的每个字符只能在 ransomNote 中使用一次。
//
//示例 1：
//
//输入：ransomNote = "a", magazine = "b"
//输出：false
//示例 2：
//
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
//示例 3：
//
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
//
//提示：
//
//1 <= ransomNote.length, magazine.length <= 105
//ransomNote 和 magazine 由小写英文字母组成

import java.util.HashMap;
import java.util.Map;

public class question383赎金信 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        char []m=magazine.toCharArray();
        char []r=ransomNote.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (Character item :m) {
            map.put(item,map.get(item)==null?1:map.get(item)+1);
        }

        for (Character item :r) {
            if(map.get(item)== null || map.get(item)==0){
                return false;
            }else{
                map.put(item,map.get(item)-1);
            }
        }
        return true;
    }

    //代码随想录版本，利用数组存储数据
    public boolean canConstruct2(String ransomNote, String magazine) {
        // 定义一个哈希映射数组
        int[] record = new int[26];

        // 遍历
        for(char c : magazine.toCharArray()){
            record[c - 'a'] += 1;
        }

        for(char c : ransomNote.toCharArray()){
            record[c - 'a'] -= 1;
        }

        // 如果数组中存在负数，说明ransomNote字符串总存在magazine中没有的字符
        for(int i : record){
            if(i < 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(ransomNote,magazine));
    }
}
