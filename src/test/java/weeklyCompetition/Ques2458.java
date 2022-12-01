package weeklyCompetition;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class Ques2458 {
    @Test
    public void test(){

    }

    // // 超出时间复杂度
    // public int[] treeQueries(TreeNode root, int[] queries) {
    //     int[] ans = new int[queries.length];
    //     boolean[] flag = new boolean[queries.length];
    //     choose(root,queries,root,ans,flag);
    //     return ans;
    // }
    //
    // public void choose(TreeNode root,int[] queries,TreeNode start,int[] ans,boolean[] flag){
    //     if (root == null){
    //         return;
    //     }
    //
    //     for (int i = 0; i < queries.length; i++) {
    //         if (flag[i]){
    //             continue;
    //         }
    //         int target = queries[i];
    //         if (root.left != null && root.left.val == target){
    //             flag[i] = true;
    //             TreeNode left = root.left;
    //             root.left = null;
    //             ans[i] = getTreeHigh(start);
    //             root.left = left;
    //         }
    //         if (root.right != null && root.right.val == target){
    //             flag[i] = true;
    //             TreeNode right = root.right;
    //             root.right = null;
    //             ans[i] = getTreeHigh(start);
    //             root.right = right;
    //         }
    //
    //     }
    //     choose(root.left,queries,start,ans,flag);
    //     choose(root.right,queries,start,ans,flag);
    // }
    //
    // // 求数的高度
    // public int getTreeHigh(TreeNode root){
    //     if (root == null){
    //         return 0;
    //     }
    //     return 1 + Math.max(getTreeHigh(root.left),getTreeHigh(root.right));
    // }


    /**
     * 前提条件：树中的所有值 互不相同
     * 把 移除每个子树后 的二叉树高度 都求出来
     * restH: 删除当前节点子树后剩余部分的树的高度
     * 从 根节点 到 当前节点右子树 最深节点 的长度 ： depth+height[node.right] 与 restH 取最大值
     * 从 根节点 到 当前节点左子树 最深节点 的长度： depth+height[node.left] 与 restH 取最大值
     * 当前节点 左子树 的 restH = Math.max(restH, depth + height.get(node.right)
     * 当前节点 右子树 的 restH = Math.max(restH, depth + height.get(node.left)
     */
    private Map<TreeNode, Integer> height = new HashMap<>(); // 每棵子树的高度
    private int[] res; // 每个节点的答案

    public int[] treeQueries(TreeNode root, int[] queries) {
        getHeight(root);
        height.put(null, 0); // 简化 dfs 的代码，这样不用写 getOrDefault (null节点的高度为0)
        res = new int[height.size()];
        dfs(root, -1, 0);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++)
            ans[i] = res[queries[i]];
        return ans;
    }

    private void dfs(TreeNode node, int depth, int restH) {
        if (node == null) return;
        ++depth;
        res[node.val] = restH;
        dfs(node.left, depth, Math.max(restH, depth + height.get(node.right)));
        dfs(node.right, depth, Math.max(restH, depth + height.get(node.left)));
    }


    // 求每颗子树的高度
    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        int h = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        height.put(node, h);
        return h;
    }



}
