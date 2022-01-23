package easy;

//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
//
//如果可以，返回 true ；否则返回 false 。
//
//magazine 中的每个字符只能在 ransomNote 中使用一次。
//
// 
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
//
//提示：
//
//1 <= ransomNote.length, magazine.length <= 105
//ransomNote 和 magazine 由小写英文字母组成
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/ransom-note
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.HashMap;
import java.util.Map;

public class question383赎金信 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer>map = new HashMap<Character, Integer>();
        char[]ran = ransomNote.toCharArray();
        char[]mag = magazine.toCharArray();

        for (int i = 0; i < mag.length; i++) {
            map.put(mag[i],map.getOrDefault(mag[i],0)+1);
        }

        for (int j = 0; j < ran.length; j++) {
            if(!map.containsKey(ran[j]) || map.get(ran[j])==0){
                return false;
            }else {
                map.put(ran[j],map.get(ran[j])-1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aa";
        canConstruct(ransomNote,magazine);
    }
}
