/**
 * moon
 * 124. 二叉树中的最大路径和
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
//思路，先计算从每个根节点往下的最大路径，再计算全路径
public class 二叉树的最长路径 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxline(root);//从一个节点往下累计最大值
        return max;
    }

    private int maxline(TreeNode root) {
        if(root == null){
            return 0;
        }
        int maxL = maxline(root.left);
        int maxR = maxline(root.right);
        // 以root为最高起点的整条路经的最大值为 root节点值+左line(如果>0)/右line(如果>0)
        int roadMax = root.val+(maxR>0?maxR:0)+(maxL>0?maxL:0);
        max = Math.max(roadMax,max);
        //
        if(maxL<0&&maxR<0){ //左右两边都小于0就不能取了
            return root.val;
        }
        return root.val+Math.max(maxL,maxR);
    }
}
