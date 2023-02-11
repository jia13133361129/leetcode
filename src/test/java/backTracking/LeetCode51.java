package backTracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 寻找两个正序数组的中位数
 * Version:
 */
public class LeetCode51 {

    @Test
    public void main() {

    }

    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        boolean[][] flag = new boolean[n][n];
        backTracking(n,flag,0);
        return res;
    }

    public void backTracking(int n, boolean[][] flag, int row){
        if (row == n){
            res.add(new ArrayList<>(path));
            return;
        }
        // 复制flag, 还原不了
        boolean[][] flagCopy = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                flagCopy[i][j] = flag[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            // 已经被覆盖掉
            if (flag[row][i]){
                continue;
            }
            // 添加path
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == i){
                    sb.append('Q');
                }else {
                    sb.append('.');
                }
            }
            path.add(sb.toString());
            // 标记为 true
            // 行 不用标记，因为 一行一行 往下选的
            // 列 标记为 true
            for (int j = 0; j < n; j++) {
                flag[j][i] = true;
            }
            // 斜线：只 标记 该行下面的
            int x = row;
            int y = i;
            // 左斜线
            while (x < n && y >= 0){
                flag[x][y] = true;
                x++;
                y--;
            }
            // 右斜线
            x = row;
            y = i;
            while (x < n && y < n){
                flag[x][y] = true;
                x++;
                y++;
            }
            backTracking(n,flag,row+1);
            // 还原
            for (int i1 = 0; i1 < n; i1++) {
                for (int j = 0; j < n; j++) {
                    flag[i1][j] = flagCopy[i1][j];
                }
            }
            path.remove(path.size()-1);
        }
    }
}
