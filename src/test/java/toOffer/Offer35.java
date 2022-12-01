package toOffer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 复杂链表的复制
 * 哈希表！
 * 用哈希表记录每一个节点对应新节点的创建情况
 * 旧节点：新节点
 * 我们利用回溯的方式，让每个节点的拷贝操作相互独立。
 * 对于当前节点，我们首先要进行拷贝，然后我们进行「当前节点的后继节点」和「当前节点的随机指针指向的节点」拷贝，
 * 拷贝完成后将创建的新节点的指针返回，即可完成当前节点的两指针的赋值。
 * Version:
 */
public class Offer35 {
    @Test
    public void test(){

    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // 回溯法
    Map<Node,Node> cacheNode = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        if (!cacheNode.containsKey(head)){
            Node headNew = new Node(head.val);
            cacheNode.put(head,headNew); // 不能放到后面
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cacheNode.get(head);
    }

    // 方法二：迭代 + 节点拆分
    // 未写

}
