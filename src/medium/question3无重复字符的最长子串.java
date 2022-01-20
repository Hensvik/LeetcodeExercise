package medium;

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


import java.util.Calendar;
import java.util.Deque;
import java.util.Stack;

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
    /*public static int lengthOfLongestSubstring(String s) {
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
    public static int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }


    public static void main(String[] args) {
        String s = "anviaj";
        lengthOfLongestSubstring(s);
        System.out.println();
    }
}
