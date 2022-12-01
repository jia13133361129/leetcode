package Hot100;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 合并K个升序链表
 * Version:
 */
public class LeetCode23 {
    @Test
    public void test(){

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode();
        ListNode resCopy = res;
        while(true){
            int minValue = Integer.MAX_VALUE;
            int minValueIndex = -1;
            for(int i=0;i<lists.length;i++){
                ListNode node = lists[i];
                if (node == null) {
                    continue;
                }
                if(node.val < minValue){
                    minValue = node.val;
                    minValueIndex = i;
                }
            }
            if (minValueIndex == -1) {
                break;
            }
            resCopy.next = new ListNode(minValue);
            resCopy = resCopy.next;
            lists[minValueIndex] = lists[minValueIndex].next;
        }
        return res.next;
    }

  class ListNode {
      int val;
      ListNode next;

      ListNode() {
      }

      ListNode(int val) {
          this.val = val;
      }

      ListNode(int val, ListNode next) {
          this.val = val;
          this.next = next;
      }
  }

}
