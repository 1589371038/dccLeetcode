/**
 * moon
 */

public class 两数相加leetcode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        int extra = 0;
        ListNode result = new ListNode(l1.val);
        ListNode finalResult = result;
        while (l1 != null || l2 != null || extra!=0 ){
            int sum = extra + (l1 != null?l1.val:0) + (l2!= null ? l2.val:0);
            if(sum/10!=0){
                extra = sum/10;
                result.val = sum % 10;
            }else{
                extra = 0;
                result.val = sum ;
            }
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
            if(l1 != null || l2 != null || extra!=0  ){
                result.next = new ListNode(0);
                result = result.next;
            }

        }
        result = null; //删除多余尾巴
        return finalResult;
    }
}
