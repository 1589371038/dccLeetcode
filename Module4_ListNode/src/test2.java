/**
 * moon
 */

public class test2 {
    public static void main(String[] args) {
        ListNode head1=new ListNode(6);
        ListNode head2=new ListNode(2);
        ListNode head3=new ListNode(3);
        ListNode head4=new ListNode(8);
        ListNode head5=new ListNode(5);
        ListNode head6=new ListNode(6);
        head1.next = head2;
        head2.next = head3;
        head4.next = head5;
        head5.next = head6;
        链表中的两数相加 s = new 链表中的两数相加();
        ListNode res = s.addTwoNumbers(head1, head4);
        System.out.println("1");
    }
}
