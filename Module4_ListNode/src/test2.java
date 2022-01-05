/**
 * moon
 */

public class test2 {
    public static void main(String[] args) {
        ListNode head=new ListNode(5);
        ListNode head2 = head;
        head.next=new ListNode(4);
        System.out.println(head2.next.val);
    }
}
