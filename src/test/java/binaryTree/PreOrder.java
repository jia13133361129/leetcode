package binaryTree;

import Hot100.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: jia
 * Time: 2023/3/20  14:08
 * Description: 非递归
 * Version:
 */
public class PreOrder {

    public List<Integer> preorderTraversal(TreeNode root) {
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
        return res;
    }

}
