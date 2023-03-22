package Greedy;

//给定⼀个⾮负整数 N，找出⼩于或等于 N 的最⼤的整数，同时这个整数需要满⾜其各个位数上的数字是单调递增。
//（当且仅当每个相邻位数上的数字 x 和 y 满⾜ x <= y 时，我们称这个整数是单调递增的。）
//示例 1:
//输⼊: N = 10
//输出: 9
//示例 2:
//输⼊: N = 1234
//输出: 1234
//示例 3:
//输⼊: N = 332
//输出: 299
//说明: N 是在 [0, 10^9] 范围内的⼀个整数

public class question738单调递增的数字 {
    public static int monotoneIncreasingDigits1(int n) {
        char [] c = String.valueOf(n).toCharArray();
        
        for (int i = c.length-1; i > 0; i--) {
            //如果前一位比后面一位要大，那么前一位--
            if(c[i-1]>c[i]) {
                c[i-1]--;

                int k=i;
                //当k小于c的长度时，将后续位数设置为9
                while(k<=c.length-1){
                    c[k] = '9';
                    k++;
                }
            }
        }

        for (char s:c) {
            System.out.println(s);
        }
        return Integer.parseInt(new String(c));
    }

    public static int monotoneIncreasingDigits2(int n) {
        //令i=n，当i>0，每次除以10
        //k为当前的位数，遍历个位时k为1，十位时k为10，百位时k为100
        //
        for (int i = n, j = 9, k = 1; i > 0; i /= 10, k *= 10)
            if (j < (j = i % 10))// 如果后一位比前一位小
                // 以332为例，第1次走到这一步的时候 i=33,k=10, 329进入递归
                // 第2次走到这一步的时候 i=3,k=100, 299进入递归
                return monotoneIncreasingDigits2(i * k - 1);
        // 299递归出口
        return n;
    }

    public static void main(String[] args) {
        monotoneIncreasingDigits1(322);
    }
}
