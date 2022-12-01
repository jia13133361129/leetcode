package toOffer;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class Offer36 {
    @Test
    public void test(){

    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };


    // 构成的 双向循环链表，不带head
    // 此时，返回的head 为首个元素
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        head = new Node();
        dfs(root);
        // 此时pre为最后一个元素,head为第一个元素
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(Node cur) {
        if(cur == null) {
            return;
        }

        dfs(cur.left);

        // 遇到首个node时，把该值赋值为head
        if (pre == null){
            head = cur;
        }else {
            // 赋值该节点前面的两条线
            cur.left = pre;
            pre.right = cur;
        }

        pre = cur;
        dfs(cur.right);
    }





}
