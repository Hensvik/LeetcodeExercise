package easy;

import java.util.HashMap;
import java.util.Map;

//toCharArray()
//s.indexOf()
public class question387字符串中的第一个唯一字符 {
    public static int firstUniqChar(String s) {
        Map<Character,Integer> map= new HashMap<Character,Integer>();
        char[] cs = s.toCharArray();
        for (char c:cs) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (int i = 0; i < cs.length; i++) {
            if (map.get(cs[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    //一年前的提交

    /*public static int firstUniqChar(String s) {
        for(int i=0;i<s.length();i++){
            if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))){
                return i;
            }
        }
        return -1;
    }*/

    public static void main(String[] args) {
        String str = "dddccdbba";
        firstUniqChar(str);
    }
}
