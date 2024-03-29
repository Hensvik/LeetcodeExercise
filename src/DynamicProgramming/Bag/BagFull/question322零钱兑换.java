package DynamicProgramming.Bag.BagFull;

//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额
//计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1
//你可以认为每种硬币的数量是无限的。
//
//示例1：
//
//输入：coins = [1, 2, 5], amount = 11
//输出：3
//解释：11 = 5 + 5 + 1
//示例 2：
//
//输入：coins = [2], amount = 3
//输出：-1
//示例 3：
//
//输入：coins = [1], amount = 0
//输出：0
//
//提示：
//
//1 <= coins.length <= 12
//1 <= coins[i] <= 231 - 1
//0 <= amount <= 104

public class question322零钱兑换 {
    public static int coinChange(int[] coins, int amount) {
        //dp代表能凑出总额为0到amount的组合数
        int []dp = new int[amount+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i]=Integer.MAX_VALUE;
        }

        dp[0]=0;
        for (int i = 0; i < coins.length; i++) {
            //这个位置从1开始遍历也不会错，但是从coins[i]遍历更快，因为i装不下coins[i]是不需要遍历的
            for (int j = coins[i]; j <= amount; j++) {
                if(j>=coins[i]){
                    if(dp[j-coins[i]]!=Integer.MAX_VALUE){
                        dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
                    }
                }
            }
        }
        if(dp[amount]==Integer.MAX_VALUE){
            return -1;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int []coins = {1,2,5};
        int amount = 11;
        coinChange(coins,amount);
    }
}
