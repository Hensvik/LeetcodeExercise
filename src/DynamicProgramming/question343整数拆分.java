package DynamicProgramming;

//给定一个正整数n，将其拆分为 k 个 正整数 的和（k >= 2），并使这些整数的乘积最大化。
//返回 你可以获得的最大乘积。
//
//示例 1:
//
//输入: n = 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。
//示例2:
//
//输入: n = 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 ×3 ×4 = 36。
//
//提示:
//
//2 <= n <= 58

public class question343整数拆分 {
    public static int integerBreak(int n) {
        int []dp = new int[n+1];
        dp[2]=1;
        for(int i=3;i<=n;i++){
            for(int j=1;j<i-1;j++){
                dp[i]=Math.max(dp[i],Math.max((i-j)*j,dp[i-j]*j));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
}
