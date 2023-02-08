package backTracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 寻找两个正序数组的中位数
 * Version:
 */
public class LeetCode39 {

    @Test
    public void main() {

    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTracking(candidates,target,0,0);
        return res;
    }

    public void backTracking(int[] candidates, int target, int startIndex, int sum){
        if (sum >= target){
            if (sum == target){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] <= target){
                path.add(candidates[i]);
                backTracking(candidates,target,i,sum + candidates[i]);
                path.remove(path.size()-1);
            }
        }
    }



}
