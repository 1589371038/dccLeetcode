import java.util.HashSet;
import java.util.Set;

/**
 * moon
 */

public class 最长连续序列 {
    public int result = 0;
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        for(int i: nums){
            if(set.contains(i-1)){
                continue;
            }else{
                int count = 1;
                while(set.contains(++i)){
                    count++;
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }
}
