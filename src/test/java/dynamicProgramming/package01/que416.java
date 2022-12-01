package dynamicProgramming.package01;

/**
 * @Author: jia
 * Time: 2022/11/28  20:50
 * Description: 分割等和子集
 * 背包的体积为sum / 2
 * 背包中每一个元素是不可重复放入。
 */
public class que416 {

    // 二维dp
    // dp[i][j]：使用0-i的nums元素，能否正好装满重量为j的背包
    // 总重量为sum/2，nums[i]为重量，价值为true or false
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0){
            return false;
        }
        boolean[][] dp = new boolean[nums.length][sum/2+1];
        // 初始化
        if (nums[0] <= sum/2)
            dp[0][nums[0]] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                dp[i][j] = dp[i-1][j] || (j > nums[i] && dp[i - 1][j - nums[i]]);
            }
        }
        return dp[nums.length-1][sum/2];
    }

    // 一维dp
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0){
            return false;
        }
        boolean[] dp = new boolean[sum/2+1];
        if (nums[0] <= sum/2)
            dp[nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = sum / 2; j >= 0; j--) {
                dp[j] = dp[j] || (j > nums[i] && dp[j - nums[i]]);
            }
        }
        return dp[sum/2];
    }
}
