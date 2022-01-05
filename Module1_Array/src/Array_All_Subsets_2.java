import java.util.ArrayList;
import java.util.List;

//78. 子集
//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//递归法找出所有解
public class Array_All_Subsets_2 {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); i++) {
            String s = Integer.toBinaryString(i).substring(1);
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == '1') {
                    list.add(nums[j]);
                }
            }
            lists.add(list);
        }
        return lists;
    }

    public List<List<Integer>> subsets1(int[] nums) {
        int n = nums.length;
        List<List<Integer>> allResults = new ArrayList<>();
        for (int i =(int)Math.pow(2,n); i<=(int)Math.pow(2,n+1)-1;i++){
            String s = Integer.toBinaryString(i).substring(1);
            List<Integer> result = new ArrayList<>();
            for(int j = 0; j<nums.length; j++){
                if(s.charAt(j)=='1'){
                    result.add(nums[j]);
                }
            }
            allResults.add(result);
        }
        return allResults;
    }
public static void main(String[] args) {
    System.out.println(Integer.toBinaryString(31));
}
}
