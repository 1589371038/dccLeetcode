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
 */

//思路1，效率O(n) 从两个数组的0位置开始，哪个小，指针就往后移，直到两个指针都往后移动m+n+1/2 次 and m+n+2/2 平均

    //最后也没有100%，放弃了，用二分法吧，见寻找两个正序数组的中位数2


public class 寻找两个正序数组的中位数 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int index1=0;
        int index2=0;
        int result1=0; //记录第m+n+1/2 个数字
        int result2=0;//记录第m+n+2/2 个数字
        if(nums1.length==0){
            return ((double)nums2[(nums2.length-1)/2]+(double)nums2[(nums2.length)/2])/2;
        }
        if(nums2.length==0){
            return ((double)nums1[(nums1.length-1)/2]+(double)nums1[(nums1.length)/2])/2;
        }
        for(int count = 0;count<(m+n+2)/2;count++){
            if(index1>=nums1.length){ //如果index1越界
                if(count==(m+n+1)/2-1){
                    result1=nums2[index2];
                }
                if(count==(m+n+2)/2-1){
                    result2=nums2[index2];
                }
                index2++;
                break;
            }
            if(index2>=nums2.length){//如果index2越界
                if(count==(m+n+1)/2-1){
                    result1=nums1[index1];
                }
                if(count==(m+n+2)/2-1){
                    result2=nums1[index1];
                }
                index1++;
                break;
            }
            if(nums1[index1]<nums2[index2]){
                if(count==(m+n+1)/2-1){
                    result1=nums1[index1];
                }
                if(count==(m+n+2)/2-1){
                    result2=nums1[index1];
                }
                index1++;
            }else {
                if(count==(m+n+1)/2-1){
                    result1=nums2[index2];
                }
                if(count==(m+n+2)/2-1){
                    result2=nums2[index2];
                }
                index2++;
            }
        }
        return  ((double) result1+(double) result2)/2;
    }

    public static void main(String[] args) {
        int [] m = new int[]{};
        int [] n = new int[]{1};
        double medianSortedArrays = findMedianSortedArrays(m, n);
        System.out.println(medianSortedArrays);
    }
}
