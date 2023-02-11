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
public class LeetCode37 {

    @Test
    public void main() {
        char val = (char) ('0' + 2);
        char[][] boardCopy = new char[9][9];
        boardCopy[1][1] = val;
        System.out.println(Arrays.deepToString(boardCopy));
    }

    char[][] boardCopy = new char[9][9];
    public void solveSudoku(char[][] board) {
        backTracking(board,0,0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = boardCopy[i][j];
            }
        }
    }

    public void backTracking(char[][] board,int row, int col){
        // 终止条件
        if (row == 9 && col == 0){
            System.out.println("1111");
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    boardCopy[i][j] = board[i][j];
                }
            }
            return;
        }
        if (board[row][col] == '.'){
            for (int i = 1; i <= 9; i++) {
                char val = (char) ('0' + i);
                if (isValid(board,row,col,val)){
                    board[row][col] = val;
                    int rowCopy = row;
                    int colCopy = col;
                    // 遍历下一个位置
                    col++;
                    if (col == 9){
                        row++;
                        col = 0;
                    }
                    backTracking(board,row,col);
                    // board[row][col] = '.';
                    row = rowCopy;
                    col = colCopy;
                }
            }
        }else {
            // 遍历下一个位置
            col++;
            if (col == 9){
                row++;
                col = 0;
            }
            backTracking(board,row,col);
        }
    }
    public boolean isValid(char[][] board,int row,int col,char val){
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == val)
                return false;
            if (board[row][i] == val){
                return false;
            }
        }
        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == val)
                    return false;
            }
        }
        return true;
    }
}
