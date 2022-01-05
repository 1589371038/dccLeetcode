/**
 * 31. 下一个排列
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 * //思路  如果数组的排列是上升->下降
 * 尾部下降部分，例如3 842 本身已经是最大了，想要优化调整自身是不行了
 * 从后往前知道到第一个下降的下标，如这个3，然后找到后面842里比3大的最小数字和3交换，也就是4
 * 交换后是4832 4开头就大了，但是后面太大了，需要从小到大排序，本来是从大到小，所以左右交换就行了
 *  如果是8432这种找不到下降的，自身就是最优解，直接重排序
 */

public class 下一个排列 {
    public void nextPermutation(int[] nums) {
        if(nums.length==1){
            return;
        }
        int markIndex=-1; //为从右往左数第一个下降的下标
        for(int i=nums.length-2;i>=0;i++){
            if(nums[i]<nums[i+1]){
                markIndex=i;
                break;
            }
        }
        if(markIndex==-1){//从后往前没找到下降的，说明是8421，reverse一下
            reverse(nums,0,nums.length-1);
            return;
        }
        for(int i=nums.length-1;i>markIndex;i--){
            if(nums[i]>nums[markIndex]){ //找到第一个比它大的，做交换
                int temp = nums[i];
                nums[i] = nums[markIndex];
                nums[markIndex] = temp;
                reverse(nums,markIndex+1,nums.length-1); //重排序成从小到大
                break;
            }
        }
    }
    private void reverse(int[] nums, int i, int j){
        while (i<=j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
