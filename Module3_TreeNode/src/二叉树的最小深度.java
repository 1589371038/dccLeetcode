import java.util.Deque;
import java.util.LinkedList;

/**
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 * 和最大深度差不多，可以dfs，也可以bfs
 * 这里bfs做一下吧
 */

public class 二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int depth = 1;
        while (!deque.isEmpty()){
            int size = deque.size();
            for(int i=0;i<size;i++){
                TreeNode node = deque.poll();
                if(node.left==null&&node.right==null){
                    return depth;
                }
                if(node.left!=null)
                deque.offer(node.left);
                if(node.right!=null)
                deque.offer(node.right);
            }
            depth++;
        }
        return depth;
    }
}
