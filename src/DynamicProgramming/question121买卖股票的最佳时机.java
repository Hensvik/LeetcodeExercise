package DynamicProgramming;

//给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
//你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
//返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
//
//示例 1：
//
//输入：[7,1,5,3,6,4]
//输出：5
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
//示例 2：
//
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
//
//提示：
//
//1 <= prices.length <= 105
//0 <= prices[i] <= 104

public class question121买卖股票的最佳时机 {
    //自己写的 贪心
    public static int maxProfit1(int[] prices) {
        int []dp = new int [prices.length];

        dp[0] = prices[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i]=Math.min(dp[i-1],prices[i]);
        }

        dp[0]=0;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(prices[i]-dp[i],dp[i-1]);
        }

        return dp[prices.length-1];
    }

    //代码随想录 贪心算法
    public static int maxProfit2(int[] prices) {
        // 找到一个最小的购入点
        int low = Integer.MAX_VALUE;
        // res不断更新，直到数组循环完毕
        int res = 0;
        for(int i = 0; i < prices.length; i++){
            low = Math.min(prices[i], low);
            res = Math.max(prices[i] - low, res);
        }
        return res;
    }

    //左程云 贪心
    public static int maxProfit(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }

        int min = prices[0],max=0;
        for(int i = 1;i<prices.length;i++){
            max = Math.max(max,prices[i] - min);
            min = Math.min(min,prices[i]);
        }
        return max;
    }

    //代码随想录 动态规划
    public static int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        // dp[i][0]代表第i天持有股票的最大收益
        // dp[i][1]代表第i天不持有股票的最大收益
        int[][] dp = new int[length][2];
        int result = 0;

        //设置为相反数 含义为 当天持有股票
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < length; i++) {
            //第i天持有股票的最大收益=前一天持有股票的受益 和 当天买入股票 的最大值
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            //第i天不持有股票的最大收益=前一天持有股票的收益+第i天的股价 和 第i-1天不持有股票的最大收益
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return dp[length - 1][1];
    }

    public static void main(String[] args) {
        int []prices={7,1,5,3,6,4};
        maxProfit3(prices);
    }
}
