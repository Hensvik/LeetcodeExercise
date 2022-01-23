package medium;

public class question122买卖股票的最佳时机2 {
    public static int maxProfit(int[] prices) {
        int cur=0;
        for(int i=0;i<prices.length-1;i++){
            prices[i]=prices[i+1]-prices[i];
        }
        for(int i=0;i<prices.length-1;i++){
            if(prices[i]>0){
                cur+=prices[i];
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        maxProfit(prices);
    }
}
