//34. 在排序数组中查找元素的第一个和最后一个位置
public class BinarySearch_FirstAndLast {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null||nums.length<1){
            return new int []{-1,-1};
        }
        int start=searchl(nums,target);
        int end=searchr(nums,target);
        return new int []{start,end};
    }
    //该二分查找nums中第一个>=t的元素位置
    public static int searchl(int[] nums, int t) {
        int l = 0;
        int r = nums.length;
        int m;
        while (l < r) {
            m = (l + r) / 2;
            if (nums[m] < t) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if(l>=0&&l<nums.length&&nums[l]==t)  //查到了就返回l，否则-1
            return l;
        else return -1;
    }

    //该二分查找nums中最后一个>=t的元素位置
    public static int searchr(int[] nums, int t) {
        int l=0;
        int r=nums.length-1;
        int m;
        while(l<r){
            m=(l+r)/2+1;
            if(nums[m]>t){
                r=m-1;
            }
            else{
                l=m;
            }
        }
        if(r>=0&&r<nums.length&&nums[r]==t)  //查到了就返回l，否则-1
            return r;
        else return -1;
    }
}
