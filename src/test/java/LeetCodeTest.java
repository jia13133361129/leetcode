import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.*;

/**
 * User: jia
 * Time: 2022/4/6  11:13
 * Description:
 * Version:
 */

public class LeetCodeTest {

    @Test
    public void test(){
        // new ArrayBlockingQueue<>()
        LocalDateTime time = LocalDateTime.now(ZoneOffset.UTC).minusHours(6);
        Long timeLong = TimeFormatTransUtils.localDateTime2timeStamp(time);
        System.out.println(timeLong);
    }

    public int squareFreeSubsets2(int[] nums) {
        Arrays.sort(nums);
        // 以 i 结尾 的 无平方因字数的数量
        int[] dp = new int[nums.length];
        if (isNoSquareFactorNum(nums[0])){
            dp[0] = 1;
        }else {
            dp[0] = 0;
        }
        for (int i=1;i<nums.length;i++){
            if (isNoSquareFactorNum(nums[i])){
                for (int j = 0;j < i;j++){
                }
            }else {
                dp[i] = 0;
            }
        }

        return dp[nums.length];
    }


    long count = 0;
    public int squareFreeSubsets(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (isNoSquareFactorNum(nums[i])){
                nums[i] = 0;
                count++;
            }
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        backTrace(nums,count,1L);
        return (int) (count-1);
    }

    public void backTrace(int[] nums,int startIndex,long product) {
        if (!isNoSquareFactorNum(product)){
            return;
        }
        count++;
        for (int i = startIndex;i < nums.length;i++){
            backTrace(nums,i+1,product * nums[i]);
        }
    }

    public boolean isNoSquareFactorNum(long product){
        for (int i = 2; (long) i * i <= product; i++){
            if (product % ((long) i * i) == 0){
                return false;
            }
        }
        return true;
    }

    public int minOperations(int n) {
        String s = Integer.toBinaryString(n);
        s = "0" + s;
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = chars.length-1; i > 0; i--) {
            if (chars[i] == '1' && chars[i-1] == '1'){
                for (int j = i;j >= 0;j--){
                    if (chars[j] == '1'){
                        chars[j] = '0';
                    }else {
                        chars[j] = '1';
                        break;
                    }
                }
                count++;
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1'){
                count++;
            }
        }
        return count;
    }


    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> list = new ArrayList<>();
        int id1 = 0;
        int id2 = 0;
        while (id1 < nums1.length && id2 < nums2.length){
            if (nums1[id1][0] < nums2[id2][0]){
                list.add(nums1[id1]);
                id1++;
            }else if (nums1[id1][0] > nums2[id2][0]){
                list.add(nums2[id2]);
                id2++;
            }else {
                list.add(new int[]{nums1[id1][0],nums1[id1][1] + nums2[id2][1]});
                id1++;
                id2++;
            }
        }
        for (int i = id1; i < nums1.length; i++) {
            list.add(nums1[i]);
        }
        for (int i = id2; i < nums2.length; i++) {
            list.add(nums2[i]);
        }
        return list.toArray(new int[list.size()][]);
    }






}
