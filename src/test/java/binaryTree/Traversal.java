package binaryTree;

import Hot100.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Traversal {

    // 前序：根左右
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null){
            return ans;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            ans.add(node.val);
            // 根左右访问，所以放入的时候先放右节点，再放左节点
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
        return ans;
    }

    // 后序：左右根，按根右左遍历（类似前序的根左右），然后翻转过来
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null){
            return ans;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            ans.add(node.val);
            // 根右左访问，所以放入的时候先放左节点，再放右节点
            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }
        }
        Collections.reverse(ans);
        return ans;
    }

    // 中序：左根右
    // 左节点入栈 -》 出栈（访问）  -》右节点入栈
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null){
            return ans;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            // 有左节点，则一直入栈
            TreeNode node = stack.peek();
            while (node.left != null){
                stack.push(node.left);
                node = node.left;
            }
            // 栈里的都是没有左节点的，或者左节点已经进过栈访问过的
            // 没有左节点，直接访问，直接出栈
            TreeNode pop = stack.pop();
            ans.add(pop.val);
            // 没有左节点，就能访问，访问并出栈后再看有没有右节点
            // 看该节点有没有右节点，没有的话就不需要入栈元素，则再出栈并访问一个，继续看有没有右节点
            while (!stack.isEmpty() && pop.right == null){
                pop = stack.pop();
                ans.add(pop.val);
            }
            if (pop.right != null){
                stack.push(pop.right);
            }
        }
        return ans;
    }

}
