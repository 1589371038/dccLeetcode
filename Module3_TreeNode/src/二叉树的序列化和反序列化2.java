import java.util.Arrays;
import java.util.LinkedList;

/**
 * 优化：
 * 巧妙的反序列化是把list的前面数据不断去除
 * 但是数组这样做其实不好
 * 用双向链表的removeFirst
 * LinkedList 或者ArraYDequeue
 */

public class 二叉树的序列化和反序列化2 {
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
        LinkedList<String> dataS = new LinkedList<>(Arrays.asList(split));
        TreeNode result = buildTree(dataS);
        return result;
    }

    private TreeNode buildTree(LinkedList<String> dataS) {
        String s = dataS.getFirst();
        dataS.removeFirst();
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
