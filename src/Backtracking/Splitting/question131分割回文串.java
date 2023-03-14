package Backtracking.Splitting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
//回文串 是正着读和反着读都一样的字符串。
//
//示例 1：
//
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
//示例 2：
//
//输入：s = "a"
//输出：[["a"]]
//
//提示：
//
//1 <= s.length <= 16
//s 仅由小写英文字母组成

public class question131分割回文串 {
    static List<List<String>> res = new ArrayList<>();
    static LinkedList<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {
        backTracking(s,0);
        return res;
    }

    public static void backTracking(String s,int index){
        if(index==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            //如果是回文子串，则记录
            if(isPalindrome(s,index,i)){
                String str = s.substring(index,i+1);
                path.add(str);
            }else{
                continue;
            }
            //起始位置后移，保证不重复
            backTracking(s,i+1);
            path.removeLast();
        }
    }

    //判断是否是回文串的写法
    static boolean isPalindrome(String s,int start,int end){
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
