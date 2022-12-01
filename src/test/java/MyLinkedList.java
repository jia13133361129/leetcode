/**
 * User: jia
 * Time: 2022/4/15  10:59
 * Description:
 * Version:
 */
class MyLinkedList {

    ListNode head;
    int size;

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        ListNode head2 = head;
        if(index < 0 || index >= size || size ==0)
            return -1;

        if (index == 0){
            return head.val;
        }

        while(true){
            index--;
            if(index == 0)
                return head2.val;
            head2 = head2.next;
        }
    }

    public void addAtHead(int val) {
        if(size == 0){
            ListNode node = new ListNode(val);
            head = node;
        }
        else{
            ListNode node = new ListNode(val,head);
            head = node;
        }
        size++;
    }

    public void addAtTail(int val) {
        ListNode head2 = head;
        if(size == 0){
            ListNode node = new ListNode(val);
            head = node;
        }
        else{
            while(head2.next != null){
                head2 = head2.next;
            }
            ListNode node = new ListNode(val);
            head2.next = node;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        ListNode head2 = head;
        if(index == size){
            addAtTail(val);
            return;
        }
        if(index<0){
            addAtHead(val);
            return;
        }
        if (index == 0){
            ListNode node = new ListNode(val,head);
            head = node;
            size++;
            return;
        }

        if(index<size){
            while(true){
                index--;
                if(index == 0)
                    break;
                head2 = head2.next;
            }
            ListNode node = new ListNode(val,head2.next);
            head2.next = node;
            size++;
        }
        return;
    }

    public void deleteAtIndex(int index) {
        ListNode head2 = head;
        if(index < 0 || index >= size || size ==0)
            return;
        if(size==1 && index ==0){
            head = new ListNode(0);
            return;
        }

        if (index == 0){
            head = head.next;
            size--;
            return;
        }

        while(true){
            index--;
            if(index == 0)
                break;
            head2 = head2.next;
        }
        head2.next = head2.next.next;
        size--;
    }


    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.get(1);            //返回3
    }

}



