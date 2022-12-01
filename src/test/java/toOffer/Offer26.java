package toOffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class Offer26 {
    @Test
    public void test(){

    }

    // 递归
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return  isSubStructureCompletion(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    // // 层次遍历
    // public boolean isSubStructure(TreeNode A, TreeNode B) {
    //     if (A == null || B == null){
    //         return false;
    //     }
    //     // 层次遍历，一次添加一层
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.offer(A);
    //     while (!queue.isEmpty()){
    //         int size = queue.size();
    //         for (int i = 0; i < size; i++) {
    //             TreeNode node = queue.poll();
    //             if (node.val == B.val){
    //                 if (isSubStructureCompletion(node,B)){
    //                     return true;
    //                 }
    //             }
    //             if (node.left != null){
    //                 queue.offer(node.left);
    //             }
    //             if (node.right != null){
    //                 queue.offer(node.right);
    //             }
    //         }
    //     }
    //     return false;
    // }

    public boolean isSubStructureCompletion(TreeNode A, TreeNode B){
        if (B == null){
            return true;
        }
        if (A == null){
            return false;
        }
        if (A.val == B.val){
            return isSubStructureCompletion(A.left,B.left) && isSubStructureCompletion(A.right,B.right);
        }else {
            return false;
        }
    }

}
