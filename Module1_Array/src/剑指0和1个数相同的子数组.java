import java.util.HashMap;
import java.util.Map;

// 最长长度
// 把0变成-1，0和1个数相同就是和 = 0
// map存[前缀和, 最小index]
// 取key = 前缀和对应的(index, now)
public class 剑指0和1个数相同的子数组 {
    public static int findMaxLength(int[] nums) {
        int sum = 0;
        int maxLen = 0;
        Map<Integer, Integer> addSum = new HashMap<>();
        addSum.put(0, -1);
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 1){
                sum++;
            }else {
                sum--;
            }
            if(!addSum.containsKey(sum)){
                addSum.put(sum, i);
            }else {
                Integer indexStart = addSum.get(sum);
                maxLen = Math.max(maxLen, i-indexStart);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{0,1,0,1,1,0,0};
        int maxLength = findMaxLength(nums);
        System.out.println(maxLength);
    }
}
