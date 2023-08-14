package binaryTree;

import Hot100.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @Author: jia
 * Time: 2023/3/20  14:23
 * Description: 非递归
 * Version:
 */
public class PostOrder {
    // 后序：左右根，按根右左遍历（类似前序的根左右），然后翻转过来
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (!stack.isEmpty() || root != null){
            while (root != null){
                res.add(root.val);
                stack.push(root);
                root = root.right;
            }

            root = stack.pop();
            root = root.left;
        }
        Collections.reverse(res);
        return res;
    }
}
