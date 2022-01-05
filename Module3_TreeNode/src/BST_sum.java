//538. 把二叉搜索树转换为累加树
//给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
// 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
//遍历，维护一个公共变量记录累加和
public class BST_sum {
    int sum;
    public TreeNode convertBST(TreeNode root) {
        if(root==null){
            return null;
        }
        changeNode(root);
        return root;

    }

    private void changeNode(TreeNode root) {
        if(root==null) return;
        if(root.right!=null){
            changeNode(root.right);
        }
        root.val+=sum;
        sum=root.val;
        if(root.left!=null){
            changeNode(root.left);
        }

    }
}
