package greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class LeetCode452 {
    @Test
    public void test(){
        int a = -2147483645;
        int b = 2147483646;
        System.out.println(a-b < 0);
    }

    public int findMinArrowShots(int[][] points) {
        // 按左边排序
        /**
         注意：不能用a[0] - b[0],原因见test
         Arrays.sort(points, (a, b)-> a[0]-b[0]);
         public static int compare(int x, int y) {
              return (x < y) ? -1 : ((x == y) ? 0 : 1);
         }
         */
        Arrays.sort(points, (a, b)-> Integer.compare(a[0],b[0]));
        Arrays.sort(points, (a, b)-> (int) ((long)a[0] - (long)b[0]));
        // count : 无重叠的最大区间个数
        // 第一个加进去
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            // 与前一个发生重叠
            if (points[i][0] <= points[i-1][1]){
                System.out.println(points[i][0]);
                System.out.println(points[i-1][1]);
                // 删掉这两个中 右边大 的值，这样才能保证后面尽量不重叠
                points[i][1] = Math.min(points[i][1],points[i-1][1]);
                // count 不变，因为删了一个
            }else { // 不重叠
                count++;
            }
        }
        return count;
    }
}
