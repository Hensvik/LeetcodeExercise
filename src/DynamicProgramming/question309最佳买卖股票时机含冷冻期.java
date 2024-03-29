package DynamicProgramming;

//给定一个整数数组prices，其中第prices[i]表示第i天的股票价格 。
//设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
//
//卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
//注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//示例 1:
//
//输入: prices = [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
//示例 2:
//
//输入: prices = [1]
//输出: 0
//
//提示：
//
//1 <= prices.length <= 5000
//0 <= prices[i] <= 1000

//可以交易多次的情况下不能将dp数组定义成买入和卖出的情况，除非限定了交易次数
//而要定义成持有或者不持有的情况

public class question309最佳买卖股票时机含冷冻期 {
    public static int maxProfit1(int[] prices) {
        int n = prices.length;
        int [][]dp = new int[n][4];

        //持有股票的状态
        dp[0][0]=-prices[0];
        //保持卖出股票的状态
        dp[0][1]=0;
        //卖出股票的状态
        dp[0][2]=0;
        //冷冻期
        dp[0][3]=0;

        for (int i = 1; i < n; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][3]-prices[i]);
            dp[i][1]=dp[i-1][3];
            dp[i][2]=Math.max(dp[i-1][0]+prices[i],dp[i-1][2]);
            dp[i][3]=dp[i-1][2];
        }

        return Math.max(dp[n-1][2],dp[n-1][3]);
    }

    //leetcode解法，三状态
    public static int maxProfit2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        for (int i = 1; i < n; ++i) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        return Math.max(f[n - 1][1], f[n - 1][2]);
    }

    public static void main(String[] args) {
        int []prices = {1,2,3,0,2};
        maxProfit2(prices);
    }
}
