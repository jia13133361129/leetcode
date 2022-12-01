package toOffer;

import org.junit.Test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 丑数
 * 丑数：只包含质因子 2、3 和 5 的数
 * 例如：6、8都是丑数，但7、14不是，因为它们包含质因子7。
 * 习惯上我们把1当做是第一个丑数。
 * Version:
 */
public class Offer49 {
    @Test
    public void test(){
        System.out.println(nthUglyNumber(10));
    }

    // 动态规划（最优解法）
    // x 是 丑数，那么 2x、3x、5x 也是丑数（指针p 改变的就是 x）
    // 丑数 一定是 丑数 * 2、3、5 的结果
    public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        // p2, p3, p5表示下一个丑数是当前指针指向的丑数乘以对应的质因数。
        // 初始时，三个指针的值都是 111。
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2,num3),num5);
            if (dp[i] == num2){
                p2++;
            }
            if (dp[i] == num3){
                p3++;
            }
            if (dp[i] == num5){
                p5++;
            }
         }
        return dp[n];
    }

    // 最小堆实现
    // set 用来避免重复
    // 不重复的才添加到最小堆里
    // 添加的元素过多，导致超出int范围
    public int nthUglyNumber2(int n) {
        int[] factors = {2, 3, 5};
        PriorityQueue<Long> heap = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        heap.offer(1L);
        set.add(1L);
        long ugly = 0;
        for (int i = 0; i < n; i++) {
            ugly = heap.poll();
            for (int factor : factors) {
                long next = ugly * factor;
                if (set.add(next)){
                    heap.offer(next);
                }
            }
        }
        return (int)ugly;
    }



    // 暴力破解，超时
    public int nthUglyNumber3(int n) {
        int start = 1;
        while (n != 0){
            if (isUglyNumber(start)){
                n--;
            }
            start++;
        }
        return --start;
    }

    // 判断一个树 是否 为丑数
    // 首先除2，直到不能整除为止，
    // 然后除5到不能整除为止，
    // 然后除3直到不能整除为止。
    // 最终判断剩余的数字是否为1，如果是1则为丑数，否则不是丑数。
    public boolean isUglyNumber(int num){
        if (num <= 0){
            return false;
        }
        while (num % 2 == 0){
            num = num / 2;
        }
        while (num % 3 == 0){
            num = num / 3;
        }
        while (num % 5 == 0){
            num = num / 5;
        }
        return num == 1;
    }

}
