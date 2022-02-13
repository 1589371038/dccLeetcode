/**
 * moon
 * 思路：归并排序+合并两个有序链表
 */

public class 排序链表 {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // slow.next是右半边的开端
        ListNode rightS = slow.next;
        slow.next = null; // 切断左右两边
        ListNode left = sortList(head);
        ListNode right = sortList(rightS);
        return  sortTwoSortedList(left, right);
    }

    private ListNode sortTwoSortedList(ListNode left, ListNode right) {
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        if(left.val<right.val){
            ListNode node = new ListNode(left.val);
            node.next = sortTwoSortedList(left.next, right);
            return node;
        }else {
            ListNode node = new ListNode(right.val);
            node.next = sortTwoSortedList(left, right.next);
            return node;
        }
    }
}
