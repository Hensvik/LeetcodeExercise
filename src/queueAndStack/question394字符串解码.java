package queueAndStack;

//给定一个经过编码的字符串，返回它解码后的字符串。
//
//编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
//
//你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
//
//此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像3a或2[4]的输入。
//
//示例 1：
//
//输入：s = "3[a]2[bc]"
//输出："aaabcbc"
//示例 2：
//
//输入：s = "3[a2[c]]"
//输出："accaccacc"
//示例 3：
//
//输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
//示例 4：
//
//输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
//
//提示：
//
//1 <= s.length <= 30
//s由小写英文字母、数字和方括号'[]' 组成
//s保证是一个有效的输入。
//s中所有整数的取值范围为[1, 300]
//

import java.util.Stack;

//以下解法仍存在错误

public class question394字符串解码 {
    public static String decodeString(String s) {
        char []encodes = s.toCharArray();
        //记录数字
        int num = 0;
        String ans = "";
        String res = "";

        Stack temp = new Stack();

        for (int i = 0; i < encodes.length; i++) {
            if(encodes[i]>='0' && encodes[i]<='9'){
                num = num * 10 + (encodes[i]-'0');
            }

            if(encodes[i]>='a' && encodes[i]<='z'){
                ans = ans + encodes[i];
            }

            if(encodes[i]=='['){
                temp.push(ans);
                temp.push(num);
                ans = "";
                num = 0;
            }

            if(encodes[i]==']'){
                int count = (int) temp.pop();
                String tempStr = "";
                for (int j = 0; j < count; j++) {
                    tempStr = tempStr + ans;
                }
                ans = "";
                res = res + tempStr;
                //while(temp.pop())
            }
        }
        return res+ans;
    }

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        System.out.println(decodeString(s));
    }
}
