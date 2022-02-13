/**
 * 124. 二叉树中的最大路径和
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 * //思路：如果是从一个节点往下的最大路径和，容易算的很，此节点要算，计算左右子节点的最大路径和，较大的那个拿出来，如果>0就加上
 * 如果<=0就舍弃
 *  所以这个最大路劲和and从一个节点往下的最大路径和有啥区别呢？
 *  就是从中间节点出发，可以同时挂左右两边的子树。那中间节点必算，左右子节点的最大路径和如果>0就加上
 *
 *
 */

public class 二叉树中的最大路径和124_2 {
    public static int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        findMaxStart(root);
        return max;
    }
    //计算以root为起点向下的最大路径和
    public int findMaxStart(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftResult = findMaxStart(root.left);
        int rightResult = findMaxStart(root.right);

        //顺便计算以root为最高点的路径和
        int thisMax = root.val + Math.max(leftResult, 0)+Math.max(rightResult, 0);
        max =  Math.max(max, thisMax);
        int maxOfLR = Math.max(leftResult, rightResult);
        return maxOfLR>0? root.val+maxOfLR : root.val;
    }
}
