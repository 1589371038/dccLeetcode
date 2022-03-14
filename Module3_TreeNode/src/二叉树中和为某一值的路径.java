import java.util.ArrayList;
import java.util.List;

/**
 * moon
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 * 思路：回溯
 */

public class 二叉树中和为某一值的路径 {
    List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result, 0, target);
        return results;
    }

    private void dfs(TreeNode root, List<Integer> result, int sum, int target) {
        if(root == null){ // 终点
          return;
        }
        result.add( root.val);
        sum+=root.val;
        if(sum == target && root.left == null &&  root.right == null ){ // 如果是叶子节点才取答案
                results.add(new ArrayList<>(result));
        }
            // 左子树的选择和回溯
        dfs(root.left, result, sum, target);
            // 右子树的选择和回溯
        dfs(root.right, result, sum, target);
        // 回溯
        result.remove(result.size()-1);
        }

}
