import java.util.HashSet;

public class HasCircle {
    HashSet<ListNode> set=new HashSet<>();
    public boolean hasCycle(ListNode head) {
while(head!=null){
    if(set.contains(head)){
       return true;
    }
    set.add(head);
    head=head.next;

}
return false;
    }
}
