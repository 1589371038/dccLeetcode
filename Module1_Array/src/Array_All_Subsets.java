import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//78. 子集
//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//递归法找出所有解
public class Array_All_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        lists.add(new ArrayList<Integer>());
        for(int num:nums){
            List<List<Integer>> newLists=new ArrayList<>();

            for(List<Integer> list:lists){
                ArrayList son=new ArrayList<Integer>(list);
                son.add(num);
                newLists.add(son);
            }
            lists.addAll(newLists);
        }
return lists;
    }
}
