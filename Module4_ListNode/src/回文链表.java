/**
 * 快慢指针！把前半段反转！！yeah
 */

public class 回文链表 {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        ListNode next = null;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        // pre是左半边开始 slow是右半边开始
        if(fast!= null){
            slow = slow.next;
        }
        while (slow!=null && pre!=null){
            if(slow.val != pre.val){
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }
}
