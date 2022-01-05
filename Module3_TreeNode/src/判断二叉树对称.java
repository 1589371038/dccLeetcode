//101. 对称二叉树
//给定一个二叉树，检查它是否是镜像对称的。
public class 判断二叉树对称 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
       if(root.left==null&&root.right==null){
           return true;
       }

       else if((root.left!=null&&root.right==null)||(root.right!=null&&root.left==null)){
           return false;
       }
       else {
           if(root.left.val==root.right.val){
           return isSymmetric(root.left)&&isSymmetric(root.right);}
           else {
               return false;
           }
       }
    }
    //===================================================================================
    //2021.11.6最新思路，我发现，镜像的二叉树中序遍历后，字符串是对称的
    //这个想法失败了
    //没考虑到 相同数字的情况
    //       1
    //    2     2
    // 2   null 2  null //不对称但是中序遍历是对称的, 因此当左右子树有一个null的时候，要把null输出！！
    public static boolean isSymmetric1(TreeNode root){
        if(root == null){
            return true;
        }
        StringBuilder sb =new StringBuilder();
        midOrder1(root,sb,false);
        String s = sb.toString();
        String reverse = sb.reverse().toString();
        return  s.equals(reverse);
    }
//中序遍历，收集到sb上，  因此当左右子树有一个null的时候，要把null输出！！
    private static void midOrder(TreeNode root, StringBuilder sb) {
        if(root==null){
            return;
        }
        midOrder1(root.left, sb,false);
        sb.append(root.val);
        midOrder1(root.right, sb, false);
    }
    //中序遍历修补版， 当左右子树有一个null，一个不为null的时候，null那一个添加一个字符'n'
    private static void midOrder1(TreeNode root, StringBuilder sb, boolean putNull) { //有putNull的时候，是null也要输出
        if(root==null){
            if(putNull){
                sb.append('n');
            }
            return;
        }
        if((root.left==null&&root.right==null)){ //两个都为null，不递归下一层
            sb.append(root.val);
            return;
        }
        if((root.left!=null&&root.right!=null)) { //两个都不为null,正常中序递归
            midOrder1(root.left, sb, false);
            sb.append(root.val);
            midOrder1(root.right, sb, false);
        }else { //有一个null null的那个输出
            midOrder1(root.left, sb, root.left==null);
            sb.append(root.val);
            midOrder1(root.right, sb, root.right==null);
        }


    }

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
        isSymmetric1(root1);
    }
    //==============================================
    //上述方法不行！！官方的递归方法 //分裂左右两个判断
    public boolean isSymmetric2(TreeNode root){
        return judge(root,root);
    }

    private boolean judge(TreeNode root1, TreeNode root2) {
        if(root1==null&&root2==null){
            return true;
        }
        if(root1==null||root2==null){// 一个null一个非null
            return false;
        }
        if(root1.val!=root2.val){ //不相等
            return false;
        }else {//相等则判断下一层
            return judge(root1.left,root2.right)&&judge(root1.right,root2.left);
        }

    }
    //总结：目前成熟的两种方法：
    // 思路1.递归 左右两边相等且 judge(root1.left,root2.right)&&judge(root1.right,root2.left)
    //思路2：二叉树前序遍历+中序遍历 ,
    //求二叉树的镜像，再前序遍历+中序遍历
    //两个遍历的list相等，则对称
}
