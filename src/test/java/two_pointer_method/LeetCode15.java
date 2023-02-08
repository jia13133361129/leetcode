package two_pointer_method;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if(nums[i] > 0){
                break;
            }
            // 去重
            if (i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            // 从 i+1 位置开始，寻找两数之和为 -nums[i]
            int left = i + 1;
            int right = nums.length -1;
            while (left < right){
                // 判断值，移动
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    // 去重
                    while (left < right && nums[left] == nums[left-1]){
                        left++;
                    }
                    right--;
                    while (left < right && nums[right] == nums[right + 1]){
                        right--;
                    }
                }else if (sum < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return ans;
    }
}
