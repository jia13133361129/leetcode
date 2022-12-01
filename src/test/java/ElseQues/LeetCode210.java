package ElseQues;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:课程表2
 * 课程表1：207
 * Version:
 */
public class LeetCode210 {
    @Test
    public void test(){

    }

    List<List<Integer>> edges;
    int[] indeg;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        indeg = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<>());
        }
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        int[] ans = new int[numCourses];
        while (!queue.isEmpty()) {
            int u = queue.poll();
            ans[visited++] = u;
            // 遍历该节点的后继节点
            for (int v: edges.get(u)) {
                // 入度-1
                --indeg[v];
                // 如果后继节点的入度为0，入队
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        if(visited == numCourses){
            return ans;
        }else{
            return new int[0];
        }

    }


}
