package Hot100;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 任务调度器
 * Version:
 */
public class LeetCode621 {
    @Test
    public void test(){
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println(leastInterval(tasks,n));
    }

    // n+1 为一组
    // maxExec：最多的执行次数
    // maxCount：最多的执行次数的任务数量
    // 如果填入的个数没有超过n+1；结果为：(maxExec-1)*(n+1)+maxCount
    // 如果填入的个数超过了n+1；结果为：tasks.length
    // 填满了之后，前maxExec-1组往后面填就行了，一定是tasks.length（不会右空位）
    // 因此，结果为：Math.max((maxExec-1)*(n+1)+maxCount,tasks.length)
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> freq = new HashMap<>();
        // 最多的执行次数
        int maxExec = 0;
        for (char task : tasks) {
            int exec = freq.getOrDefault(task,0)+1;
            freq.put(task,exec);
            maxExec = Math.max(maxExec,exec);
        }

        // 具有最多执行次数的任务数量
        int maxCount = 0;
        for (Character key : freq.keySet()) {
            if(freq.get(key) == maxExec){
                maxCount++;
            }
        }

        return Math.max((maxExec-1)*(n+1)+maxCount, tasks.length);
    }


}
