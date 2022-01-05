import java.util.*;
import java.util.stream.Collectors;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
//思路：排列是经典的回溯法，
    //全排列有两种回溯思路：1.swap 2.用boolean[]flag记录选过的，每一步都选择一个可选的进入下一步，然后回溯
    //这个题目。，要考虑可能有相同的值
    //选择swap方案，每次swap的时候，记录用过的头数字，如果用过的数字就不再swap
    //-10 <= nums[i] <= 10 一共21个数字  用一个record[21] 下标0-20 对应-10到10 记录是否置换过 或者用个hashset
public class 全排列2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null||nums.length<1){
            return result;
        }
        nextStep(0,nums,result);
        return result;
    }
//swap法
    private void nextStep(int index, int[] nums, List<List<Integer>> result) {
        if(index==nums.length-1){
            List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
            result.add(collect);
        }
        HashSet<Integer> record = new HashSet<>();
        for(int i=index;i<nums.length;i++){
            if(!record.contains(nums[i])){
                swap(nums,index,i);
                nextStep(index+1,nums,result);
                swap(nums,index,i);
                record.add(nums[i]);
            }

            
        }
    }

    private void swap(int[] nums, int index, int i) {
        int temp = nums[index];
        nums[index]=nums[i];
        nums[i]=temp;
    }
}
