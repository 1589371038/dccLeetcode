import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 思路：对于index=i，用i-nums.length-1的每个下标和i交换，就是i的所有选择
 * 回溯： 终止条件：选到index=nums.length-1
 *      选择：从i到ums.length-1的每个下标和i交换
 *      下一步：递归,index+1
 *      回溯：交换回来
 */

public class 全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null||nums.length<1){
            return result;
        }
        traceBack(0,nums, result);
        return  result;
    }

    private void traceBack(int index, int[] nums, List<List<Integer>> result) {
        if(index==nums.length-1){
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }
        for(int i=index;i<nums.length;i++){
            swap(nums, index, i); //选择
            traceBack(index+1,nums, result);
            swap(nums, index, i);//回溯
        }
    }

    private void swap(int[] nums, int index, int i) {
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
    }
}
