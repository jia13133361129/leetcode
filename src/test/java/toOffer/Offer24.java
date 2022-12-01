package toOffer;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 剑指 Offer 24. 反转链表
 * Version:
 */
public class Offer24 {
    @Test
    public void test(){

    }



    // 头插法
    public ListNode reverseList2(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode ans = new ListNode(0);
        while(head != null){
            ListNode temp = head.next;
            head.next = ans.next;
            ans.next = head;
            head = temp;
        }

        return ans.next;
    }


    // 反转指针
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode pre = head;
        head = head.next;
        pre.next = null;
        while(head != null){
            ListNode temp = head;
            head = head.next;
            temp.next = pre;
            pre = temp;
        }
        return pre;
    }



    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;
        }
    }


}
