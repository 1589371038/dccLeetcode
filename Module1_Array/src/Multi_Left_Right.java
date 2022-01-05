//238. 除自身以外数组的乘积
//给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积
public class Multi_Left_Right {
    public int[] productExceptSelf(int[] nums) {
int [] left=new int[nums.length];
        int [] right=new int[nums.length];
        left[0]=1;right[nums.length-1]=1;
        for(int i=1;i<nums.length;i++){
            left[i]=left[i-1]*nums[i-1];
        }
        for(int j=nums.length-2;j>=0;j--){
            right[j]=right[j+1]*nums[j+1];
        }
        int [] result=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            result[i]=left[i]*right[i];
        }
        return result;
    }
}
