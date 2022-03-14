/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * 思路：数组最后一个数字是根节点，如果是搜索树，一定能划分为前后两部分，前一部分都<root,后一部分都 大于root
 * 如果能分，递归判断这两部分是否符合二叉搜索树的后序遍历
 */

public class 判断二叉搜索树的后序遍历 {
    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder, 0, postorder.length - 1);

    }

    private boolean verify(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        int rootVal = postorder[j];
        int bigIndex = -1; // 从左到右寻找第一个比根节点大的数字
        for (int ii = i; ii < j; ii++) {
            if(postorder[ii]>rootVal){
                bigIndex = ii;
                break;
            }
        }
        if(bigIndex==-1){//没有右子树
            return  verify(postorder, i, j-1);
        }else { // 验证是不是bigIndex往后都比rootVal大
            for(int ii=bigIndex+1; ii<j; ii++){
                if(postorder[ii]<rootVal){
                    return false;
                }
            }
            return  verify(postorder, i, bigIndex-1)&& verify(postorder, bigIndex, j-1);

        }
    }
}
