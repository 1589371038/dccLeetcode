
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//102. 二叉树的层序遍历
public class 二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> listAll = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return listAll;
        }
//用队列
        LinkedList<TreeNode> queue = new LinkedList<>();
        int index = 0;
//每一层null开头
        queue.addLast(null);
        queue.addLast(root);
//除了null还有别的值的时候
        while (queue.size() != 1) {
            TreeNode node = queue.removeFirst();
            Iterator<TreeNode> it = null;
//如果是null需要遍历
            if (node == null) {
                it = queue.iterator();
                while (it.hasNext()) {
                    TreeNode tempt = it.next();
                    list.add(tempt.val);
                }
                listAll.add(new ArrayList<>(list));
                list.clear();
                queue.addLast(null);

            } else {
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
        }
        return listAll;


    }
}
