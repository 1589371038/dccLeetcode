import java.util.Iterator;
import java.util.LinkedList;

//116. 填充每个节点的下一个右侧节点指针
//给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
//
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
//思想： 队列，广度有限，层序遍历
public class Next_116 {
    public Node connect(Node root) {
        if(root==null){
            return root;
        }
        LinkedList<Node> list=new LinkedList<>();
        list.addLast(null);
        list.addLast(root);
        while(list.size()!=1){
            Node node=list.removeFirst();
            if(node==null){  //遍历这一层
                Iterator<Node> it=list.iterator();
                Node temp=it.next();
                while(it.hasNext()){
                     Node nextTemp=it.next();
                       temp.next=nextTemp;
                       temp=nextTemp;


                }
                temp.next=null;
                list.addLast(null);
            }
            else {  //把下一层加入队列
                if(node.left!=null){
                list.addLast(node.left);}
                if(node.right!=null){
                list.addLast(node.right);}

            }
        }
        return root;

    }
}
