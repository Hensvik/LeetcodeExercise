package DynamicProgramming;

//给定一个整数数组prices ，它的第 i 个元素prices[i] 是一支给定的股票在第 i 天的价格。
//设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
//注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//示例 1：
//
//输入：k = 2, prices = [2,4,1]
//输出：2
//解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
//示例 2：
//
//输入：k = 2, prices = [3,2,6,5,0,3]
//输出：7
//解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
//
//
//提示：
//
//0 <= k <= 100
//0 <= prices.length <= 1000
//0 <= prices[i] <= 1000

public class question188买卖股票的最佳时机4 {
    public static int maxProfit(int k, int[] prices) {
        if(k==0 || prices.length==0){
            return 0;
        }

        k = k*2+1;
        int n = prices.length;

        int[][] dp = new int[n][k];     // 创建二维数组存储状态,dp数组表示收益

        //定义5种状态 0：没有操作，1：第一次买入，2：第一次卖出，3：第二次买入，4：第二次卖出
        for (int i = 0; i < k; i++) {
            if(i%2!=0){
                dp[0][i]=-prices[0];
            }
        }

        //初始化第二次买入的状态是确保，最后结果是最多两次买卖的最大利润

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j]=dp[i-1][j];    //第二天不进行操作
                if(j%2==1){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1]-prices[i]); //第i天第一次买入股票
                }else if(j%2==0 && j!=0){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1]+prices[i]); //第i天第一次卖出股票
                }
            }
        }
        return dp[prices.length-1][k-1];
    }

    public static void main(String[] args) {
        int[] prices = {1,2};
        maxProfit(1,prices);
    }
}
