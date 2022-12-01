package weeklyCompetition;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 按奇偶性分类贪心
 * Version:
 */
public class Ques2449 {
    @Test
    public void test(){
        // Integer[] nums = {8,12,6};
        // Integer[] target = {2,14,10};
        // System.out.println(makeSimilarImplement(nums,target));

        int[] nums = {1,2,5};
        int[] target = {4,1,3};
        System.out.println(makeSimilar(nums,target));
    }

    // 方法1：不分奇偶，直接遍历（最优）
    public long makeSimilar2(int[] nums, int[] target) {
        Arrays.sort(nums);
        Arrays.sort(target);
        long ans = 0L;
        int oddIndex = 0;
        int evenIndex = 0;
        for (int i = 0; i < nums.length; i++)  {
            if (nums[i] % 2 == 0){
                while (target[evenIndex] % 2 != 0){  // 找 target 中奇偶性相同的元素
                    evenIndex++;
                }
                ans += Math.abs(nums[i] - target[evenIndex++]);
            }else {
                while (target[oddIndex] % 2 == 0){   // 找 target 中奇偶性相同的元素
                    oddIndex++;
                }
                ans += Math.abs(nums[i] - target[oddIndex++]);
            }
        }
        return ans / 4;
    }


    // 方法2：分奇偶，直接计算
    public long makeSimilar(int[] nums, int[] target) {
        // 分奇偶，分别计算
        List<Integer> oddNum = new ArrayList<>();
        List<Integer> evenNum = new ArrayList<>();
        List<Integer> oddTarget = new ArrayList<>();
        List<Integer> evenTarget = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0){
                evenNum.add(nums[i]);
            }else {
                oddNum.add(nums[i]);
            }
            if (target[i] % 2 == 0){
                evenTarget.add(target[i]);
            }else {
                oddTarget.add(target[i]);
            }
        }

        return (makeSimilarImplement(oddNum.toArray(new Integer[oddNum.size()]),
                oddTarget.toArray(new Integer[oddTarget.size()]))  +
                makeSimilarImplement(evenNum.toArray(new Integer[evenNum.size()]),
                        evenTarget.toArray(new Integer[evenTarget.size()]))) / 4;
    }

    public long makeSimilarImplement(Integer[] nums,Integer[] target){
        if (nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        Arrays.sort(target);
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += Math.abs(nums[i] - target[i]);
        }
        return ans;
    }

}
