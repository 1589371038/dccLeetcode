/**
 * 归并，两个两个merge，
 * 用递归来归并
 */

public class 合并K个升序列表23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length-1);

    }

    private ListNode merge(ListNode[] lists, int L, int R) {
        if(L==R){
            return lists[L];
        }
        if(L>R){
            return null;
        }
        int mid = L+(R-L)/2;
        return mergeKTwoLists(merge(lists,L,mid),merge(lists,mid+1,R));

    }

    public ListNode mergeKTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val<=l2.val){
            ListNode node = new ListNode(l1.val);
            node.next=mergeKTwoLists(l1.next,l2);
            return node;
        }else {
            ListNode node = new ListNode(l2.val);
            node.next=mergeKTwoLists(l1,l2.next);
            return node;
        }

    }
}
