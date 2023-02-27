package queueAndStack;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
//有效字符串需满足：
//
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。
// 
//
//示例 1：
//
//输入：s = "()"
//输出：true
//示例 2：
//
//输入：s = "()[]{}"
//输出：true
//示例 3：
//
//输入：s = "(]"
//输出：false
//示例 4：
//
//输入：s = "([)]"
//输出：false
//示例 5：
//
//输入：s = "{[]}"
//输出：true
//

import java.util.Stack;

public class question20有效的括号 {
    public static boolean isValid(String s) {
        //统计各类括号
        int parentheses1 = 0;
        int parentheses2 = 0;
        int parentheses3 = 0;
        char[] c = s.toCharArray();
        Stack<Character>stack = new Stack<Character>();
        for(int i=0;i<c.length;i++){
            switch (c[i]){
                case '(':
                    parentheses1++;
                    stack.push(c[i]);
                    break;
                case ')':
                    parentheses1--;
                    if(stack.empty() ==true || (stack.empty() !=true && stack.pop() != '(')){
                        return false;
                    }
                    break;
                case '[':
                    parentheses2++;
                    stack.push(c[i]);
                    break;
                case ']':
                    parentheses2--;
                    if(stack.empty() ==true || (stack.empty() !=true && stack.pop() != '[')){
                        return false;
                    }
                    break;
                case '{':
                    parentheses3++;
                    stack.push(c[i]);
                    break;
                case '}':
                    parentheses3--;
                    if(stack.empty() ==true || (stack.empty() !=true && stack.pop() != '{')){
                        return false;
                    }
                    break;
            }
        }
        if(stack.size()==0){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "([)]";
        s.replace("()","");
        System.out.println(s);
        isValid(s);
    }
}
