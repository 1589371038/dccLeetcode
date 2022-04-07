/**
 * moon
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * 无重复的排序数组形如4567 012
 * 如何搜索？
 * 先找到旋转的边界，
 * 然后再两边分别二分查找
 */

public class 搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        // 二分查找旋转的位置
        int s = 0;
        int e = nums.length - 1;
        while (s < e - 1) {
            int mid = s + (e - s) / 2;
            if (nums[mid] > nums[s]) {
                s = mid;
            } else {
                e = mid;
            }
        }
        if (nums[s] < nums[e]) { // 说明旋转点是0，相当于每旋转，全部升序
            int res = binarySearch(nums, target, 0, nums.length - 1);
            return res;
        } else {
            int res1 = binarySearch(nums, target, 0, s);
            int res2 = binarySearch(nums, target, e, nums.length - 1);
            if (res1 != -1) {
                return res1;
            } else return res2;
        }

    }

    private int binarySearch(int[] nums, int target, int i, int j) {
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return -1;
    }
}
