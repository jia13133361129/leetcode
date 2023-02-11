package greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class LeetCode860 {
    @Test
    public void test(){

    }

    public boolean lemonadeChange(int[] bills) {
        int fiveCount = 0;
        int tenCount = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveCount++;
                continue;
            }
            if (bills[i] == 10){
                if (fiveCount > 0){
                    fiveCount--;
                    tenCount++;
                }else {
                    return false;
                }
                continue;
            }
            if (bills[i] == 20){
                if (tenCount > 0 && fiveCount > 0){
                    tenCount--;
                    fiveCount--;
                }else if (fiveCount >= 3){
                    fiveCount = fiveCount - 3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
