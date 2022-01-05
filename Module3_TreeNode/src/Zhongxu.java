import java.util.ArrayList;
import java.util.List;

//中序遍历并找到第n个节点
public class Zhongxu {
     int num=0;
    public List<Integer> inorderTraversal(TreeNode root,int k) {
        List<Integer> list=new ArrayList<>();

        doList(root,list,k);
        return list;
    }

    private void doList(TreeNode root, List<Integer> list,int k) {
        if(root==null){
            return;
        }
        if(root.left!=null){
            doList(root.left,list,k);
        }
        list.add(root.val);
        num++;
        if(num==k){
            System.out.println("中序遍历第k个节点为"+root.val);
        }
        if(root.right!=null){
            doList(root.right,list,k);
        }
    }
}
