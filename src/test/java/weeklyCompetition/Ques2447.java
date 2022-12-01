package weeklyCompetition;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/10/24  16:40
 * Description: 最大公因数等于 K 的子数组数目
 * 动态规划
 * 设二维数组dp[n][n]，dp[i][j]是子数组nums[i..j]的最大公因数，
 * 状态转移方程为 dp[i][j]=gcd(dp[i][j-1],nums[j]) 最后统计dp中值k的个数即可
 * Version:
 */
public class Ques2447 {

    @Test
    public void test(){
        System.out.println(gcd(6,9));
    }


    public int subarrayGCD(int[] nums, int k) {
        int count = 0;
        int maxGcd = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % k != 0){
                    break;
                }
                if (j == i){
                    maxGcd = nums[i];
                }else {
                    maxGcd = gcd(maxGcd,nums[j]);
                }
                if (maxGcd == k){
                    count++;
                }
            }
        }
        return count;
    }


    // 求两个树的最大公因数
    // 取两个数中最小，循环递减，都满足整除则为最大公约数
    public int gcd(int a,int b) {
        int min = Math.min(a, b);
        int gcd = 1;
        for (int i = min; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
                break;
            }
        }
        return gcd;
    }


}
