import java.util.ArrayList;
import java.util.List;

public class IsBST1 {
    List<Integer> list=new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        inorder(root);
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>list.get(i+1)){
                return false;
            }
        }
        return true;

    }

    private void inorder(TreeNode root) {
        if(root!=null){
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }


    }
}
