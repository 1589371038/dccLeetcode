/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 算法复杂度决定了必须用二分查找
 * 首先中位数其实就是第m+n+1/2和第m+n+2/2个数的平均数
 *
 * 问题转化为寻找两个排序数组的第K个数
 * 举例: A[] : 1,2,3,5,6
 *      B[] : 4,7,8,9,10 寻找第八个
 *      先找每个数组第四(一半)个也就是5和9， 对比5小了，全部抛弃
 *      从A的第6个和B的第一个开始找第8-4个数字
 *
 *      各往后取2个，但是A中6只能取到6了 B取到7  7>6
 *      抛弃6，从B中找第3个数字
 *
 *      注意点：1取一半长度可能超过数组本身，因此要取length和一半长度的最小
 *      2.终止条件：1一个数组用完了(start>end) 则全部取另一个数组  2 k=1则找两个数组start最小的那个
 *
 */

public class 寻找两个正序数组的中位数 {
    public  double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        return (findKth(nums1,0,nums2,0,+(m+n+1)/2)+findKth(nums1,0,nums2,0,(m+n+2)/2))*0.5;

    }
    private int findKth(int[] nums1, int start1, int[] nums2, int start2, int k ){
        if(start1>=nums1.length){
            return nums2[start2+k-1];
        }
        if(start2>=nums2.length){
            return nums1[start1+k-1];
        }
        if(k==1){
            return Math.min(nums1[start1],nums2[start2]);
        }
        int k_2 = k/2;
        int compareIndex1 = Math.min(nums1.length-1, start1+k_2-1);
        int compareIndex2 = Math.min(nums2.length-1, start2+k_2-1);
        if(nums1[compareIndex1]<nums2[compareIndex2]){//舍弃compareIndex1之前的所有数字
            return findKth(nums1,compareIndex1+1,nums2,start2,k-(compareIndex1-start1+1));

        }else if(nums1[compareIndex1]>nums2[compareIndex2]){
            return findKth(nums1,start1,nums2,compareIndex2+1,k-(compareIndex2-start2+1));
        }else { //如果相等就是解
            return nums1[compareIndex1];
        }
    }
}
