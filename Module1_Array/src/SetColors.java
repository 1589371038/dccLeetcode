//75. 颜色分类
//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
//此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
public class SetColors {
    public void sortColors(int[] nums) {
int index0=0;
int index2=nums.length-1;
int curr=0;
while(curr<=index2){
    if(nums[curr]==0){
        int tempt=nums[index0];
        nums[index0]=nums[curr];
        nums[curr]=tempt;
        index0++;
        curr++;
    }
    else if(nums[curr]==1){
        curr++;
    }
    else{
        int tempt=nums[index2];
        nums[index2]=nums[curr];
        nums[curr]=tempt;
        index2--;
    }
}
    }
}
