//31. 下一个排列
//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
public class NextPerMutation {
    public void nextPermutation(int[] nums) {
int left=nums.length-2;//倒数第二个
        while(left>=0&&nums[left]>=nums[left+1]){
            left--;
        }
        if(left>=0){
            int firstBiggerIndex=left+1;
            while(firstBiggerIndex<=nums.length-1&&nums[firstBiggerIndex]>nums[left]){
                firstBiggerIndex++;
            }
            firstBiggerIndex--;
            swap(nums,left,firstBiggerIndex);
        }
        reverse(nums,left+1);//右边\部分重置
    }
    public void reverse(int[] nums,int start){
        int end=nums.length-1;
        while(start<end){
            swap( nums,start,end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int start, int end) {
        int temp=nums[start];
        nums[start]=nums[end];
        nums[end]=temp;
    }
}
