package dynamicProgramming.dajiajieshe;

/**
 * @Author: jia
 * Time: 2023/1/13  21:33
 * Description:
 * Version:
 */
public class que337 {
    public int rob(TreeNode root) {
        int[] res = robAction(root);
        return Math.max(res[0],res[1]);
    }

    public int[] robAction(TreeNode root){
        int[] res = new int[2];
        if (root == null)
            return res;
        int[] left = robAction(root.left);
        int[] right = robAction(root.right);
        res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        res[1] = left[0] + right[0] + root.val;
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
