package DynamicProgramming.Bag;

//背包最大重量为10。
//物品为：
//      重量	价值	数量
//物品0	1	15	2
//物品1	3	20	3
//物品2	4	30	2

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class template04多重背包 {
    void testMultiPack1() {
        List<Integer> weight = new ArrayList<>(Arrays.asList(1, 3, 4));
        List<Integer> value = new ArrayList<>(Arrays.asList(15, 20, 30));
        List<Integer> nums = new ArrayList<>(Arrays.asList(2, 3, 2));
        int bagWeight = 10;

        //最外层数量遍历
        for (int i = 0; i < nums.size(); i++) {
            while(nums.get(i)>1){
                weight.add(weight.get(i));
                value.add(value.get(i));
                nums.set(i,nums.get(i)-1);
            }
        }

        int []dp = new int[bagWeight+1];
        //遍历物品
        for (int i = 0; i < weight.size(); i++) {
            //遍历背包容量
            for (int j = 0; j >= weight.get(i) ; j++) {
                dp[j] = Math.max(dp[j],dp[j-weight.get(i)]+value.get(i));
            }

            //打印
            for (int j = 0; j < bagWeight; j++) {
                System.out.print(dp[bagWeight]+" ");
            }
        }
    }

    public void testMultiPack2(){
        // 版本二：改变遍历个数
        int[] weight = new int[] {1, 3, 4};
        int[] value = new int[] {15, 20, 30};
        int[] nums = new int[] {2, 3, 2};
        int bagWeight = 10;

        int[] dp = new int[bagWeight + 1];
        for(int i = 0; i < weight.length; i++) { // 遍历物品
            for(int j = bagWeight; j >= weight[i]; j--) { // 遍历背包容量
                // 以上为01背包，然后加一个遍历个数
                for (int k = 1; k <= nums[i] && (j - k * weight[i]) >= 0; k++) { // 遍历个数
                    dp[j] = Math.max(dp[j], dp[j - k * weight[i]] + k * value[i]);
                }
                System.out.println(Arrays.toString(dp));
            }
        }
    }
}
