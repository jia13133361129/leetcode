package Hot100;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 把二叉搜索树转换为累加树
 * 反序中序遍历：右根左
 * 从大到小遍历
 * Version:
 */
public class LeetCode538 {
    @Test
    public void test(){

    }

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }




}
