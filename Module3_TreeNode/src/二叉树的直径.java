/**
 * moon
 */
//543. 二叉树的直径
//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
//就是每个节点求深度，=max 左节点深度 加 右节点深度 +1
//直径 = 左节点深度+右节点深度
public class 二叉树的直径 {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        getdepth(root);
        return max;
    }

    private int getdepth(TreeNode root) {
        if (root == null) return 0;
        int leftDep = getdepth(root.left);
        int rightDep = getdepth(root.right);
        int diaMeter = leftDep+rightDep;
        max = Math.max(max, diaMeter);
        return 1 + Math.max(leftDep, rightDep);
    }
}
