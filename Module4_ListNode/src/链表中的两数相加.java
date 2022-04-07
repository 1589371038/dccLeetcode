// 链表相加。但是头结点是高位
// 先反转再相加
public class 链表中的两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ln1 = reverse(l1);
        ListNode ln2 = reverse(l2);
        return reverse(add(ln1, ln2, 0));
    }

    private ListNode add(ListNode l1, ListNode l2, int carry) {
        if(l1 == null && l2 == null && carry == 0){
            return null;
        }else {
            int sum = (l1 == null? 0: l1.val) +  (l2 == null? 0: l2.val) +carry;
            ListNode node = new ListNode(sum%10);
            node.next = add(getNext(l1),getNext(l2), sum/10);
            return node;
        }
    }

    private ListNode getNext(ListNode l1) {
        if(l1 != null){
            return l1.next;
        }else return null;
    }

    private ListNode reverse(ListNode l2) {
        if(l2 == null){
            return null;
        }
        ListNode pre = null;
        ListNode now = l2;
        ListNode next = null;
        while (now != null){
            next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }
        return pre;
    }
}
