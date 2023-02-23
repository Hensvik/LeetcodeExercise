package String;

//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

public class 剑指offer05替换空格 {
    //代码随想录解法1,常规写法，需要额外O(n)的空间
    public String replaceSpace1(String s) {
        if(s==null){
            return null;
        }
        //选用StringBuilder单线程使用，比较快
        StringBuilder sb = new StringBuilder();
        //使用 sb 逐个复制 s ，碰到空格则替换，否则直接复制
        for (int i = 0; i < s.length(); i++) {
            //s.charAt(i) 为 char 类型，为了比较需要将其转为和 " " 相同的字符串类型
            //if (" ".equals(String.valueOf(s.charAt(i)))){}
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    //代码随想录解法2 双指针法
    public static String replaceSpace2(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        //扩充空间，空格数量2倍
        //遍历s获取空格数量str
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                str.append("  ");
            }
        }

        //若是没有空格直接返回
        if(str.length() == 0){
            return s;
        }
        //有空格情况 定义两个指针
        int left = s.length() - 1;//左指针：指向原始字符串最后一个位置
        s += str.toString();
        //此时字符串为原字符串加上四个空格
        int right = s.length()-1;//右指针：指向扩展字符串的最后一个位置
        char[] chars = s.toCharArray();
        while(left>=0){
            if(chars[left] == ' '){
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right] = '%';
            }else{
                chars[right] = chars[left];
            }
            left--;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        replaceSpace2("We are happy.");
    }
}
