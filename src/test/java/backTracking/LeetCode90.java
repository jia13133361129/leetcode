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
public class LeetCode90 {

    @Test
    public void main() {

    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTracking(nums,0);
        return res;
    }

    public void backTracking(int[] nums,int startIndex){
        if (startIndex == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i != startIndex && nums[i] == nums[i-1]) {
                continue;
            }
            path.add(nums[i]);
            backTracking(nums,i+1);
            path.remove(path.size()-1);
        }


    }
}
