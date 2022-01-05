//226. 翻转二叉树
//翻转一棵二叉树。
public class 二叉树反转 {
    public TreeNode invertTree(TreeNode root) {
           if(root==null){
               return null;
           }
           TreeNode temp=root.left;
           root.left=root.right;
           root.right=temp;
           invertTree(root.left);
           invertTree(root.right);
           return root;
    }
    public TreeNode invertTree1(TreeNode root) {
        if(root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
