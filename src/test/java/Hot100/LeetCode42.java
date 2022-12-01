package Hot100;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 接雨水
 * 对于下标 i，下雨后水能到达的最大高度等于下标 i 两边的最大高度的最小值，
 * 下标 i 处能接的雨水量等于下标 i 处的水能到达的最大高度减去 height[i]。
 * Version:
 */
public class LeetCode42 {
    @Test
    public void test(){

    }

    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        for (int i=1;i<height.length;i++){
            leftMax[i] = Math.max(leftMax[i-1],height[i-1]);
        }
        for (int i=height.length-2;i>=0;i--){
            rightMax[i] = Math.max(rightMax[i+1],height[i+1]);
        }

        int ans = 0;
        for(int i=0;i<height.length;i++){
            if (Math.min(leftMax[i],rightMax[i])-height[i] > 0){
                ans += Math.min(leftMax[i],rightMax[i])-height[i];
            }
        }
        return ans;
    }



}
