package com.jia;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Time: 2022/3/7  10:43
 * Description:
 * Version:
 * @author jia
 */
public class LeetCodeTest {

    public static void main(String[] args) throws InterruptedException {
        int capacity = 10;
        List<Object> list = new ArrayList<>();
        ReentrantLock lock = new ReentrantLock();
        Condition notEmpty = lock.newCondition();
        Condition notFull = lock.newCondition();
        new Thread(() -> {
            try {
                while (true){
                    lock.lock();
                    if (list.size() == capacity){
                        notFull.await();
                    }
                    list.add(new Object());
                    System.out.println("produce:" + list.size());
                    Thread.sleep(500);
                    notEmpty.signal();
                    lock.unlock();
                }
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                while (true){
                    lock.lock();
                    if (list.isEmpty()){
                        notEmpty.await();
                    }
                    list.remove(0);
                    System.out.println("consume:" + list.size());
                    Thread.sleep(500);
                    notFull.signal();
                    lock.unlock();
                }
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }).start();
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

