package binaryTree;

import Hot100.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jia
 * Time: 2023/3/20  15:09
 * Description: 递归
 * Version:
 */
public class LevelOrder {

    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        backTrace(root,0);
        return resList;
    }

    // DFS--递归方式
    public void backTrace(TreeNode node, Integer deep) {
        if (node == null) return;
        deep++;

        if (resList.size() < deep) {
            //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<Integer>();
            resList.add(item);
        }
        resList.get(deep - 1).add(node.val);

        backTrace(node.left, deep);
        backTrace(node.right, deep);
    }

}
