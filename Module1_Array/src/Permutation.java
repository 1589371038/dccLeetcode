import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//46全排列
public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
      int indexSure=0;
      List<List<Integer>> lists=new ArrayList<>();
      //加上只有1位的情况,和特殊情况
        if(nums==null||nums.length<1){
            return lists;
        }
        else if(nums.length==1){
            List<Integer> list=new ArrayList<>();
            list.add(nums[0]);
            lists.add(list);
            return lists;
        }
      permuteDo(lists,nums,indexSure);
return lists;
    }

    private void permuteDo(List<List<Integer>> lists, int[] nums, int indexSure) {
        for(int i=indexSure;i<nums.length;i++){
            swap(nums,indexSure,i);
            if(indexSure==nums.length-2){ //如果确认的到了倒数第二位，那就得到答案了   注意那这里必须size大于等于2，所以加上1的情况
                List<Integer> list=new ArrayList<>();
               for(int j=0;j<nums.length;j++){
                   list.add(nums[j]);
               }
                lists.add(list);
            }
            else {
                permuteDo(lists,nums,indexSure+1); //如果没到目标就往后挪一位
            }

            swap(nums,indexSure,i);
        }
    }

    private void swap(int[] nums, int indexSure, int i) {
        int tempt=nums[indexSure];
        nums[indexSure]=nums[i];
        nums[i]=tempt;
    }
}
