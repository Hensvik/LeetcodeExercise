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
        while(L<R){
            int mid = L+(R-L)/2;
            //这个写法有越界的风险
            //if(mid*mid <= x && (mid + 1)*(mid+1) > x){
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            }else if(mid*mid>x){
                R=mid-1;
            }else if(mid*mid<x){
                L=mid+1;
            }
        }
        return L;
    }

    public static void main(String[] args) {
        mySqrt(2);
    }
}
