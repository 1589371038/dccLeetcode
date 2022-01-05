import java.util.ArrayList;
import java.util.List;

/**
 * moon
 * 这是我自己思考的方法，中序遍历收集每个节点值+深度，
 * 然后根据顺序，把不同深度的节点值放入不同的List
 */

public class 二叉树的层序遍历2 {
    int maxDep = 0;
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        List<List<Integer>> ValueAndDepth = new ArrayList<>();  //{{5节点值, 1深度},{4节点值, 2深度}} 中序遍历存储每个节点和深度

        midOrder(root, 0, ValueAndDepth); //中序遍历收集<节点值，深度>

        for(int i =0; i<=maxDep; i++){
            result.add(new ArrayList<>());  //有多少层就新建多少个list
        }
        //开始收集数组，把不同深度的节点值放入不同的List
        for(int i = 0; i<ValueAndDepth.size(); i++){
            List<Integer> couple = ValueAndDepth.get(i);
            List<Integer> depthResult = result.get(couple.get(1)/* 深度对应的List*/);
            depthResult.add(couple.get(0));
        }
        return result;
    }

    private void midOrder(TreeNode root, int depth, List<List<Integer>> ValueAndDepth) {
        if(root == null){
            return;
        }
        midOrder(root.left, depth+1, ValueAndDepth);
        List<Integer> couple = new ArrayList<>();
        couple.add(root.val);
        couple.add(depth);
        ValueAndDepth.add(couple);
        maxDep = Math.max(maxDep,depth);
        midOrder(root.right, depth+1, ValueAndDepth);
    }
}
