package weeklyCompetition;

import org.junit.Test;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class Ques {
    @Test
    public void test(){

    }

    // 第三题
    @Test
    public void test2(){
        System.out.println(makeIntegerBeautiful(590,1));
    }

    public long makeIntegerBeautiful(long n, int target) {
        String nStr = String.valueOf(n);
        StringBuilder sb = new StringBuilder(nStr);
        if (isBeautiful(sb,target)){
            return 0;
        }
        for (int i = sb.length()-1; i > 0; i--) {
            sb.setCharAt(i,'0');
            if (sb.charAt(i-1) == '9'){
                sb.setCharAt(i-1,'0');
                int t = i-2;
                while (t >= 0){
                    if (sb.charAt(t) == '9'){
                        sb.setCharAt(t,'0');
                        t--;
                    }else{
                        sb.setCharAt(t, (char) (sb.charAt(t) +1));
                        break;
                    }
                }
                if (t == -1){
                    break;
                }
            }else{
                sb.setCharAt(i-1, (char) (sb.charAt(i-1) +1));
            }
            if (isBeautiful(sb, target)) {
                System.out.println(sb);
                return Long.parseLong(sb.toString()) - n;
            }
        }
        sb.setCharAt(0,'0');
        StringBuilder newSb = new StringBuilder();
        newSb.append('1');
        newSb.append(sb);
        if (isBeautiful(newSb, target)) {
            return Long.parseLong(newSb.toString()) - n;
        }
        return -1;
    }

    public boolean isBeautiful(StringBuilder sb, int target){
        int sum = 0;
        for (int i = 0; i < sb.length(); i++) {
            sum += sb.charAt(i) - '0';
        }
        return sum <= target;
    }


    // 第四题
    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] ans = new int[queries.length];
        boolean[] flag = new boolean[queries.length];
        choose(root,queries,root,ans,flag);
        return ans;
    }

    public void choose(TreeNode root,int[] queries,TreeNode start,int[] ans,boolean[] flag){
        if (root == null){
            return;
        }

        for (int i = 0; i < queries.length; i++) {
            if (flag[i]){
                continue;
            }
            int target = queries[i];
            if (root.left != null && root.left.val == target){
                flag[i] = true;
                TreeNode left = root.left;
                root.left = null;
                ans[i] = getTreeHigh(start);
                root.left = left;
            }
            if (root.right != null && root.right.val == target){
                flag[i] = true;
                TreeNode right = root.right;
                root.right = null;
                ans[i] = getTreeHigh(start);
                root.right = right;
            }

        }
        choose(root.left,queries,start,ans,flag);
        choose(root.right,queries,start,ans,flag);
    }

    // 求数的高度
    public int getTreeHigh(TreeNode root){
        if (root == null){
            return -1;
        }
        return 1 + Math.max(getTreeHigh(root.left),getTreeHigh(root.right));
    }

}
