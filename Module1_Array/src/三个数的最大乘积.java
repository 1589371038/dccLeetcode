/**
 * moon
 */

public class 三个数的最大乘积 {
    //思路 三个最大数和 两个最小数*最大数  两个之间最大的那个
    public static int maximumProduct(int[] nums) {
        int [] max = new int[]{Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE}; //max[0]>maxp[1]>maxp[2]
        int [] min = new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE}; //min[0]<min[1]
        for(int i = 0;i<nums.length; i++){
            if(nums[i]>max[2]){
                max[2]=nums[i];
                if(max[2]>max[1]){
                    int temp = max[1];
                    max[1] = max[2];
                    max[2] = temp;
                }
                if(max[1]>max[0]){
                    int temp = max[0];
                    max[0] = max[1];
                    max[1] = temp;
                }
            }
            if(nums[i]<min[1]){
                min[1]=nums[i];
                if(min[1]<min[0]){
                    int temp = min[0];
                    min[0] = min[1];
                    min[1] = temp;
                }
            }
        }
        return Math.max(max[0]*max[1]*max[2],max[0]*min[0]*min[1]);

    }

    public static void main(String[] args) {
        maximumProduct(new int[]{1000,1000,0});
    }
}
