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
public class LeetCode491 {

    @Test
    public void main() {

    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums,0);
        return res;
    }

    public void backTracking(int[] nums,int startIndex){
        if (path.size() >= 2){
            res.add(new ArrayList<>(path));
        }
        for (int i = startIndex; i < nums.length; i++){
            // 定义used数组，用于去重
            // 201 : -100 <= nums[i] <= 100
            boolean[] used = new boolean[201];
            if (used[nums[i] + 100]){
                continue;
            }
            if (path.size() == 0 || nums[i] >= path.get(path.size() - 1)){
                used[nums[i] + 100] = true;
                path.add(nums[i]);
                backTracking(nums,i+1);
                path.remove(path.size()-1);
            }

        }
    }
}
