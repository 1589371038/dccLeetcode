import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 581. 最短无序连续子数组
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 * 思考：这道题记录在笔记中
 * 为什么可以用单调栈？
 * 把数组分成三段， 第一段和第三段都单调增，第二段的数字比第一段所有都大， 比第三段所有都小
 *
 * 从左往右扫描单调增栈，寻找L的坐标(左边界)
 * 如果一直增下去，那左边界就是nums.length了，
 * 如果遇到一个数字小于栈内数字，那不仅破坏了单调性，还让第二段数字比第一段小了(不行)
 * 因此要维护单调栈，
 */

public class 最短无序子数组 {
    public static int findUnsortedSubarray(int[] nums) {
        if(nums==null||nums.length<1){
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int L=nums.length;
        int R=-1;
        for(int i=0;i<nums.length;i++){  //单调增从左往右，寻找L
            while (!stack.isEmpty()&&nums[stack.peek()]>nums[i]){
                L=Math.min(L,stack.pop());
            }
            stack.push(i);
        }
        for(int i=nums.length-1;i>=0;i--){//单调增从右往左，寻找R
            while (!stack.isEmpty()&&nums[stack.peek()]<nums[i]){
                R=Math.max(R,stack.pop());
            }
            stack.push(i);
        }
        return L<R?R-L+1:0;
    }
    public int findUnsortedSubarray2(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int index1 = nums.length;
        int index2 = -1;
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty()&&nums[stack.peek()]>nums[i]){
                index1 = Math.min(index1, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for(int i = nums.length-1; i>=0; i--){
            while(!stack.isEmpty()&&nums[stack.peek()]<nums[i]){
                index2 = Math.max(index2, stack.pop());
            }
            stack.push(i);
        }
        return index1<index2 ? index2-index1+1 : 0;

    }
    public static void main(String[] args) {
        findUnsortedSubarray(new int[]{2,6,4,8,10,9,15});
    }
}
