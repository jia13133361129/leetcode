package weeklyCompetition;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 使数组相等的最小开销
 * 把 cost[i] 理解成 nums[i] 的出现次数。
 * 根据中位数贪心，把所有数变成中位数是最优的。
 * 详细证明参考 462. 最小操作次数使数组元素相等 II
 * Version:
 */
public class Ques2448 {
    @Test
    public void test(){
        int[] nums = {1,3,5,2};
        int[] cost = {2,3,1,14};
        System.out.println(minCost(nums,cost));
    }

    public long minCost(int[] nums, int[] cost) {
        // 排序 nums 和 cost
        for (int i = 0; i < nums.length; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length-1-i; j++) {
                if (nums[j] > nums[j+1]){
                    flag = false;
                    int numTemp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = numTemp;
                    int costTemp = cost[j];
                    cost[j] = cost[j+1];
                    cost[j+1] = costTemp;
                }
            }
            if (flag){
                break;
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(cost));

        long costSum = 0;
        for (int i = 0; i < nums.length; i++) {
            costSum += cost[i];
        }
        System.out.println(costSum);

        long index = 0;
        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            if (index <= costSum/2 && index + cost[i] >= costSum/2){
                target = nums[i];
                break;
            }
            index += cost[i];
        }
        System.out.println(target);

        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += (long) Math.abs(nums[i] - target) * cost[i];
        }
        return ans;
    }


}
