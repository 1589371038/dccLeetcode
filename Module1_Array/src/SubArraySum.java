public class SubArraySum {
//    给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
//    遍历暴力破解
    public int subarraySum(int[] nums, int k) {
int num=0;
int summary;
for(int i=0;i<nums.length;i++){
    summary=0;
    for(int j=i;j<nums.length;j++){
        summary+=nums[j];
        if(summary==k){num++;break;}

    }
}
return num;
    }
}
