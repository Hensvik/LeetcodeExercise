package DynamicProgramming.Bag.BagFull;

//给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
//完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
//
//示例1：
//
//输入：n = 12
//输出：3
//解释：12 = 4 + 4 + 4
//示例 2：
//
//输入：n = 13
//输出：2
//解释：13 = 4 + 9
//
//提示：
//
//1 <= n <= 104

public class question279完全平方数 {
    public static int numSquares(int n) {
        int i=0;
        while(i*i<=n){
            i++;
        }

        int []dp = new int[n+1];
        for (int j = 0; j < dp.length; j++) {
            dp[j]=Integer.MAX_VALUE;
        }

        dp[0]=0;
        for (int j = 1; j < i; j++) {
            for (int k = 1; k <= n; k++) {
                if(k>=j*j){
                    dp[k] = Math.min(dp[k],dp[k-j*j]+1);
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        numSquares(1);
    }
}
