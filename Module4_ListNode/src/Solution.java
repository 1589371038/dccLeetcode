public class Solution {
    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(1);
        ListNode listNode3=new ListNode(2);
        ListNode listNode4=new ListNode(3);
        ListNode listNode5=new ListNode(3);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        deleteDuplicates(listNode1);
        while(listNode1!=null){
            System.out.println(listNode1.val);
            listNode1=listNode1.next;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr=head;
        while(curr!=null&&curr.next!=null){
            if(curr.next.val==curr.val){
                curr.next=curr.next.next;
                //curr=curr.next;
            }
            else{
                curr=curr.next;
            }
        }
        return head;
    }
}
