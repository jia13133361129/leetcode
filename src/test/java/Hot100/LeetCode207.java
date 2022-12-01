package Hot100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 课程表
 * 课程表2：210
 * 方法：拓扑排序
 * Version:
 */
public class LeetCode207 {
    @Test
    public void test(){

    }

    List<List<Integer>> edges; //存储边，list的长度为节点的长度，每个List<Integer>存储的是该节点的后继节点
    int[] indeg; // 入度

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        indeg = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<>()); // 初始化每个节点的后继节点集合
        }
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]); // 添加后继节点
            ++indeg[info[0]]; // 入度+1
        }

        // 队列存储
        Queue<Integer> queue = new LinkedList<>();
        // 将所有入度为0的节点入队
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        // 记录已经删除的节点数
        int visited = 0;
        // 遍历队列
        while (!queue.isEmpty()) {
            ++visited;
            int u = queue.poll();
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

        // 如果删除的节点数等于节点数，说明没有环
        return visited == numCourses;
    }


}
