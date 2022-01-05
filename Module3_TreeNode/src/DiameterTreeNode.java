public class DiameterTreeNode {
    int sum=0;
    public int diameterOfBinaryTree(TreeNode root) {
height(root);
return sum;
    }

    public int height(TreeNode root) {
        if(root==null){return 0;}
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        sum=sum>leftHeight+rightHeight?sum:leftHeight+rightHeight;
        return Math.max(leftHeight,rightHeight)+1;
    }
}
