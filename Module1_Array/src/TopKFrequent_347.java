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
}
