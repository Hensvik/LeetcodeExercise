package DynamicProgramming;

//假设你正在爬楼梯。需要 n阶你才能到达楼顶。
//每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
//示例 1：
//
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶
//示例 2：
//
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
//
//提示：
//
//1 <= n <= 45

public class question70爬楼梯 {
    public int climbStairs(int n) {
        int temp1 = 1;
        int temp2 = 2;
        int sum=0;
        for(int j=3;j<=n;j++){
            sum = temp1+temp2;
            temp1 = temp2;
            temp2 = sum;
        }
        return temp2;
    }
}
