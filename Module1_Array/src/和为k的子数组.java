import java.util.HashMap;

/**
 * 560. 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
 * 示例 1：
 *
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 *
 * 思考：数组可以有负数，所以不能用双指针
 * //前缀和add[i]  和为k就是 add[j]-add[i]=k,
 * 遍历前缀和，每次遍历到j，就寻找是否存在前缀和值=add[j]-k的，有的话，收集数量，加上去！
 */

public class 和为k的子数组 {
    public int subarraySum(int[] nums, int k) {
        int total=0;
        int add=0;
        HashMap<Integer,Integer> map =new HashMap<>();
        map.put(0,1);//空数组前缀和为0
        for(int i=0; i<nums.length;i++){
            add+=nums[i];
            if(map.containsKey(add-k)){
                total+=map.get(add-k);
            }
            map.put(add,map.getOrDefault(add,0)+1);
        }
        return total;
    }
}
