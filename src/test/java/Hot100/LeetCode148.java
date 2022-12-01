package Hot100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: jia
 * Time: 2022/4/6  11:13
 * Description: 排序链表，未用归并排序（答案方法），下次刷的时候尝试一下归并排序
 * Version:
 */

public class LeetCode148 {

    @Test
    public void test(){
        List<Integer> list = new ArrayList<Integer>();
        Integer[] values = list.toArray(new Integer[list.size()]);

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }

        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        Integer[] values = list.toArray(new Integer[list.size()]);

        Arrays.sort(values);
        ListNode head1 = new ListNode(0,new ListNode());
        ListNode head2 = head1.next;
        for(int i=0;i<values.length;i++){
            head2.val = values[i];
            if(i != values.length -1){
                head2.next = new ListNode();
                head2 = head2.next;
            }
        }

        return head1.next;
    }

}
