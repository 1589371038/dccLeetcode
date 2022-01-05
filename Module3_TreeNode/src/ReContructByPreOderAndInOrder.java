import java.util.Arrays;

//    105. 从前序与中序遍历序列构造二叉树
//根据一棵树的前序遍历与中序遍历构造二叉树。
//
//注意:
//你可以假设树中没有重复的元素。
public class ReContructByPreOderAndInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length!=inorder.length||preorder.length==0){
            return null;
        }
        int num=preorder[0];//根节点的数字
        int index=0;//根节点的位置
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==num){
                index=i;   //根节点出现在第i个则左边0到i-1都是左子树,右边i+1到length-1都是右子树
            }
        }
        TreeNode root=new TreeNode(num);
        root.left= buildTree(Arrays.copyOfRange(preorder,1,index+1),Arrays.copyOfRange(inorder,0,index));
                root.right=buildTree((Arrays.copyOfRange(preorder,index+1,preorder.length)),Arrays.copyOfRange(inorder,index+1,inorder.length));
return root;

    }
}
