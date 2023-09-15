package com.jia;


import java.io.*;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class LeetCodeTest{

    public static void main(String[] args) throws InterruptedException {
        String str = "abc";
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        System.out.println(sb);
        AbstractQueuedSynchronizer aqs;
        ReentrantLock lock;


        List<int[]> ans = new ArrayList<>();
    }



    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int max = Math.max(s1.length,s2.length);
        for (int i = 0; i < max; i++) {
            int num1 = i >= s1.length ? 0 : Integer.parseInt(s1[i]);
            int num2 = i >= s2.length ? 0 : Integer.parseInt(s2[i]);
            if (num1 < num2){
                return -1;
            }else if (num1 > num2){
                return 1;
            }
        }
        return 0;
    }

    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length-1;
        while (left < right){
            int h = Math.min(height[left],height[right]);
            max = Math.max(h * (right - left), max);
            if (height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return max;
    }





    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 从后面插入
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while (k >= 0){
            if(j == -1){
                break;
            }
            if(i == -1){
                nums1[k] = nums2[j];
                j--;
                k--;
                continue;
            }
            if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[j] + 1,dp[i]);
                }
            }
        }
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] > ans){
                ans = Math.max(ans,dp[i]);
            }
        }
        return ans;
    }
    public int findMin(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        if (nums[0] < nums[nums.length-1]){
            return nums[0];
        }
        int l = 0;
        int r = nums.length - 1;
        int mid = l + (r - l)/2;
        while (l <= r){
            if (mid-1 >= 0 && nums[mid-1] > nums[mid]){
                return nums[mid];
            }
            if (nums[mid] >= nums[0]){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
            mid = l + (r - l)/2;
        }
        return -1;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode head1 = new ListNode(0,head);
        ListNode head2 = new ListNode(0);
        ListNode slow = head1;
        ListNode fast = head1;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        head2.next = slow.next;
        // 翻转链表2
        ListNode node = head2.next;
        ListNode tail = null;
        while (node != null){
            ListNode temp = node.next;
            head2.next = node;
            node.next = tail;
            tail = node;
            node = temp;
        }
        while (head1 != null && head2!= null){
            if (head1.val != head2.val){
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }
    public class ListNode {
      int val;
     ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        int start = -1;
        int end = -1;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (j == i){
                    dp[i][j] = true;
                }else if (j == i + 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
                if (dp[i][j] && j - i + 1 > max){
                    max = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start,end+1);
    }

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int mid = l + (r - l)/2;
        if (nums.length == 1){
            return target==nums[0] ? 0 : -1;
        }
        while (l <= r){
            if (nums[mid] == target){
                return mid;
            }
            // 先判断target在左半段还是右半段
            // 左半段
            if (target >= nums[0]){
                if (nums[mid] >= nums[0]){
                    if (nums[mid] > target){
                        r = mid - 1;
                    }else {
                        l = mid + 1;
                    }
                }else {
                    r = mid - 1;
                }
            }else {
                if (nums[mid] < nums[0]){
                    if (nums[mid] > target){
                        r = mid - 1;
                    }else {
                        l = mid + 1;
                    }
                }else {
                    l = mid + 1;
                }
            }
            mid = l + (r - l)/2;
        }
        return -1;
    }


    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        Map<Character,Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= start){
                start = map.get(s.charAt(i)) + 1;
            }
            map.put(s.charAt(i),i);
            max = Math.max(i - start + 1, max);
        }
        return max;
    }


    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                ans[0] = i;
                ans[1] = map.get(target-nums[i]);
                return ans;
            }
            map.put(nums[i],i);
        }
        return null;
    }


    public void preOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            while (root != null){
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

