package dynamicProgramming.packageComplete;

import java.util.List;

/**
 * @Author: jia
 * Time: 2023/1/14  18:12
 * Description:
 * Version:
 */
public class que139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int sLen = s.length();
        boolean[] dp = new boolean[sLen + 1];
        dp[0] = true;
        for (int i = 0; i <= sLen; i++) {
            String str = s.substring(0, i + 1);
            for (String word : wordDict) {
                if (dp[i]){
                    break;
                }
                int wordLen = word.length();
                if (i + 1 >= wordLen) {
                    if (str.endsWith(word)){
                        dp[i] = dp[i+1-wordLen];
                    }
                }
            }
        }
        return dp[sLen];
    }
}
