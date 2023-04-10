package DynamicProgramming;

//给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数。
//题目数据保证答案符合 32 位带符号整数范围。
//
//示例1：
//
//输入：s = "rabbbit", t = "rabbit"
//输出：3
//解释：
//如下所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
//rabbbit
//rabbbit
//rabbbit
//示例2：
//
//输入：s = "babgbag", t = "bag"
//输出：5
//解释：
//如下所示, 有 5 种可以从 s 中得到 "bag" 的方案。 
//babgbag
//babgbag
//babgbag
//babgbag
//babgbag
//
//
//提示：
//
//1 <= s.length, t.length <= 1000
//s 和 t 由英文字母组成

public class question115不同的子序列 {
    public int numDistinct(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();

        int[][]dp = new int[len1+1][len2+1];
        for (int i = 0; i < s.length() + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                //如果某一个字符串相同，则dp为
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {

    }
}
