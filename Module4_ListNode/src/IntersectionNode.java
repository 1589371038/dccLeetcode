//160. 相交链表
//编写一个程序，找到两个单链表相交的起始节点。
//如下面的两个链表：
public class IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode tempA=headA;
        ListNode tempB=headB;
        while(tempA!=tempB){

                tempA=tempA.next;
            tempB=tempB.next;
            if(tempA==null&&tempB==null){
                return null;
            }
            if(tempA==null) {
                tempA=headB;
            }



            if(tempB==null) {
                tempB=headA;
            }

        }
        return tempA;


    }
}
