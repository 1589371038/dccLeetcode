import java.util.Arrays;

public class FindMidOf2SortedArrays {
//    寻找两个有序数组的中位数
//    假设长度为m和n   其实就是找第m+n+1/2和第m+n+2/2个数的平均数
//    问题转移到找两个有序数组的第k大数，要是没时间要求，用最大堆遍历O（m+n）
//    但是要logO（m+n）就需要二分法
//    这里二分法是对k进行二分，对两个数组的第k/2个进行寻找，若相等，则答案就是这个， 可可能是分成第k1和k2个，k1+k2=k
//    若nums1[k1]>nums2[k2]那么久去掉nums2的前k2个，在剩余的两个数组中找第k-k2个，以此类推
//    递归结束1： k1=k2，结束2：len1或len2=0，则第k个为另一个的第k个。
//    这里为了只判断一次某个len是否等于0，可以确保len1<len2,如果len1>len2,就翻转nums1和nums2
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m=nums1.length,n=nums2.length;
return (findkth(nums1, m,  nums2, n, (m+n+1)/2 )+findkth(nums1, m,  nums2, n, (m+n+2)/2 ))/2.0;
}
public int findkth(int[] nums1, int len1, int[] nums2, int len2,int k){
//方便处理，确保len1<len2
    if(len1>len2){
        return  findkth(nums2,len2,nums1,len1,k);
    }
    if(len1==0){
        return nums2[k-1];
    }
    if(k==1){
        return Math.min(nums1[0],nums2[0]);
    }
    int k1=Math.min(k/2,len1);
    int k2=k-k1;
    if(nums1[k1-1]>nums2[k2-1]){
        return findkth(nums1,len1, Arrays.copyOfRange(nums2,k2,len2),len2-k2,k-k2);
    }
    else if(nums2[k2-1]>nums1[k1-1]){
        return findkth(Arrays.copyOfRange(nums1,k1,len1),len1-k1, nums2,k2,k-k1);
    }
    else{
        return nums1[k1-1];
    }
}
}
