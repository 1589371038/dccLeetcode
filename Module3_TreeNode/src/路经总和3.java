import java.util.HashMap;
import java.util.Map;

/**
 * 437. 路径总和 III
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * //单看一条路径，这不就是和为k的子数组嘛，用hashmap记录前缀和的数量！遍历后计算current- target的前缀和数量
 * //那有多条路径怎么办呢？把hashmap记录的前缀和回溯
 */

public class 路经总和3 {
    static int total =0;
    public static int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        //存储前缀和
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);//这个很重要，前缀和为0也算1个！！
        deep(root,map, 0, targetSum);
        return total;
    }

    private static void deep(TreeNode root, Map<Integer, Integer> map, int add, int targetSum) {
        if(root==null) return;
        add+=root.val;//当前前缀和
        total+=map.getOrDefault(add-targetSum, 0);//计算个数加起来
        map.put(add,map.getOrDefault(add,0)+1);
        deep(root.left,map, add, targetSum);
        deep(root.right,map, add, targetSum);
        map.put(add,map.getOrDefault(add,0)-1); //回溯
    }

    public static void main(String[] args) {
        TreeNode root1 =new TreeNode(5);
        TreeNode root2 =new TreeNode(4);
        TreeNode root3 =new TreeNode(8);
        root1.left=root2;
        root1.right=root3;
        TreeNode root4 =new TreeNode(11);
        root2.left=root4;
        TreeNode root5 =new TreeNode(13);
        TreeNode root6 =new TreeNode(4);
        root3.left=root5;
        root3.right=root6;
        TreeNode root7 =new TreeNode(7);
        TreeNode root8 =new TreeNode(2);
        root4.left=root7;
        root4.right=root8;
        TreeNode root9 =new TreeNode(5);
        TreeNode root10 =new TreeNode(1);
        root6.left=root9;
        root6.right=root10;
        int i = pathSum(root1, 22);
        System.out.println(i);
    }
}
