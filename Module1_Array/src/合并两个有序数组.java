/**
 *88. 合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */
//思想，num1的长度为m+n，后面都是值为0的空位，如果从小到大构造，则需要移位
    //但是从大到小构造就可以从后往前了
    //终止条件 如果nums2填完了(index2<0)直接就结束
    //如果nums1填完了，需要把剩下的nums2补充到nums1的位置
    //例如 [7,8,0,0][1,2] ->[0,0,7,8][1,2]->填充[1,2,7,8]

public class 合并两个有序数组 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int index1=m-1;
    int index2= n-1;
    int index=m+n-1;
    while (!(index2<0||index1<0)){
        if(nums1[index1]>nums2[index2]){
            nums1[index]=nums1[index1];
            index--;
            index1--;
        }else {
            nums1[index] = nums2[index2];
            index--;
            index2--;
        }
    }
    if(index2<0){
        return;
    }else {
        for(int i=0;i<=index2;i++){
            nums1[i]=nums2[i];
        }
    }

    }

    public static void main(String[] args) {
        int[] nums1=new int[]{1,2,3,0,0,0};
        int[] nums2=new int[]{2,5,6};
        merge(nums1,3,nums2,3);
    }
}
