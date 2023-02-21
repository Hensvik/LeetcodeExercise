package String;

//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
//
//不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
//
//示例 1：
//
//输入：s = ["h","e","l","l","o"]
//输出：["o","l","l","e","h"]
//示例 2：
//
//输入：s = ["H","a","n","n","a","h"]
//输出：["h","a","n","n","a","H"]
//
//提示：
//
//1 <= s.length <= 105
//s[i] 都是 ASCII 码表中的可打印字符

public class question344反转字符串 {
    public void reverseString1(char[] s) {
        int left = 0;
        int right = s.length-1;
        while(left<right){
            char temp = s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
    }

    //1年前的写法，效率更高
    public void reverseString2(char[] s) {
        int j = s.length-1;
        for(int i=0;i<=j/2;i++){
            char temp = s[i];
            s[i] = s[j-i];
            s[j-i] = temp;
        }
    }

    //代码随想录版本
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            //这个是效率更高的写法
            s[l] ^= s[r];  //构造 a ^ b 的结果，并放在 a 中
            s[r] ^= s[l];  //将 a ^ b 这一结果再 ^ b ，存入b中，此时 b = a, a = a ^ b
            s[l] ^= s[r];  //a ^ b 的结果再 ^ a ，存入 a 中，此时 b = a, a = b 完成交换
            l++;
            r--;
        }
    }
}
