//41. 缺失的第一个正数
//给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
//
// 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
//1从小到大对数组双循环对比，则时间复杂度o(n2)
//2 从小到大hash表，时间复杂度o(n)空间复杂o(n)
//3 用正负表示数组该位置是否存在， 负数为标记已出现过，则第一个整数的位置就是最小正数，如果都是负数，说明最小正数为n+1
//处理：一开始出现的负数没效力，置为n+1    1-n的数字才处理  大于n的也没效力
public class FirstMissingPositive41 {
    public int firstMissingPositive(int[] nums) {
       int n=nums.length;
       for(int i=0;i<nums.length;i++){
           if(nums[i]<=0){
               nums[i]=n+1;
           }
       }
        for(int i=0;i<nums.length;i++){
            int num=Math.abs(nums[i]);
          if(num<=n){               //被置为负数的数也要参加运算
              nums[num-1]= -Math.abs(nums[num-1]);//-|x|保证为负值
          }
        }
        for(int i=0;i<nums.length;i++){
              if(nums[i]>0){
                  return i+1;
              }
        }
        return n+1;
    }
}
