import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 *
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
 *
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 *
 * 思路：可以重复选取，那每一次如果上一次选了i，那下一层就可以从i选择到nums.length-1，
 * 回溯吧
 * 状态：LinkedList<Integer>记录选择，但是要回溯
 * 选择： 从i到 nums.length-1，
 * 回溯：LinkedList<Integer> .removeLast
 */

public class 组合总和 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates==null||candidates.length<1){
            return  result;
        }
        LinkedList<Integer> record = new LinkedList<>();
        traceBack(candidates, 0, record,0, target, result);
        return result;
    }

    private void traceBack(int[] candidates, int index, LinkedList<Integer> record, int sum, int target, List<List<Integer>> result) {
        //终止条件
        if(sum==target){
            result.add(new ArrayList<>(record));
            return;
        }
        if(sum>target){
            return;
        }
        //选择加下一步加回溯
        for(int i=index;i<candidates.length;i++){
            record.addLast(candidates[i]); //选择
            traceBack(candidates,i,record,sum+candidates[i], target, result);//下一层
            record.removeLast(); //回溯
        }
    }
}
