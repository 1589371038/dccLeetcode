import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 * 示例 1：
 *
 * 输入: candidates = [2,3,6,7], target = 7
 * 输出: [[7],[2,2,3]]
 */

public class 组合总数39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        if(candidates.length==0){
            return result;
        }
        int index = 0;
        LinkedList<Integer> chosen = new LinkedList<>();
        traceback(index, candidates, result, chosen, target);
        return result;
    }
//回溯
    private void traceback(int index, int[] candidates, List<List<Integer>> result, LinkedList<Integer> chosen, int target) {
        if(target == 0) { //先判断结束条件
            result.add(new ArrayList<>(chosen));
            return;
        }
        if(target<0){
            return;
        }
        for(int i = index; i<candidates.length;i++){
            chosen.addLast(candidates[i]); //依次选择下一层的数字
            traceback(i,candidates,result,chosen,target-candidates[i]);
            chosen.removeLast();
        }
    }
}
