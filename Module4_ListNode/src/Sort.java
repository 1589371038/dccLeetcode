

//148. 排序链表
//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
//示例 1:
//归并排序
public class Sort {
    public ListNode sortList(ListNode head) {
if(head==null||head.next==null){
    return head;
    }
ListNode slow=head;
ListNode fast=head.next;
while(fast!=null&&fast.next!=null){
    slow=slow.next;
    fast=fast.next.next;
}
//slow为中间节点，temp为右节点开端，head为左节点开端
ListNode temp=slow.next;
slow.next=null;
        ListNode left=sortList(head);
        ListNode right=sortList(temp);
        ListNode thisNode=new ListNode(0);
        ListNode recordHead=thisNode;
       while(left!=null&&right!=null){
           if(left.val<=right.val){
               thisNode.next=left;
               left=left.next;
           }
           else {
               thisNode.next=right;
               right=right.next;
           }
           thisNode=thisNode.next;
       }
       thisNode.next=left==null?right:left;
       return  recordHead.next;

    }
}
