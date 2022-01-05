public class MergeTreeNode {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
if(t1==null&&t2==null){
    return null;
}
if(t1==null){
    return t2;
}
        if(t2==null){
            return t1;
        }
        TreeNode tn=new TreeNode(t1.val+t2.val);
        tn.left=mergeTrees(t1.left,t2.left);
        tn.right=mergeTrees(t1.right,t2.right);
        return tn;

    }

    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if(root1==null&&root2==null){
            return null;
        }
        if(root1==null){
            return root2;
        }
        if(root2==null){
            return root1;
        }
        TreeNode node = new TreeNode(root1.val+root2.val);
        node.left = mergeTrees1(root1.left,root2.left);
        node.right = mergeTrees1(root1.right, root2.right);
        return node;
    }
}
