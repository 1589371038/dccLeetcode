//437. 路径总和 III
//给定一个二叉树，它的每个结点都存放着一个整数值。
//找出路径和等于给定数值的路径总数。
//路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
//二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
public class PathSum {
    //root下所有路径
    public int pathSum(TreeNode root, int sum) {
        if(root==null){
            return 0;
        }
        int startSum1=startSum(root,sum);
        int left=pathSum(root.left,sum);
        int right=pathSum(root.right,sum);
        return startSum1+right+left;

    }
//以root为起点的满足条件的
    private int startSum(TreeNode node, int sum) {
        if(node==null){
            return 0;
        }
        sum=sum-node.val;
        int num=sum==0?1:0;
        int numL=startSum(node.left,sum);
        int numR=startSum(node.right,sum);
        num=num+numL+numR;
        return  num;
    }
}
