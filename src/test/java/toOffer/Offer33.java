package toOffer;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class Offer33 {
    @Test
    public void test(){

    }


    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0){
            return true;
        }
        return verifyPostorderCompletion(postorder,0,postorder.length-1);
    }

    public boolean verifyPostorderCompletion(int[] postorder,int start,int end) {
        if (start > end){
            return false;
        }
        if (start == end){
            return true;
        }

        int len = end - start + 1;
        int rootVal = postorder[end];
        int leftEndIndex = -1;
        for (int i = end -1; i >= start; i--){
            if (postorder[i] < rootVal){
                leftEndIndex = i;
                break;
            }
        }

        // 前面的是否都小
        boolean flag = false;
        if (leftEndIndex != -1){
            for (int i = start; i < leftEndIndex; i++) {
                if (postorder[i] >= postorder[end]){
                    flag = true;
                    break;
                }
            }
        }
        if (flag){
            return false;
        }


        if (leftEndIndex == -1 || leftEndIndex == end-1){
            return verifyPostorderCompletion(postorder,start,end-1);
        }
        return verifyPostorderCompletion(postorder,start,leftEndIndex) && verifyPostorderCompletion(postorder,leftEndIndex+1,end-1);
    }



}
