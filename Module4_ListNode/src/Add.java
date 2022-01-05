public class Add {
//    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
//如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/add-two-numbers
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
//    思路，从前到后相加，带进位，进位为全局变量。
    int carry=0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null){
            return null;
        }
if(l1==null){
    ListNode ln=new ListNode((l2.val+carry)%10);
    carry=(l2.val+carry)/10;
    ln.next=addTwoNumbers(null,l2.next);
    return ln;
}
        if(l2==null){
            ListNode ln=new ListNode((l1.val+carry)%10);
            carry=(l1.val+carry)/10;
            ln.next=addTwoNumbers(l1.next,null);
            return ln;
        }
       ListNode ln=new ListNode((l1.val+l2.val+carry)%10);
        carry=(l1.val+l2.val+carry)/10;
        ln.next=addTwoNumbers(l1.next,l2.next);
        return ln;

    }
}
