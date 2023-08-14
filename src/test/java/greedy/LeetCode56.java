package greedy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class LeetCode56 {
    @Test
    public void test(){

    }

    public int[][] merge(int[][] intervals) {
        // 按左边排序
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            // 重叠
            if (intervals[i][0] < intervals[i-1][1]){
                // 上一个 重叠的值
                int[] last = ans.get(ans.size()-1);
                // 更新右边的最大值
                intervals[i][1] = Math.max(last[1],intervals[i][1]);
                // 选 范围最大的 加进去
                ans.remove(ans.size()-1);
                ans.add(new int[]{last[0],intervals[i][1]});
            }else {
                ans.add(intervals[i]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
