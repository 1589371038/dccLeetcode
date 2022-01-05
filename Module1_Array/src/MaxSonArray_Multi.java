//152. 乘积最大子数组
//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//用dp但是不能只考虑最大也要考虑最小，因为-100*-2=200
//维护两个dp
public class MaxSonArray_Multi {
    public int maxProduct(int[] nums) {
        if(nums==null||nums.length<1){
            return 0;
        }
        int [] dpMax=new int[nums.length];
        int [] dpMin=new int[nums.length];
        int max=nums[0];
        dpMax[0]=nums[0];
        dpMin[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            dpMax[i]=Math.max(Math.max(dpMax[i-1]*nums[i],dpMin[i-1]*nums[i]),nums[i]);
            dpMin[i]=Math.min(Math.min(dpMax[i-1]*nums[i],dpMin[i-1]*nums[i]),nums[i]);
            max=Math.max(max,dpMax[i]);
        }
        return max;

    }
}
