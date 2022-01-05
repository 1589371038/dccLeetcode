public class MergeKSorted {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){ //注意先排除特殊情况
            return null;
        }
        ListNode[] ln=mergeKListsSon(lists);
   while (ln.length>1){
       ln=mergeKListsSon(ln);
   }
   return ln[0];

    }

    private ListNode[] mergeKListsSon(ListNode[] lists) {
        ListNode[] newLists=new ListNode[lists.length/2+lists.length%2];
        int j=0;
        int i=0;
        for( i=0;i<lists.length-1;i+=2){ //成对的组合
            newLists[j]=merge2Sorted(lists[i],lists[i+1]);
            j++;
        }
        //如果有落单的，补上
        if(i==lists.length-1){
            newLists[j]=lists[i];
        }
        return newLists;
    }

    public ListNode merge2Sorted(ListNode a,ListNode b){
        if (a==null){
            return b;
        }
        if(b==null){
            return a;
        }
        if(a.val<b.val){
            a.next=merge2Sorted(a.next,b);
            return a;
        }
        else{
            b.next=merge2Sorted(a,b.next);
            return b;
        }
    }
}
