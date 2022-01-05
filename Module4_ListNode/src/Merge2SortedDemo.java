public class Merge2SortedDemo {
    public static void main(String[] args) {
        Merge2Sorted m2=new Merge2Sorted();
        ListNode ln1=new ListNode(1);
        ListNode ln2=new ListNode(2);
        ListNode ln3=new ListNode(4);
        ln1.next=ln2;
        ln2.next=ln3;
        ListNode ln11=new ListNode(1);
        ListNode ln22=new ListNode(3);
        ListNode ln33=new ListNode(4);
        ln11.next=ln22;
        ln22.next=ln33;

        ListNode result=m2.mergeTwoLists(ln1,ln11);
        System.out.println("哈哈");
    }
}
