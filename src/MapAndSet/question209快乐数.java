package MapAndSet;

//编写一个算法来判断一个数 n 是不是快乐数。
//
//「快乐数」定义为：
//
//对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
//然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
//如果这个过程 结果为1，那么这个数就是快乐数。
//如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
//
//示例 1：
//
//输入：n = 19
//输出：true
//解释：
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
//示例 2：
//
//输入：n = 2
//输出：false
//
//
//提示：
//
//1 <= n <= 231 - 1

import java.util.HashSet;
import java.util.Set;

public class question209快乐数 {
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(!set.contains(n)){
            set.add(n);

            int temp = 0;
            //注意此处条件为!=0，而不是取余的判断
            while(n!=0){
                temp = temp+(int)Math.pow(n%10,2);
                n=n/10;
            }
            if(temp==1){
                return true;
            }
            n=temp;
        }
        return false;
    }

    public static void main(String[] args) {
        isHappy(19);
    }
}
