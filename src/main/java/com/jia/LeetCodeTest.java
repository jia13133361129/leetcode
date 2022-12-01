package com.jia;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Time: 2022/3/7  10:43
 * Description:
 * Version:
 * @author jia
 */
public class LeetCodeTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new ArrayList<>();
        new Vector<>();
        new LinkedList<>();

        new HashSet<>();
        new LinkedHashSet<>();
        new TreeSet<>();

    }

    private static class A implements Serializable {

        private int x;
        private String y;

        A(int x, String y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "x = " + x + "  " + "y = " + y;
        }
    }

    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 &&  set.contains(-nums[i])){
                return -nums[i];
            }
            if (nums[i] >= 0){
                break;
            }
        }
        return -1;
    }

    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            set.add(reverse(nums[i]));
        }
        return set.size();
    }

    public static int reverse(int num){
        int res = 0;
        while (num != 0){
            res = res * 10 + num % 10;
            num = num / 10;
        }
        return res;

    }

    public boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i <= num/2; i++) {
            if (i+reverse(i) == num){
                return true;
            }
        }
        return false;
    }

    public long countSubarrays(int[] nums, int minK, int maxK) {
        int count = 0;
        int min = 0;
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i == j){
                   min = nums[i];
                   max = nums[i];
                }else {
                    min = Math.min(min,nums[j]);
                    max = Math.max(max,nums[j]);
                }
                if (min == minK && max == maxK){
                    count++;
                }else {
                    if (min < minK || max > maxK){
                        break;
                    }
                }
            }
        }
        return count;
    }

    public long countSubarrays2(int[] nums, int minK, int maxK) {
        int ans = 0;
        int start = 0;
        if (nums[0] < minK || nums[0] > maxK){
            start++;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK){
                if (nums[i-1] >= minK && nums[i-1] <= maxK){
                    ans += partition(nums,minK,maxK,start,i-1);
                    start = i+1;
                }else {
                    start++;
                }

            }else{
                if(i == nums.length-1){
                    ans += partition(nums,minK,maxK,start,i);
                }
            }

        }
        return ans;
    }

    public long partition(int[] nums, int minK, int maxK, int start, int end) {
        int count = 0;
        int min = 0;
        int max = Integer.MAX_VALUE;
        int len = end - start + 1;

        for (int i = start; i <= end; i++) {
            for (int j = i; j <= end; j++) {
                if (i == j){
                    min = nums[i];
                    max = nums[i];
                }else {
                    min = Math.min(min,nums[j]);
                    max = Math.max(max,nums[j]);
                }
                if (min == minK && max == maxK){
                    count++;
                }
            }
        }
        return count;
    }

    public long countSubarrays3(int[] nums, int minK, int maxK) {
        long ans = 0L;
        int n = nums.length, minI = -1, maxI = -1, i0 = -1;
        for (int i = 0; i < n; ++i) {
            int x = nums[i];
            if (x == minK) {
                minI = i;
            }
            if (x == maxK) {
                maxI = i;
            }
            if (x < minK || x > maxK) {
                i0 = i; // 子数组不能包含 nums[i0]
            }
            ans += Math.max(Math.min(minI, maxI) - i0, 0);
        }

        return ans;
    }

}
