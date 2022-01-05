public class test {
    public static void main(String[] args) {
        ListNode head=new ListNode(5);
        head.next=new ListNode(4);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(1);
        head.next.next.next.next=new ListNode(2);
        ListNode head2=new ListNode(5);
        head2.next=new ListNode(4);
        head2.next.next=new ListNode(3);
        head2.next.next.next=new ListNode(1);
        head2.next.next.next.next=new ListNode(2);
        两数相加leetcode2 r = new 两数相加leetcode2();
        ListNode result = r.addTwoNumbers(head, head2);
        System.out.println("haha");

    }

}
