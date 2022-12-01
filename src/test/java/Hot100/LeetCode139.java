package Hot100;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 单词拆分
 * Version:
 */
public class LeetCode139 {
    @Test
    public void test(){
        String s = "abcde";
        char c = s.charAt(1);
        String substring = s.substring(0, 1);
        System.out.println(s.charAt(1));
        System.out.println(s.substring(0,1));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len];
        for(int i=0;i<len;i++){
            dp[i]=false;
        }
        for(int i=0;i<len;i++){
            if(i==0){
                if(wordDict.contains(s.substring(0,1))){
                    dp[0] = true;
                }
            }

            if(wordDict.contains(s.substring(0,i+1))){
                dp[i] = true;
                continue;
            }


            for(int j=0;j<i;j++){
                if(dp[j]){
                    if(wordDict.contains(s.substring(j+1,i+1))){
                        dp[i]=true;
                        break;
                    }
                }
            }
        }

        return dp[len-1];
    }


}
