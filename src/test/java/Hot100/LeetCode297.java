package Hot100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 二叉树的序列化与反序列化
 * 先序遍历
 * 需要再看一下
 * Version:
 */
public class LeetCode297 {
    @Test
    public void test(){

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rSerialize(root,"");
    }

    public String rSerialize(TreeNode root, String str){
        if (root == null){
            str += "None,";
        }else {
            str += root.val + ",";
            str = rSerialize(root.left, str);
            str = rSerialize(root.right,str);
        }
        return str;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
        return rDeserialize(dataList);
    }

    public TreeNode rDeserialize(List<String> dataList) {
        if (dataList.get(0).equals("None")){
            dataList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
        dataList.remove(0);
        root.left = rDeserialize(dataList);
        root.right = rDeserialize(dataList);

        return root;
    }

}
