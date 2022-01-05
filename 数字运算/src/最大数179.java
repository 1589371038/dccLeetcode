import java.util.Arrays;
import java.util.Comparator;

/**
 * 179. 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * 示例 1：
 *
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 *
 * 想法：排序咯
 */

public class 最大数179 {
    public static String largestNumber(int[] nums) {
        boolean isAll0 =true;
        for(int i:nums){
            if(i!=0){
                isAll0=false;
                break;
            }
        }
        if(isAll0){
            return "0"; //00000这情况谁想得到啊。。
        }
        Integer[] nums1=new Integer[nums.length];
        for(int i=0;i<nums1.length;i++){
            nums1[i]=nums[i];
        }
        Arrays.sort(nums1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o2.toString()+o1.toString()).compareTo(o1.toString()+o2.toString());
            }
        });
        StringBuilder sb = new StringBuilder();
        for(Integer i : nums1){
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = largestNumber(new int[]{3, 30, 34, 5, 9});
        System.out.println(s);
    }
}
