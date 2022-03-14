import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * 思路：滑动窗口啊，R右扩，如果=target则输出，如果小于则右扩，如果大于，则 L往右
 *   L往右：如果相等则输出， 如果>target则继续往右, 如果小于target则停止
 *   由于要两个数字，所以R比L大
 */

public class 和为s的连续正数序列 {
    public static int[][] findContinuousSequence(int target) {
        int l = 1;
        int r = 2;
        int sum = 3;
        List<int[]> list = new ArrayList<>();
        while (r<=target){
            if (l == target){
                break;
            }
            // r右扩
            while (sum < target && r<=target){
                r++;
                sum += r;
            }
            if (sum == target && l<r){ // 如果相等，获取结果, l缩小
                int [] array = new int[r-l+1];
                for(int i = 0; i<array.length; i++){
                    array[i] = i+l;
                }
                list.add(array);
                sum -= l;
                l++;
            }else { // 如果sum>target l左缩
                while (sum > target && l < r){
                    sum -= l;
                    l++;
                }
                if(sum == target && l < r){  // 这里l < r地判断是因为可能l=r
                    int [] array = new int[r-l+1];
                    for(int i = 0; i<array.length; i++){
                        array[i] = i+l;
                    }
                    list.add(array);
                    // 如果相等，获取结果后需要左缩
                    sum -= l;
                    l++;
                }

            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] continuousSequence = findContinuousSequence(9);
        System.out.println("a");
    }
}
