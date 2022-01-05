import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 原本思路是通过前序遍历+中序遍历序列化，然后恢复成树反序列化
 * 但是其实这种方式有个致命弱点，树里的节点数字不重复才有用！
 *
 * 新思路：序列化：前序遍历，但是遇到null也加入null节点(这样才能唯一确定一棵树)
 * 题解：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/solution/er-cha-shu-de-xu-lie-hua-yu-fan-xu-lie-hua-by-le-2/
 */

public class 二叉树的序列化和反序列化 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString().substring(0,sb.length()-1);//去掉最后一个 , 方便处理
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if(root==null){
            sb.append("null,");
            return;
        }else {
            sb.append(root.val+",");
            dfs(root.left,sb);
            dfs(root.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        List<String> dataS = new ArrayList<>(Arrays.asList(split));
        TreeNode result = buildTree(dataS);
        return result;
    }

    private TreeNode buildTree(List<String> dataS) {
        String s = dataS.get(0);
        dataS.remove(0);
        if(s.equals("null")){
            return null;
        }else {
            TreeNode node =new TreeNode(Integer.parseInt(s));
            node.left=buildTree(dataS);
            node.right=buildTree(dataS);
            return node;
        }
    }

}

