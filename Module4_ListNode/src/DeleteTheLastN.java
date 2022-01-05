import java.util.HashMap;

public class DeleteTheLastN {
//    题目：删除倒数第N个节点
//    给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//    思路：我只会找正数第n个，所以先遍历一次找到总数m，然后找第m-n+1个，让第m-n个连接到第m-n+2个上
//    拓展：你能尝试使用一趟扫描实现吗？
//    思路：每遍历一层，index++，我把index和listNode记录在Hashtable上
//    然后找第m-n+1个对应的listnode！
    public ListNode removeNthFromEnd(ListNode head, int n) {
        HashMap<Integer,ListNode> hm=new HashMap<>();
        ListNode listNode=head;
        int index=0;
        while(listNode!=null){
           hm.put(index,listNode);
            listNode=listNode.next;
            index++;
        }
        if(index<n){
            return null;
        }
        //        左边不能越界
        if(index-n-1==-1){
            return head.next;
        }
         ListNode target=hm.get(index-n-1);
//        右边.next.next可能空指针
        if(n>1){
        target.next=target.next.next;}
        else
        {target.next=null;}
        return head;
    }
}
