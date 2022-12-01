package Hot100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 路径总和 III
 * Version:
 */
public class LeetCode437 {
    @Test
    public void test(){
        int n = 294967296;
        for (int i = 0; i < 6; i++) {
            n = n + 1000000000;

            System.out.println(n);
            // System.out.println(n>Integer.MAX_VALUE);
        }
        n = 1000000000;
        for (int i = 0; i < 6; i++) {
            n = n + 1000000000;
            System.out.println(n);
        }

    }


    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        rootSum(root,targetSum);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return count;
    }

    public int rootSum(TreeNode root,int targetSum){
        if(root == null){
            return 0;
        }

        // 超出integer范围
        if(targetSum-root.val > 0 && root.val >0 && targetSum < 0){
            return 0;
        }

        if(root.val == targetSum){
            count++;
        }
        rootSum(root.left,targetSum-root.val);
        rootSum(root.right,targetSum-root.val);
        return 0;
    }


    // //自己写的，效率很低
    // int count = 0;
    // public int pathSum(TreeNode root, int targetSum) {
    //     backTracking(root,new ArrayList<Integer>(),targetSum);
    //     return count;
    // }
    //
    // public void backTracking(TreeNode root,List<Integer> values,int targetSum){
    //     if(root == null){
    //         return;
    //     }
    //
    //     List<Integer> valuesCopy = new ArrayList<>();
    //     for(Integer value:values){
    //         valuesCopy.add(value);
    //     }
    //     int size = valuesCopy.size();
    //     for (int i = 0; i < size; i++) {
    //         // 避免超出integer范围
    //         if(valuesCopy.get(i)+root.val<0 && valuesCopy.get(i)>0 && root.val>0){
    //             continue;
    //         }
    //         valuesCopy.set(i,valuesCopy.get(i)+root.val);
    //     }
    //     valuesCopy.add(root.val);
    //
    //     for(Integer value:valuesCopy){
    //         if(value == targetSum){
    //             count++;
    //         }
    //     }
    //     backTracking(root.left,valuesCopy,targetSum);
    //     backTracking(root.right,valuesCopy,targetSum);
    // }




}
