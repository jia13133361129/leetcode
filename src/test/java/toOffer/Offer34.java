package toOffer;

import org.junit.Test;

import java.util.*;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class Offer34 {
    @Test
    public void test(){

    }

    List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        traverse(root,target,new ArrayList<>());
        return ans;
    }

    public void traverse(TreeNode root, int target,List<Integer> list){
        list.add(root.val);
        if (root.left == null && root.right == null){
            if (root.val == target){
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        // 一个拷贝，降低时间复杂度，9% -》 100%
        List<Integer> listCopy = new ArrayList<>(list);

        if (root.left != null){
            traverse(root.left,target - root.val,list);
        }
        if (root.right != null){
            traverse(root.right,target - root.val,listCopy);
        }
    }
}
