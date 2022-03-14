/**
 * moon
 */

public class Hello {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode result = deleteLastNNodes1(node, 0);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }


    }

    public static ListNode deleteLastNNodes(ListNode node, int n) {
        ListNode head = node;
        ListNode tail = head;
        for (int i = 0; i < n; i++) {
            try {
                tail = tail.next;
            } catch (NullPointerException e) {
                System.out.println("链表长度不足n");
            }
        }
        if(tail == null){
            return null;
        }
        while (tail.next != null) {
            node = node.next;
            tail = tail.next;
        }
        node.next = null;
        return head;
    }

    public static ListNode deleteLastNNodes1(ListNode node, int n) {
        ListNode head = node;
        ListNode tail = head;
        int m = n; // m记录tail先行的步数的减少
       for(; tail.next!=null; ){
           tail = tail.next;
           m--;
           if(m<0){
               node = node.next;
           }
       }
       if(m>=0){
           return null;
       }
       node.next =null;
       return head;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
