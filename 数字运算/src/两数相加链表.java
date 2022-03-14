/**
 * 思路：carry可以用全局变量
 * 递归计算当前位
 */

public class 两数相加链表 {
    int carry = 0;
    public ListNode addTwoNumbers(ListNode node1, ListNode node2){
        if(node1==null && node2==null){
            if(carry>0){
                return new ListNode(carry);
            }else return null;
        }
        if(node1==null){
            int sum = node2.val+carry;
            carry = sum/10;
            ListNode node = new ListNode(sum%10);
            node.next = addTwoNumbers(null, node2.next);
            return node;
        }
        if(node2==null){
            int sum = node1.val+carry;
            carry = sum/10;
            ListNode node = new ListNode(sum%10);
            node.next = addTwoNumbers(node1.next, null);
            return node;
        }
        // 剩下的情况是node1 node2都存在
        int sum = node1.val + node2.val + carry;
        carry = sum/10;
        ListNode node = new ListNode(sum%10);
        node.next = addTwoNumbers(node1.next, node2.next);
        return node;
    }
}
