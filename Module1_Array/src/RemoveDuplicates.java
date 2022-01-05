//26. 删除排序数组中的重复项
//给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
//
//不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        else if(nums.length==1){
            return 1;
        }
//思路双指针，一个用于探测，一个用于修改
        int index1=1; //探测指针
        int index2=1; //修改指针
        int pre=nums[0];//前一个值
        for(index1=1;index1<nums.length;index1++){
            if(nums[index1]!=pre){
                nums[index2]=nums[index1];
                pre=nums[index1];
                index2++;
            }
        }
        return index2;
    }
}
