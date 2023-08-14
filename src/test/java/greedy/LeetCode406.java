package greedy;

import org.junit.Test;

import java.util.*;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class LeetCode406 {
    @Test
    public void test(){

    }

    public int[][] reconstructQueue(int[][] people) {
        // 排序，第一维从小到大，第二维从大到小
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] != o2[0]){
                return o1[0] - o2[0];
            }else {
                return o2[1] - o1[1];
            }
        });
        // 复制people[1]
        int[] freq = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            freq[i] = people[i][1];
        }
        // 标记数组
        boolean[] flag = new boolean[people.length];

        int[][] ans = new int[people.length][2];
        int index = 0;
        while (index < people.length){
            for (int i = 0; i < freq.length; i++) {
                // 检测到freq[i] == 0，加入该项
                if (!flag[i] && freq[i] == 0){
                    flag[i] = true;
                    for (int j=0;j<i;j++){
                        freq[j]--;
                    }
                    ans[index][0] = people[i][0];
                    ans[index][1] = people[i][1];
                }
            }
            index++;
        }
        return ans;
    }


    public int[][] reconstructQueue2(int[][] people) {
        // 身高从大到小排（身高相同k小的站前面）
        Arrays.sort(people,(p1,p2) -> {
            if (p1[0] != p2[0]){
                return p2[0] - p1[0];
            }else {
                return p1[1] - p2[1];
            }
        });
        // 依次加入
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1],people[i]); // 指定下标处加入，并后移后面的
        }
        return list.toArray(new int[people.length][]);
    }
}
