package DynamicProgramming;

//给定两个单词word1和word2，返回使得word1和word2相同所需的最小步数。
//每步可以删除任意一个字符串中的一个字符。
//
//示例 1：
//
//输入: word1 = "sea", word2 = "eat"
//输出: 2
//解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
//示例 2:
//
//输入：word1 = "leetcode", word2 = "etco"
//输出：4
//
//提示：
//
//1 <= word1.length, word2.length <= 500
//word1和word2只包含小写英文字母

//本题和动态规划：1143.最长公共子序列 (opens new window)基本相同，只要求出两个字符串的最长公共子序列长度即可，那么除了最长公共子序列之外的字符都是必须删除的，最后用两个字符串的总长度减去两个最长公共子序列的长度就是删除的最少步数。

//思路二：


public class question583两个字符串的删除操作 {
    public static int minDistance1(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int [][]dp = new int[len1+1][len2+1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(len1 + len2 - dp[len1][len2] * 2);
        return len1 + len2 - dp[len1][len2] * 2;
    }

    public static int minDistance2(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int [][]dp = new int[len1+1][len2+1];
        for (int i = 0; i < len1 + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < len2 + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 2,Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        String word1 = "leetcode";
        String word2 = "etco";
        minDistance1(word1,word2);
    }
}
