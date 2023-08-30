package Array.Binary;

//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
//
//由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
//
//注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。

public class question69x的平方根 {
    public static int mySqrt(int x) {
        int L = 0;
        int R = x/2;
        int temp = 0;
        while(L<=R){
            int mid = L+(R-L)/2;

            if(mid*mid<=x){
                temp = mid;
                L=mid+1;
            }else{
                R=mid-1;
            }
        }
        System.out.println(temp);
        return temp;
    }

    public static void main(String[] args) {
        mySqrt(8);
    }
}
