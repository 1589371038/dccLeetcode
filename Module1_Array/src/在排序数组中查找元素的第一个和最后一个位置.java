/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * 思路：特殊的二分查找，如果mid[i]=target则right=i可以 找到最左边的taget，
 *   如果mid[i]=target则left=i可以 找到最左边的taget，
 */

public class 在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        int indexL=0;
        int indexR=nums.length-1;
        while (indexL<=indexR){
            int mid=(indexL+indexR)/2;
            if(nums[mid]<target){
               indexL=mid+1;
            }else if(nums[mid]>target){
                indexR=mid-1;
            }else {
                indexR=mid;
                if(indexL==indexR){
                    result[0]=indexL;
                    break;
                }
            }
        }
         indexL=0;
         indexR=nums.length-1;
        while (indexL<=indexR){
            int mid=(indexL+indexR)/2;
            if(nums[mid]<target){
                indexL=mid+1;
            }else if(nums[mid]>target){
                indexR=mid-1;
            }else {
                indexL=mid;
                if(indexL==indexR-1||indexL==indexR){
                    result[1]=nums[indexR]==target?indexR:indexL;
                    break;
                }
            }
        }
        return result;
    }
}
