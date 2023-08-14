package greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class LeetCode435 {
    @Test
    public void test(){
        int a = 2147483646;
        int b = -2147483645;
        System.out.println(a<b);
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        // 按左边排序
        Arrays.sort(intervals, (a, b)-> a[0]-b[0]);
        // count : 无重叠的最大区间个数
        // 第一个加进去
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            // 与前一个发生重叠
            if (intervals[i][0] > intervals[i-1][1]){
                // 删掉这两个中 右边大 的值，这样才能保证后面尽量不重叠
                intervals[i][1] = Math.min(intervals[i][1],intervals[i-1][1]);
                // count 不变，因为删了一个
            }else { // 不重叠
                count++;
            }
        }
        return intervals.length - count;
    }
}
