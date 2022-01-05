import java.util.Deque;
import java.util.LinkedList;

/**
 * moon
 * 116. 填充每个节点的下一个右侧节点指针
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 思路：就是bfs层序遍历，只不过增加了指针，注意队列每次只能取头节点
 */

public class 填充每一个节点的下一个右节点 {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()){
            Node firstNode = deque.poll();  //首节点先拿出来
            int size = deque.size(); //除了首节点之外的节点数，每个节点都被其前驱节点.next指向
            if(firstNode.left!=null){  //别忘了首节点的左右子节点加入队列
                deque.offer(firstNode.left);
            }
            if(firstNode.right!=null){
                deque.offer(firstNode.right);
            }
            for(int i=0;i<size;i++){
                Node thisNode = deque.poll();
                firstNode.next=thisNode;
                firstNode=thisNode;
                //
                if(thisNode.left!=null){  //别忘了节点的左右子节点加入队列
                    deque.offer(thisNode.left);
                }
                if(thisNode.right!=null){
                    deque.offer(thisNode.right);
                }
            }
        }
        return root;
    }

}
