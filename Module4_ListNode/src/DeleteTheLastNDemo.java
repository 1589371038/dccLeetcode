public class DeleteTheLastNDemo {
    public static void main(String[] args) {
        DeleteTheLastN dn=new DeleteTheLastN();
        ListNode ln1=new ListNode(1);
        ListNode ln2=new ListNode(2);
        ListNode ln3=new ListNode(3);
        ListNode ln4=new ListNode(4);
        ln1.next=ln2;
        ln2.next=ln3;
        ln3.next=ln4;
        ListNode result=dn.removeNthFromEnd(ln1,2);
        System.out.println("haha");
    }
}
