import java.util.List;

/**
 * moon
 */

public class TestFor层序遍历 {
    public static void main(String[] args) {
        TreeNode root1=new TreeNode(1);
        TreeNode root2=new TreeNode(2);
        TreeNode root3=new TreeNode(2);
        TreeNode root4=new TreeNode(4);
        TreeNode root5=new TreeNode(5);
        TreeNode root6=new TreeNode(5);
        TreeNode root7=new TreeNode(4);
        root1.left=root2;root1.right=root3;
        root2.left=root4;root2.right=root5;
        root3.left=root6;root3.right=null;
        二叉树的层序遍历2 s = new 二叉树的层序遍历2();
        List<List<Integer>> lists = s.levelOrder(root1);
        System.out.println("haha");
    }
}
