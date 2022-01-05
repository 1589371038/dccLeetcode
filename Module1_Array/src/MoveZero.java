import java.util.ArrayList;

public class MoveZero {
        public void moveZeroes(int[] nums) {
            ArrayList<Integer> arrayList=new ArrayList<>();
            int count=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]!=0){
                    arrayList.add(nums[i]);
                }
                else{
                    count++;
                }
            }
            for(int i=0;i<count;i++){
                arrayList.add(0);
            }
            for(int i=0;i<nums.length;i++){
                nums[i]=arrayList.get(i);
            }
        }

}
