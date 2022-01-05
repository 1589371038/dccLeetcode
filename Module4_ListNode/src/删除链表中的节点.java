/**
 * 237. 删除链表中的节点
 * 请编写一个函数，用于 删除单链表中某个特定节点 。在设计函数时需要注意，你无法访问链表的头节点 head ，只能直接访问 要被删除的节点 。
 *
 * 题目数据保证需要删除的节点 不是末尾节点 。
 *
 * 思路：只给了被删除的节点，没给头节点，咋办
 *
 * 偷梁换柱，删除下一个节点，在此之前把下一个节点的值赋上
 */

public class 删除链表中的节点 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next=node.next.next;
    }
}
