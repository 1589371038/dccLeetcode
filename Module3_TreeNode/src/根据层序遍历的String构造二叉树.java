/**
 * moon
 * 【5,4,8,11,null,13,4,7,2,null,null,null,1】
 */

public class 根据层序遍历的String构造二叉树 {
    public static TreeNode make(String[] s){
        if(s==null||s.length<1){
            return null;
        }
        Integer val = Integer.valueOf(s[0]);
        TreeNode root = new TreeNode(val);
        deep(root,0,s);
        return root;
    }
//深度优先遍历，根据规律节点为i则左子树节点在数组的下标为2i+1 右子树为2i+2
    private static void deep(TreeNode root, int i, String[] s) {
        if(i*2+1<s.length&&(s[i*2+1])!=null){
            root.left=new TreeNode(Integer.parseInt(s[i*2+1]));
            deep(root.left,i*2+1,s);
        }
        if(i*2+2<s.length&&(s[i*2+2])!=null){
            root.right=new TreeNode(Integer.parseInt(s[i*2+2]));
            deep(root.right,i*2+2,s);
        }
    }

    public static void main(String[] args) {
        String[] s = new String[]{"5","4","8","11",null,"13","4","7","2",null,null,null,"1"};
        TreeNode make = make(s);
        System.out.println("haha");
    }
}
