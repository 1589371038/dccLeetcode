import java.util.HashMap;

public class MaxLength {
    public int maxLengthOfArray(int [] array, int k){
        if(array==null||array.length==0){
            return 0;
        }
        int sum=0;
        int length=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<array.length;i++){
            sum+=array[i];
            if(map.containsKey(sum-k)){
                length=Math.max(length,i-map.get(sum-k));
            }
                map.put(sum,i);
        }
        return length;
    }
}
