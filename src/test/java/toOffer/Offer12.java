package toOffer;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 矩阵中的路径
 * 本题与主站 79 题相同
 * Version:
 */
public class Offer12 {
    @Test
    public void test(){
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        System.out.println(exist(board,word));
    }

    // 也可以不用visited
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i=0;i<board.length;i++)
            for (int j=0;j<board[0].length;j++){
                if (board[i][j] == word.charAt(0)){
                    System.out.println(i + "     " +j);
                    if (backTracking(board,word,visited, i,j,0)){
                        return true;
                    }
                }
            }
        return false;
    }

    public boolean backTracking(char[][] board, String word,boolean[][] visited, int x, int y, int i) {
        if (i == word.length()-1 && board[x][y] == word.charAt(i)){
            return true;
        }

        int[][] directions = {{0,-1},{0,1},{1,0},{-1,0}};

        if (board[x][y] == word.charAt(i)){
            visited[x][y] = true;
            for (int[] direction : directions) {
                int xNew = x + direction[0];
                int yNew = y + direction[1];
                if (xNew >= 0 && xNew < board.length && yNew >= 0 && yNew < board[0].length){
                    if (!visited[x][y] && backTracking(board,word,visited,xNew,yNew,i+1)){
                        return true;
                    }
                }
            }
            visited[x][y] = false;
        }
        return false;
    }




}
