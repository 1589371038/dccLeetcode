public class BinarySearch {
    //该二分查找nums中第一个>=t的元素位置
    int searchl(int[] nums, int t) {
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
        if(nums[l]==t)  //查到了就返回l，否则-1
        return l;
        else return -1;
    }

    //该二分查找nums中最后一个>=t的元素位置
    int searchr(int[] nums, int t) {
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
        if(nums[r]==t)  //查到了就返回l，否则-1
            return r;
        else return -1;
    }
}
