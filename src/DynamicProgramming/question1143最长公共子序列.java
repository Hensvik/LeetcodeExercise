package DynamicProgramming;

//给定两个字符串text1 和text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
//一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
//
//例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
//两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
//
//示例 1：
//
//输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace" ，它的长度为 3 。
//示例 2：
//
//输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc" ，它的长度为 3 。
//示例 3：
//
//输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0 。
//
//提示：
//
//1 <= text1.length, text2.length <= 1000
//text1 和text2 仅由小写英文字符组成。

public class question1143最长公共子序列 {
    public static int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();

        //dp[i][j]：长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j]
        //以dp[i][j]结尾的最长公共子序列
        int [][]dp = new int[len1+1][len2+1];

        for (int i = 1; i <= len1; i++) {
            char char1 = text1.charAt(i - 1);
            for (int j = 1; j <= len2; j++) {
                char char2 = text2.charAt(j - 1);
                if(char1==char2){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    //一维数组版本
    public int longestCommonSubsequence2(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        // 多从二维dp数组过程分析
        // 关键在于  如果记录  dp[i - 1][j - 1]
        // 因为 dp[i - 1][j - 1]  <!=>  dp[j - 1]  <=>  dp[i][j - 1]
        int [] dp = new int[n2 + 1];

        for(int i = 1; i <= n1; i++){

            // 这里pre相当于 dp[i - 1][j - 1]
            int pre = dp[0];
            for(int j = 1; j <= n2; j++){

                //用于给pre赋值
                int cur = dp[j];
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    //这里pre相当于dp[i - 1][j - 1]   千万不能用dp[j - 1] !!
                    dp[j] = pre + 1;
                } else{
                    // dp[j]     相当于   dp[i - 1][j]
                    // dp[j - 1] 相当于   dp[i][j - 1]
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }

                //更新dp[i - 1][j - 1], 为下次使用做准备
                pre = cur;
            }
        }

        return dp[n2];
    }

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        longestCommonSubsequence(text1,text2);
    }
}
