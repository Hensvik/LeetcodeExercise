package Array.DoublePointer;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 
//
//示例 1:
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//示例 2:
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//示例 3:
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//示例 4:
//
//输入: s = ""
//输出: 0
// 
//
//提示：
//
//0 <= s.length <= 5 * 104
//s 由英文字母、数字、符号和空格组成
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


import java.util.*;

//Stack结构的初始化
//Stack<Character> stack = new Stack<Character>();
//stack.push()推入一个元素
//stack.pop()弹出一个元素
//stack.peek()查看堆顶元素
//stack.search()查询元素的index
//stack.contains()是否包含某元素
//stack.capacity()查询容量，初始化后默认是10，扩容后翻倍
//stack.size()这个才是当前stack中的元素数量
//stack.clear()清除stack中所有元素

public class question3无重复字符的最长子串 {
    //自己想的笨b方法，使用栈结构
    /*public static int lengthOfLongestSubstring1(String s) {
        int max=0;
        char[]c = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        Stack<Character> temp = new Stack<Character>();
        for (int i = 0; i < c.length; i++) {
            if(!stack.contains(c[i])){
                stack.push(c[i]);
                max=Math.max(max,stack.size());
            }else{
                while(c[i]!=stack.peek()){
                    temp.push(stack.pop());
                }
                stack.clear();
                while(!temp.empty()){
                    stack.push(temp.pop());
                }
                stack.push(c[i]);
            }
        }
        return max;
    }*/

    //最优解
    public static int lengthOfLongestSubstring2(String s) {
        //新建数组last并将所有值置为-1
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            //获取ascii码
            int index = s.charAt(i);
            //start为该字母的出现次数
            start = Math.max(start, last[index] + 1);
            //res记录次数
            res = Math.max(res, i - start + 1);
            //记录该字母最后出现的位置
            last[index] = i;
        }

        return res;
    }

    //灵茶山模板解法
    public static int lengthOfLongestSubstring3(String s) {
        char[] S = s.toCharArray(); // 转换成 char[] 加快效率（忽略带来的空间消耗）
        int n = s.length(), ans = 0, L = 0;
        int[] cnt = new int[128]; // 也可以用 HashMap<Character, Integer>，这里为了方便用的数组
        for (int R = 0; R < n; ++R) {
            char c = S[R];
            ++cnt[c];
            while (cnt[c] > 1) {
                // 不满足要求
                --cnt[S[L++]];
            }

            ans = Math.max(ans, R - L + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "anviaj";
        lengthOfLongestSubstring2(s);
        System.out.println();
    }
}
