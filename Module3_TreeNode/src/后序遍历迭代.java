import java.util.*;

/**
 * 思考：先序遍历和中序遍历用了同样的套路，栈推进node.left然后弹出来，取right
 *
 * 但是后序遍历不行，后序遍历取右节点之后才能取上节点
 *
 * 但是反过来想，左右中的顺序，倒过来是中右左，而中左右就是前序遍历，那可以实现中右左，然后reverse！
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/zhuan-ti-jiang-jie-er-cha-shu-qian-zhong-hou-xu-2/
 */

public class 后序遍历迭代 {
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> result = new LinkedList<>();
        TreeNode node = root;
        while (node!=null||!stack.isEmpty()){
            while (node!=null){
                result.add(node.val);
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            node = node.left;
        }
        Collections.reverse(result);
        return result;
    }
}
