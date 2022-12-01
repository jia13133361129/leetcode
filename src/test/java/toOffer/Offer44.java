package toOffer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 数字序列中某一位的数字
 * Version:
 */
public class Offer44 {
    @Test
    public void test(){
        System.out.println(findNthDigit(1000000000));
    }

    // 数学方法：分位数，硬找这个数
    public int findNthDigit(int n) {
        if (n < 10){
            return n;
        }
        String nStr =  String.valueOf(n);
        int len = nStr.length();
        long[] count = new long[len+1]; // count[i]存储i位数的总个数
        count[1] = 10;
        for (int i = 2; i <= len; i++) {
            count[i] = (long) (Math.pow(10,i) - Math.pow(10,i-1));
        }
        System.out.println(Arrays.toString(count));
        int iStart = 0;
        for (int i = 1; i <= len; i++) {
            if (iStart <= n && iStart + i * count[i] >= n){
                System.out.println(iStart);
                int start = (int) Math.pow(10,i-1);
                System.out.println(start);
                int targetNum = start + (n-iStart) / i;
                System.out.println(targetNum);
                String targetNumStr = String.valueOf(targetNum);
                return targetNumStr.charAt( (n-iStart) % i) - '0';
            }else{
                iStart += i * count[i];
            }
        }
        return -1;
    }

}
