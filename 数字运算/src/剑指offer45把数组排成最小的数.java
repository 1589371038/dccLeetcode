import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * moon
 */

public class 剑指offer45把数组排成最小的数 {
    public static String minNumber(int[] nums) {
        List<Integer> numss = Arrays.stream(nums).boxed().sorted(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        long combo1 = Long.parseLong(o1 + "" + o2);
                        long combo2 = Long.parseLong(o2 + "" + o1);
                        if(combo1>combo2){
                            return 1;
                        }else if(combo1<combo2){
                            return -1;
                        }else {
                            return 0;
                        }
                    }
                }
        ).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for(Integer i : numss){
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(minNumber(new int[]{1,2,43}));
    }
}
