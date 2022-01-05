import java.util.Comparator;
import java.util.PriorityQueue;

/**
 239. 滑动窗口最大值
 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 返回滑动窗口中的最大值。
 示例 1：

 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 输出：[3,3,5,5,6,7]
 解释：
 滑动窗口的位置                最大值
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 */
//用最大堆，但是超时了
public class 滑动窗口的最大值 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len=nums.length;
        int[]result=new int[len-k+1];
        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0;i<k;i++){
            pq.add(nums[i]);
        }
        result[0]=pq.peek();
        for(int i=k;i<nums.length;i++){
            pq.add(nums[i]);
            pq.remove(nums[i-k]);
            result[i-k+1]=pq.peek();
        }
        return result;
    }

    public static void main(String[] args) {
        int [] num={1,3,-1,-3,5,3,6,7};
        maxSlidingWindow(num,3);
        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        pq.add(1);
        pq.add(1);
        pq.add(2);
        pq.remove(1);
        System.out.println("ha");
    }
}
