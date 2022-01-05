/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 思想： 用两个指针，第一个指针指向第一个0， 第二个指针一开始也在第一个指针，如果第二个指针指针是0则index2++, 如果是1则和index1置换，
 * 然后index1++,index2++，逐渐把所有0搬到后面
 */

public class 移动零 {
    public void moveZeroes(int[] nums) {
        int index1=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                index1 = i; //index1为第一个0出现的位置
                break;
            }
        }
        if(index1==-1){
            return; //如果没有0结束了
        }
        int index2=index1; //右指针
        while (index2<nums.length){
            if(nums[index2]==0){
                index2++;
            }else {
                swap(nums,index1,index2);
                index1++;
                index2++;
            }
        }

    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1]= nums[index2];
        nums[index2]= temp;
    }
}
