/**
 * 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 * //快慢指针法
 */

public class 判断有环 {
    public boolean hasCycle(ListNode head) {//快指针
        ListNode head2=head ;//慢指针
        while (!(head==null&&head2==null)){
            if(head!=null){
                if(head.next==null){
                    head=null;
                }else {
                    head = head.next.next;
                }
            }
            if(head2!=null){
                head2=head2.next;
            }
            if(head==head2&&head!=null){//如果追上了，有环
                return true;
            }
        }
        return false;

    }
}
