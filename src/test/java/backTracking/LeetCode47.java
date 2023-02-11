package backTracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 寻找两个正序数组的中位数
 * Version:
 */
public class LeetCode47 {

    @Test
    public void main() {

    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        // 标记是否被选择
        boolean[] flag = new boolean[nums.length];
        backTracking(nums, flag, 0);
        return res;
    }

    public void backTracking(int[] nums, boolean[] flag, int count){
        if (count == nums.length){
            res.add(new ArrayList<>(path));
        }

        for (int i = 0; i < nums.length; i++) {
            if (flag[i]){
                continue;
            }
            path.add(nums[i]);
            flag[i] = true;
            count++;
            backTracking(nums,flag,count);
            count--;
            flag[i] = false;
            path.remove(path.size()-1);
            // 去重
            while (i < nums.length-1 && nums[i+1] == nums[i]){
                i++;
            }
        }
    }
}
