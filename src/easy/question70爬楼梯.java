package easy;

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
