import java.util.*;

//347. 前 K 个高频元素
//        给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
//思想，先用map统计频率，再用最小堆，容量为k
public class TopKFrequent_347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq=new PriorityQueue<>(k, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        });
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for(Map.Entry<Integer, Integer> entry:entries){
                 if(pq.size()<k){
                     pq.offer(entry);
                 }
                 else{
                     if(entry.getValue()>pq.peek().getValue()){
                        pq.poll();
                        pq.offer(entry);
                     }
                 }
        }
        List<Integer> results=new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry:pq){
            results.add(entry.getKey());
        }
        Integer [] integers=results.toArray(new Integer[k]);
        int[] result = Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();
        return result;
    }

    /**
     * 前一个方法多余了，前K个用堆就行了，不用全部排序！
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        // 小顶堆
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        }); //  int[] 存num和次数
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int [] a = new int[]{entry.getKey(), entry.getValue()};
            if(pq.size()<k){
                pq.offer(a);
            }else {
                if(a[1]>pq.peek()[1]){
                    pq.poll();
                    pq.offer(a);
                }
            }
        }
        int [] result = new int[k];
        for(int i=0;i<k;i++){
            result[i] = pq.poll()[0];
        }
        return result;
    }
}
