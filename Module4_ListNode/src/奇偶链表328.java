/**
 * 328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * wow不就是奇数指向next.next 偶数指向next,next
 * 然后奇数的尾部指向偶数的头部嘛
 * 注意保存头部节点
 * and防止过程中丢失节点信息
 */

public class 奇偶链表328 {
    public ListNode oddEvenList(ListNode head) {
        //至少有三个节点才能循环
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        //1为奇数 2为偶数
        ListNode head1 = head;
        ListNode head2 = head.next;
        ListNode node1 = head;
        ListNode node2 = head.next;
        while (node2 != null && node2.next != null) {
            node1.next = node2.next;
            node1 = node1.next;
            node2.next = node1.next;
            node2 = node2.next;
        }
        node1.next = head2;
        return head1;
    }
}
