package toOffer;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class Offer46 {
    @Test
    public void test(){
        System.out.println(translateNum(12258));
    }

    public int translateNum(int num) {
        return backTracking(String.valueOf(num));
    }

    public int backTracking(String str){
        if (str.length() == 1){
            return 1;
        }
        if (str.length() == 2){
            int n = Integer.parseInt(str);
            if (n >= 10 && n <= 25){
                return 2;
            }else {
                return 1;
            }
        }
        String subStr = str.substring(0, 2);
        int n = Integer.parseInt(subStr);
        if (n >= 10 && n <= 25){
            return backTracking(str.substring(2)) + backTracking(str.substring(1));
        }else {
            return backTracking(str.substring(1));
        }
    }


}
