package two_pointer_method;


import java.util.HashSet;

public class LeetCode151 {

    public String reverseWords(String s) {
        System.out.print(s);
        StringBuilder sb = new StringBuilder();
        // 首位添加空格，便于分割字符串
        s = ' ' + s;
        // 两个下标用于定位单词
        int endIndex = s.length() - 1;
        int startIndex = s.length() -1;
        // 从后往前遍历，将遍历到的单词添加到sb中
        while (startIndex >= 0 && endIndex >= 0){
            if (s.charAt(endIndex) == ' '){
                endIndex--;
                startIndex--;
                continue;
            }
            if (s.charAt(startIndex) != ' ') {
                startIndex--;
                continue;
            }
            // 定位到单词
            String s1 = s.substring(startIndex + 1, endIndex+1);
            sb.append(s1);
            sb.append(' ');
            endIndex = startIndex;
        }
        // 去掉最后一个添加的空格
        return sb.substring(0,sb.length()-1);
    }

}
