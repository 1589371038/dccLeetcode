import java.util.PriorityQueue;

//数组第k大的数
public class Kth_BIG {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(k);
        for(int i=0;i<nums.length;i++){
            if(i<k){
                pq.offer(nums[i]);
            }
            else{
                if(nums[i]>pq.peek()){
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
        }
        return pq.peek();

    }
}
