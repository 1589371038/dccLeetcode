/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。

 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 思路：想要logn，必须二分法，题目转化为寻找两个有序数组的第k个数字，
 * 比较两个数组的第k/2个数字， 比较小的那个肯定不是第k个了，可以舍弃，从它开始往后找第k-删掉的长度，
 * 如此递归递归结束条件：1 有一个到终点了：比较的开始，大于end  则结果=另一个数组的开始+k-1
 * 2.两个都没到终点，但是k=1，则result=math min num1[start] num2[start]
 */

public class 寻找两个正序数组的中位数2 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int k1 = (m+n+1)/2;
        int k2 = (m+n+2)/2;
        double result = (findKth(nums1,0,m-1, nums2,0,n-1,k1)+findKth(nums1,0,m-1, nums2,0,n-1,k2))*0.5;
        return result;
    }
    private static int findKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k){
        //递归终止条件
        if(start1>end1){ //如果nums1走完了
            return nums2[start2+k-1];
        }
        if(start2>end2){ //如果nums2走完了
            return nums1[start1+k-1];
        }
        if(k==1){ //k不停地除以2，迟早会到1
            return Math.min(nums1[start1],nums2[start2]);
        }
        //未到终止条件，则递归，判断两个数组 start+k/2-1或 end  处哪个更小
        int compareIndex1 = Math.min(end1, start1+k/2-1);
        int compareIndex2 = Math.min(end2, start2+k/2-1);
        if(nums1[compareIndex1]<nums2[compareIndex2]){
            return findKth(nums1,compareIndex1+1,end1,nums2,start2,end2,k-(compareIndex1-start1+1));
        }else {
            return findKth(nums1,start1,end1,nums2,compareIndex2+1,end2,k-(compareIndex2-start2+1));
        }
    }

    public static void main(String[] args) {
        int [] nums1=new int[]{1,3};
        int [] nums2=new int[]{2};
        findMedianSortedArrays(nums1,nums2);
    }
}
