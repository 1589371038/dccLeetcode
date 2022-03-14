/**
 * 思路：归并排序的过程中，维护逆序对数量
 * 复杂度降低到nlogn！
 */

public class 数组中的逆序对 {
    int count = 0;
    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return count;
    }

    private void mergeSort(int[] nums, int i, int j) {
        if(i>=j){ // 归并的终点
            return;
        }
        int mid = i + (j-i)/2;
        mergeSort(nums,i,mid);
        mergeSort(nums,mid+1,j); //拆分
        merge(nums, i, mid,  mid+1, j ); // 合并
    }

    private void merge(int[] nums, int i1, int i1End, int i2, int i2End) {
        int fixedI1 = i1; // 由于 i1会变化，这个用来最后赋值
        int[] temp = new int[i2End-i1+1];
        int tempIndex = 0;
        while (i1<=i1End && i2<=i2End){
            if(nums[i1]<=nums[i2]){
                temp[tempIndex++] = nums[i1++];
            }else { // 前面的数 大于后面的数， 从i1到i1End都对i2构成逆序对
                temp[tempIndex++] = nums[i2++];
                count += i1End - i1 +1;
            }
        }
        while (i1<=i1End){ // 如果i2都走完了
            temp[tempIndex++] = nums[i1++];
        }
        while (i2<=i2End){ // 如果i1都走完了
            temp[tempIndex++] = nums[i2++];
        }
        // 排好序了，temp覆盖原数组
        for(int k = fixedI1; k<=i2End; k++){
            nums[k] = temp[k-fixedI1];
        }
    }
}
