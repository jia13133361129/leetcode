package toOffer;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class Offer16 {
    @Test
    public void test(){

    }

    public double myPow(double x, int n) {
        if (n >= 0){
            return myPow2(x,n);
        }else {
            return 1/myPow2(x,-n);
        }

    }

    public double myPow2(double x, int n) {
        if (n == 0){
            return 1;
        }
        if (n == 1){
            return x;
        }
        double temp = myPow2(x,n/2);
        if (n % 2 == 0) {
            return temp * temp;
        }else {
            return temp * temp * x;
        }
    }


}
