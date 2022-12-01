package toOffer;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class Offer7 {
    @Test
    public void test(){

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0){
            return null;
        }
        return buildTreeCompletion(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    public TreeNode buildTreeCompletion(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        TreeNode root = new TreeNode(preorder[preStart]);

        if (preStart == preEnd){
            return root;
        }

        int inOrderRootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (root.val == inorder[i]) {
                inOrderRootIndex = i;
                break;
            }
        }
        int leftNum = inOrderRootIndex - inStart;
        int rightNum = inEnd - inOrderRootIndex;
        if (leftNum == 0){
            root.left = null;
        }else {
            root.left = buildTreeCompletion(preorder,inorder,preStart+1,
                    preStart+leftNum,inStart,inOrderRootIndex-1);
        }
       if (rightNum == 0){
           root.right = null;
       }else {
           root.right = buildTreeCompletion(preorder,inorder,preStart+leftNum+1,preEnd,
                   inOrderRootIndex+1,inEnd);
       }
       return root;
    }






}
