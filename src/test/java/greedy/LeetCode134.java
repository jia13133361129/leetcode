package greedy;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class LeetCode134 {
    @Test
    public void test(){

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            diff[i] = gas[i] - cost[i];
        }
        if(diff.length == 1 && diff[0] >= 0){
            return 0;
        }
        for (int i = 0; i < diff.length; i++) {
            if (diff[i] > 0){
                // 从i开始尝试
                int sum = diff[i];
                int j = i+1;
                if (j == diff.length){
                    j = 0;
                }
                while (sum >= 0 && j != i){
                    sum += diff[j];
                    // 往后移，到队尾则从队首开始
                    j++;
                    if (j == diff.length){
                        j = 0;
                    }
                }
                // 一圈够了，返回i
                if (j == i && sum >= 0){
                    return i;
                }else if(j > i){
                    i = j-1;
                }else{
                    break;
                }
            }
        }
        return -1;
    }
}
