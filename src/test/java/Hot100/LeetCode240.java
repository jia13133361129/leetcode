package Hot100;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 搜索二维矩阵 II
 * Version:
 */
public class LeetCode240 {
    @Test
    public void test(){

    }

    // https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/solution/mian-shi-ti-04-er-wei-shu-zu-zhong-de-cha-zhao-zuo/
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length-1;
        int j = 0;
        while (i >= 0  && j < matrix[0].length){
            if (matrix[i][j] == target){
                return true;
            }
            if (matrix[i][j] > target){
                i--;
            }else {
                j++;
            }
        }
        return false;
    }

    // 一个竖排一个竖排找
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0){
            return false;
        }
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]==target){
                return true;
            }
            if(matrix[0][i]<target){
                for(int j=0;j<matrix.length;j++){
                    if(matrix[j][i] == target){
                        return true;
                    }else if(matrix[j][i] > target){
                        break;
                    }
                }
            }else{
                return false;
            }
        }
        return false;
    }


}
