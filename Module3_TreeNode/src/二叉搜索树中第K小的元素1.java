import java.util.ArrayList;
import java.util.List;

/**
 * 230
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 * 根据二叉搜索树的性质，中序遍历就是从小到大了，
 * 用递归的方法，需要遍历每一个节点
 * 方法1：递归，把节点从小到大放进list，并取第k个
 */

public class 二叉搜索树中第K小的元素1 {
    int result;
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list =new ArrayList<>();
        firstOrder(root,list,k);
        return result;

    }
    private void firstOrder(TreeNode node, List<Integer> list, int k){
        if(node == null){
            return;
        }
        firstOrder(node.left, list, k);
        list.add(node.val);
        if(list.size()==k){
            result = node.val;
        }
        firstOrder(node.right, list, k);
    }
}
