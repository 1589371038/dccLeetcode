import java.util.HashMap;
import java.util.Map;

//136. 只出现一次的数字
//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//说明：
//你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int result = 0;
        for (int num : map.keySet()) {
            if (map.get(num) == 1) {
                result = num;
            }
        }
        return result;
    }
    //260. 只出现一次的数字 III
    //给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
    public int[] singleNumber3(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;   //所有数字异或
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;          //找到一个A^B的位为1
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {   //按照位为1和0，分组异或
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int [] nums={4,1,2,1,2};
        //
        int result=0;
        for(int i=0;i<nums.length;i++){
            System.out.println(Integer.toBinaryString(nums[i]));
            result=result^nums[i];
            System.out.println(Integer.toBinaryString(result));
        }

    }

}
