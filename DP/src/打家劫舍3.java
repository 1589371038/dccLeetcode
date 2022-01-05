
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * moon
 * 337. 打家劫舍 III
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 *
 * 思路：父节点选中时的最大收益即为Choose, 未选中的最大收益记为NoChoose,左子树为L，右子树为R
 * choose=(root.val+NoChoose(L)+NoChoose(R))
 * NoChoose=(max(chooseL,NochooseL)+max(chooseR,NochooseR))
 * 父节点依赖子节点的计算结果，因此可以用后序遍历，
 * 那结果怎么记下来呢？
 * 方案1： 可以用递归的return里存放<choose, nochoose>两个结果，用list<>存
 * 方案2： 用两个hashmap存全局的<node,value>
 *
 */

public class 打家劫舍3 {
    HashMap<TreeNode,Integer> resultChoose=new HashMap<>();
    HashMap<TreeNode,Integer> resultNoChoose=new HashMap<>();
    public int rob(TreeNode root) {
        if(root==null){
            return 0;
        }
        //方案1,在return的结果里存储两种选择的值
//        List<Integer> result= postOrder1(root);
//        return Math.max(result.get(0),result.get(1));

        //方案2，用全局的两个HashMAp<Node,integer>存储两种选择的值

        postOrder2(root);
        return Math.max(resultChoose.get(root),resultNoChoose.get(root));

    }



    private List<Integer> postOrder1(TreeNode root) {
        if(root==null){
            List<Integer> result= new ArrayList<>();
            result.add(0);
            result.add(0);
            return  result;
        }
        List<Integer> resultL=postOrder1(root.left);
        List<Integer> resultR=postOrder1(root.right);
        List<Integer> result=new ArrayList<>(); //父节点的结果由子节点推出，result0为未选中的最大收益，result1为选中的最大收益
        result.add(Math.max(resultL.get(0),resultL.get(1))+Math.max(resultR.get(0),resultR.get(1)));
        result.add(root.val+resultL.get(0)+resultR.get(0));
        return result;
    }

    private void postOrder2(TreeNode root) {
        if(root==null){
            return;
        }
        postOrder2(root.left);
        postOrder2(root.right);
        resultChoose.put(root,root.val+resultNoChoose.getOrDefault(root.left,0)+resultNoChoose.getOrDefault(root.right,0));
        resultNoChoose.put(root,Math.max(resultNoChoose.getOrDefault(root.left,0),resultChoose.getOrDefault(root.left,0))
        +Math.max(resultNoChoose.getOrDefault(root.right,0),resultChoose.getOrDefault(root.right,0)));
    }
}
