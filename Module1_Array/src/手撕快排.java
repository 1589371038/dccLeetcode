/**
 * 快排不就是递归+定位嘛，easy
 */

public class 手撕快排 {
    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return; //递归终止条件
        }
        int i = start;
        int j = end;
        int index = nums[i];  //基准点选择最左边
        while (i < j) {
            while (i < j && nums[j] > index) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }
            while (i < j && nums[i] < index) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i]=index;
        quickSort(nums,start,i-1);
        quickSort(nums,i+1,end);
    }

    public static void main(String[] args) {
        int [] nums = new int[]{2,5,6,4,3,1,8,7};
        quickSort(nums,0,nums.length-1);
        System.out.println("a");
    }
}
