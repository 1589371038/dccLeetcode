import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 用迭代的方法来中序遍历，这样取到第k个节点后直接return，比递归更有效率
 * 迭代用栈，思想是倒豆子，把left不停地放进栈，直到null，
 * 从栈中取出一个node(倒豆子) 就是第一个输出，然后把node变成node.right,继续这个流程
 */

public class 二叉搜索树中第K小的元素2 {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (!stack.isEmpty()||node!=null){
            //装豆子
            while (node!=null){
                stack.push(node);
                node=node.left;
            }
            //倒豆子
            TreeNode popNode = stack.pop();
            k--;
            if(k==0){ //第k个数字
                return popNode.val;
            }
            //倒出来的豆子还有右边的分支
            node = popNode.right;
        }
        return 0;
    }
}
