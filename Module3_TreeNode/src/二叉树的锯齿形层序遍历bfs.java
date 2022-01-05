import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * moon
 * 就是在bfs的基础上做一个从前往后还是从后往前的判断呗
 */

public class 二叉树的锯齿形层序遍历bfs {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse =false;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> deepResult=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                deepResult.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            if(!reverse){
                result.add(deepResult);
            }else {
                reverse(deepResult);
                result.add(deepResult);
            }

            reverse = !reverse;
        }
        return result;
    }

    private void reverse(List<Integer> deepResult) {
        int i = 0;
        int j = deepResult.size()-1;
        while (i<=j){
            Integer temp = deepResult.get(i);
            deepResult.set(i,deepResult.get(j));
            deepResult.set(j,temp);
            i++;
            j--;
        }
    }
}
