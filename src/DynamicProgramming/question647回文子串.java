package DynamicProgramming;

//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
//回文字符串 是正着读和倒过来读一样的字符串。
//子字符串 是字符串中的由连续字符组成的一个序列。
//具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
//
//示例 1：
//
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
//示例 2：
//
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
//
//提示：
//
//1 <= s.length <= 1000
//s 由小写英文字母组成

public class question647回文子串 {
    public static int countSubstrings(String s) {
        int len = s.length();
        int []dp = new int[len+1];
        dp[0]=0;

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= i; j++) {
                if(isPalindrome(s,j-1,i-1)){
                    dp[i] = Math.max(dp[i],dp[i-1])+1;
                }
            }
        }
        return dp[len];
    }

    //判断是否是回文串的写法
    static boolean isPalindrome(String s,int start,int end){
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static int countSubstrings2(String s) {
        int len, ans = 0;
        if (s == null || (len = s.length()) < 1) return 0;
        //总共有2 * len - 1个中心点
        for (int i = 0; i < 2 * len - 1; i++) {
            //通过遍历每个回文中心，向两边扩散，并判断是否回文字串
            //有两种情况，left == right，right = left + 1，这两种回文中心是不一样的
            int left = i / 2, right = left + i % 2;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                //如果当前是一个回文串，则记录数量
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        countSubstrings2("aaa");
    }
}
