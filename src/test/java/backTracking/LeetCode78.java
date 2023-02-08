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
public class LeetCode78 {

    @Test
    public void main() {

    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTracking(nums,0);
        return res;
    }

    public void backTracking(int[] nums,int index){
        if (index == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        // 选nums[index]
        path.add(nums[index]);
        backTracking(nums,index + 1);
        path.remove(path.size()-1);
        // 不选nums[index]
        backTracking(nums,index + 1);
    }
}
