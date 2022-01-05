import java.util.Arrays;

/**
 * 摆动排序 II
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 *
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 *进阶：你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 *
 * 思考：先左简单点，想要保证摆动，最好就是不断上下上下
 * 排序后轮着取  123 456  ->  142536
 * 但是当12 23的时候取 1 2 2 3不符合了
 * 如果是从后往前取 2 3 1 2就行
 *
 */

public class 摆动排序324 {
    public void wiggleSort(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int n =nums.length-1;
        for(int i=1;i<nums.length;i=i+2){
            nums[i]=clone[n--];
        }
        for(int i=0;i<nums.length;i=i+2){
            nums[i]=clone[n--];
        }
    }
}
