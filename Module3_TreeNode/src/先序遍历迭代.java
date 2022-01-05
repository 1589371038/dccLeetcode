import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * 递归很简单，所以我们用迭代来做
 */

public class 先序遍历迭代 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (node!=null||!stack.isEmpty()){
            while (node!=null){ //往栈里放left
                stack.push(node);
                result.add(node.val);
                node =node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return result;
    }
}
