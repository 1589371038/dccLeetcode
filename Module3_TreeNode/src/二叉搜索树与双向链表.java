import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 *特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。
 * 还需要返回链表中的第一个节点的指针。
 *
 *
 * 思路1：中序遍历可以按顺序获取node，然后用list按顺序存储
 * 然后就可以重新指向了
 *
 * 思路2：在中序遍历的过程中指向，不用额外存储了
 */

public class 二叉搜索树与双向链表 {
    /**
     * 思路1：中序遍历可以按顺序获取node，然后用list按顺序存储
     *  * 然后就可以重新指向了
     * @param root
     * @return
     */
    public Node treeToDoublyList1(Node root) {
        if(root == null){
            return null;
        }
        List<Node> list = new ArrayList<>();
        dfs(root, list);
        for(int i = 0; i<list.size()-1; i++){
            Node node = list.get(i);
            Node next = list.get(i+1);
            node.right = next;
            next.left = node;
        }
        Node first = list.get(0);
        Node last = list.get(list.size()-1);
        first.left = last;
        last.right = first;
        return first;

    }

    private void dfs(Node root, List<Node> list) {
        if(root == null ){
            return;
        }
        dfs(root.left, list);
        list.add(root);
        dfs(root.right, list);
    }

    /**
     * 思路2：在中序遍历的过程中指向，不用额外存储了
     * @param root
     * @return
     */
    Node pre = null;
    Node head = null;
    public Node treeToDoublyList2(Node root) {
        if(root == null){
            return null;
    }
        dfs2(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

    private void dfs2(Node root) {
        if(root == null){
            return;
        }
        dfs2(root.left);
        root.left = pre;
        if(pre != null){ // 如果前驱节点！=null
            pre.right = root;
        }else { //  如果前驱节点==null 是第一个节点
            head = root;
        }
        pre = root;
        dfs2(root.right);
    }
}
