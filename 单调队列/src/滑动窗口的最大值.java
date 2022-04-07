import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 *
 *  这道题的经典解法是用滑动窗口和栈来做，栈的remove要根据下标来处理
 *
 *  但是还有更好的解法：单调队列 一个双端队列
 *  https://leetcode-cn.com/problems/sliding-window-maximum/solution/java-shuang-duan-dui-lie-239-hua-dong-ch-eqlk/
 *  如果是一个从大到小的数组
 *  可以维持一个由大到小的窗口，那么队首永远是最大的那个数字。往右移动的时候新增队尾数字， 去除队首数字。
 *
 *  但是现实情况是数组大小不一，但是一样可以维护从左到右的单调减双端队列。 和单调栈的维护方式相同
 *  队首就是窗口的最大值。 窗口存储的是下标而不是数字
 *  右移的时候，新增数字需要考虑维护单调减  去除的左边数字需要看是否等于队首，如果相等就要remove掉
 */

public class 滑动窗口的最大值 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1]; // 存放结果
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i<n; i++){
            // 放入队列前先维护单调减
            while (!deque.isEmpty() && nums[deque.getLast()]< nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            // 左边的缩了，可能要去掉队首
            if( i - k  == deque.getFirst()){
                deque.pollFirst();
            }
            // 如果队列满K个(i>=k-1)了开始计算
            if (i>= k-1){
                res[i-k+1] = nums[deque.getFirst()];
            }
        }
        return res;
    }
}
