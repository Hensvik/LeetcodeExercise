package DynamicProgramming;

//给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
//子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
//
//示例 1：
//
//输入：s = "bbbab"
//输出：4
//解释：一个可能的最长回文子序列为 "bbbb" 。
//示例 2：
//
//输入：s = "cbbd"
//输出：2
//解释：一个可能的最长回文子序列为 "bb" 。
//
//提示：
//
//1 <= s.length <= 1000
//s 仅由小写英文字母组成

import java.util.Arrays;

public class question516最长回文子序列 {
    public static int longestPalindromeSubseq(String s) {
        int len = s.length();
        int []dp = new int[len+1];

        dp[0]=0;
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= i; j++) {
                if(isPalindrome(s,j-1,i-1)){
                    dp[i]=Math.max(dp[i-1],i-j);
                }
            }
        }
        return 1;
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
