package toOffer;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/9/15  18:39
 * Description: 顺时针打印矩阵
 * Version:
 */
public class Offer29 {

    @Test
    public void test(){

    }


    public int[] spiralOrder(int[][] matrix) {

        if(matrix.length == 0){
            return new int[0];
        }
        boolean[][] flag = new boolean[matrix.length][matrix[0].length];
        int[][] dire = {{0,1},{1,0},{0,-1},{-1,0}};
        int[] res = new int[matrix.length * matrix[0].length];
        int x=0;
        int y=0;
        int direLoc = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = matrix[x][y];
            flag[x][y] = true;
            int xNew = x + dire[direLoc][0];
            int yNew = y + dire[direLoc][1];
            if (xNew <0 || xNew==matrix.length || yNew<0 || yNew==matrix[0].length || flag[xNew][yNew]){
                direLoc++;
                if(direLoc == 4){
                    direLoc=0;
                }
            }
            x = x + dire[direLoc][0];
            y = y + dire[direLoc][1];
        }
        return  res;
    }

}
