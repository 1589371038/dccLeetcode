public class Merge2Sorted {
//    leetcode 21 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
if(l1==null){
    return l2;
}
        if(l2==null){
            return l1;
        }
if (l2.val<l1.val){
    ListNode temp=l2.next;
    l2.next=l1;
    mergeTwoLists(l2,temp);
    return l2;//这里注意，头就变成了l2
}
else{
    if(l1.next==null){
        l1.next=l2;
    }
    else if(l2.val>l1.next.val){   //用next一定要注意指针
    mergeTwoLists(l1.next,l2);}
    else{
        ListNode temp1=l1.next;
        ListNode temp2=l2.next;
        l1.next=l2;l2.next=temp1;
        mergeTwoLists(l2,temp2);
    }
    return l1;
}

    }
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists2(l2.next, l1);
            return l2;
        }
    }
}
