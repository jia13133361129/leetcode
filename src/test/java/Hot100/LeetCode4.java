package Hot100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 寻找两个正序数组的中位数
 * Version:
 */
public class LeetCode4 {
    @Test
    public void test(){

    }


    // 只存储中位数的值
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = (len1+len2)/2;
        int res1 = 0;
        int res2 = 0;
        int i1=0,i2=0;
        for(int i=0;i<=len;i++){
            if(i1 >= len1 || (i2<len2 && nums1[i1] > nums2[i2])){
                if(i == len-1)
                    res1 = nums2[i2];
                if(i == len)
                    res2 = nums2[i2];
                i2++;
            }
            else{
                if(i == len-1)
                    res1 = nums1[i1];
                if(i == len)
                    res2 = nums1[i1];
                i1++;
            }
        }
        return (len1+len2)%2==0 ? (res1 + res2)/2.0 : res2;
    }


}
