import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//三数之和
//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
//
//注意：答案中不可以包含重复的三元组。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/3sum
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
//分析：难点1：三数之和，便遍历组合则计算量很大
//难点2：不可以包含重复的三元组，也就是要去掉重复的
//方法：双指针+排序
//排好序后，从小到大为最左边指针current，若current>0了就没戏了
//current小于0，左指针为i+1右指针为n-1，  大了，右指针缩，小了，左指针缩。 相等，则录入，并且左右指针的值如果在录入过之后，++--相等
//就要跳过。current指针如果和i-1相等，也跳过。
public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        if(nums==null){
            return lists;
        }
        Arrays.sort(nums);
        int len=nums.length;
        for(int i=0;i<len-2;i++){
            int current=nums[i];
            if(current>0){return  lists;}
            if(i>0&&current==nums[i-1]){
                continue;
            }
            int L=i+1,R=len-1;
            while(L<R){
                int sum=current+nums[L]+nums[R];
                if(sum==0){
                 ArrayList<Integer> list=new ArrayList<>();
                 list.add(current);
                 list.add(nums[L]);
                 list.add(nums[R]);
                 lists.add(list);
                 while(L<R&&nums[L+1]==nums[L]){
                        L++;
                    }
                    while(L<R&&nums[R-1]==nums[R]){
                       R--;
                    }
                 L++;R--;
                }
                else if(sum<0){
                    L++;
                }
                else{
                    R--;
                }
            }
        }
return lists;
    }
}
