/**
 * moon
 */

public class 二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q){
            return root;
        }
        TreeNode leftResult = lowestCommonAncestor(root.left, p, q);
        TreeNode rightResult = lowestCommonAncestor(root.right, p, q);
        if(leftResult==null&&rightResult==null){
            return null;
        }
        if(leftResult==null){
            return rightResult;
        }
        if(rightResult==null){
            return leftResult;
        }
        return root;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root==p){
            return p;
        }
        if(root==q){
            return q;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left==null&&right==null){
            return null;
        }
        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        return root; //两个儿子都带有信息，说明俺就是公共祖先
    }
}
