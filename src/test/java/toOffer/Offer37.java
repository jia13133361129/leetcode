package toOffer;

import org.junit.Test;

import java.util.*;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 序列化二叉树
 * 先序遍历
 * Version:
 */
public class Offer37 {
    @Test
    public void test(){

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        preSerialize(root, ans);
        return ans.toString();
    }

    // 先序遍历，遍历到null
    // 用String存储（用 List<String> 存储的话，后续分解时，第一个元素会是“ [1 ”）
    public void preSerialize(TreeNode root, StringBuilder ans) {
        if (root == null){
            ans.append("None,");
            return;
        }else {
            ans.append(root.val);
            ans.append(",");
        }
        preSerialize(root.left,ans);
        preSerialize(root.right,ans);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        // asList()返回的列表是由原始数组支持的固定大小的列表。
        // 这种情况下，如果添加或删除列表中的元素，程序会抛出异常UnsupportedOperationException。
        List<String> dataList = new ArrayList<>(Arrays.asList(split));
        return preDeserialize(dataList);
    }

    // 按顺序放
    public TreeNode preDeserialize(List<String> data) {
        if (data.get(0).equals("None")){
            data.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data.get(0)));
        data.remove(0);
        root.left = preDeserialize(data);
        // left 那边放完之后，放到的值 正好是right这边
        root.right = preDeserialize(data);
        return root;
    }


}
