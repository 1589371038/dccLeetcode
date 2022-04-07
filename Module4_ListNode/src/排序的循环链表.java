/**
 * 剑指 Offer II 029. 排序的循环链表
 * 给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，使这个列表仍然是循环升序的。
 * 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
 * 如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
 * 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点
 * 输入：head = [3,4,1], insertVal = 2
 * 输出：[3,4,1,2]
 *
 * 思考：三种情况 1. a<= insertval < a.next
 *               2. a 大于 a.next 上升到达终点，此时无论 insertval>= a 还是 <=a.next都插入a.next
 *               3. 链表全程相等，循环回到head,随便插入
 */

public class 排序的循环链表 {
    public ListNode insert(ListNode head, int insertVal) {
        if(head == null){
            ListNode node = new ListNode(insertVal);
            node.next = node;
            return node;
        }
        ListNode find = head;
        while (find.next != null){
            if (insertVal >= find.val && insertVal <find.next.val){
                insert(insertVal, find);
                return head;
            }
            if (find.val > find.next.val){
                if (insertVal >= find.val || insertVal <= find.next.val){
                    insert(insertVal, find);
                    return head;
                }
            }
            find = find.next;
            if (find == head){ // 走了一圈还没找到答案说明所有元素相等
                insert(insertVal, find);
                return head;
            }
        }
        return null;
    }

    private void insert(int insertVal, ListNode find) {
        ListNode next = find.next;
        ListNode node = new ListNode(insertVal);
        find.next = node;
        node.next = next;
    }
}
