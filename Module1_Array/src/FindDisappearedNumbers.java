import java.util.ArrayList;
import java.util.List;

//LeetCode 448
//用负号来标记已经出现过的数字
public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int fuIndex=Math.abs(nums[i])-1;
            if(nums[fuIndex]>0){
                nums[fuIndex]=nums[fuIndex]*-1;
            }
        }
        List<Integer> results=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                results.add(i+1);
            }
        }
        return results;
    }
}
