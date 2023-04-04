package DynamicProgramming;

//给你一个整数数组 prices ，其中prices[i] 表示某支股票第 i 天的价格。
//在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
//返回 你能获得的 最大 利润。
//
//示例 1：
//
//输入：prices = [7,1,5,3,6,4]
//输出：7
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
//随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
//总利润为 4 + 3 = 7 。
//示例 2：
//
//输入：prices = [1,2,3,4,5]
//输出：4
//解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
//总利润为 4 。
//示例3：
//
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。
//
//提示：
//
//1 <= prices.length <= 3 * 104
//0 <= prices[i] <= 104

public class question122买卖股票的最佳时机2 {
    public static int maxProfit1(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];     // 创建二维数组存储状态,dp数组表示收益
        dp[0][0] = 0;                   // 表示不持有股票时现金为0
        dp[0][1] = -prices[0];          // 表示持有股票时负债-prices
        for (int i = 1; i < n; ++i) {
            //第i天不持有股票时的现金为 前一天 不持有股票的最高现金 或 今天卖出股票的收益
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);    // 第 i 天，没有股票
            //第i天持有股票时的现金为 前一天 持有该股票时的最高现金 或 前一天不持有该股票时的钱+今天买入股票
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);    // 第 i 天，持有股票
        }
        return dp[n - 1][0];    // 卖出股票收益高于持有股票收益，因此取[0]
    }

    public static int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];     // 创建二维数组存储状态,dp数组表示收益
        dp[0][0] = -prices[0];          // 表示持有股票时负债-prices
        dp[0][1] = 0;                   // 表示不持有股票时现金为0
        for (int i = 1; i < n; ++i) {
            //第i天持有股票时的现金为 前一天 持有该股票时的最高现金 或 前一天不持有该股票时的钱+今天买入股票
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);    // 第 i 天，没有股票
            //第i天不持有股票时的现金为 前一天 不持有股票的最高现金 或 今天卖出股票的收益
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);    // 第 i 天，持有股票
        }
        return dp[n-1][1];    // 卖出股票收益高于持有股票收益，因此取[0]
    }

    //优化
    public int maxProfit3(int[] prices) {
        int[] dp = new int[2];
        // 0表示持有，1表示卖出
        dp[0] = -prices[0];
        dp[1] = 0;
        for(int i = 1; i <= prices.length; i++){
            // 前一天持有; 既然不限制交易次数，那么再次买股票时，要加上之前的收益
            dp[0] = Math.max(dp[0], dp[1] - prices[i-1]);
            // 前一天卖出; 或当天卖出，当天卖出，得先持有
            dp[1] = Math.max(dp[1], dp[0] + prices[i-1]);
        }
        return dp[1];
    }

    //贪心算法
    public int maxProfit(int[] prices) {
        if(prices==null){
            return 0;
        }
        int profit=0;
        boolean isHas=false;
        for(int i=0;i<prices.length;i++){
            if(isHas){
                profit+=prices[i]-prices[i-1];
                isHas=false;
            }
            if(i<prices.length-1 && prices[i+1]>prices[i]){
                isHas=true;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int []prices = {7,1,5,3,6,4};
        maxProfit2(prices);
    }
}
