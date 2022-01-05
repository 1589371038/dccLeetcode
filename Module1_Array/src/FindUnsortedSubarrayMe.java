import java.util.Arrays;

public class FindUnsortedSubarrayMe {
//    给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，
//    那么整个数组都会变为升序排序。
//你找到的子数组应是最短的，请输出它的长度。
//    我的思路：复制，排序，左右相等则对，左右index往里缩，缩到停止为止
public int findUnsortedSubarray(int[] nums) {
    if(nums==null){
        return 0;
    }
    int num=0;
int []copy= Arrays.copyOf(nums,nums.length);
Arrays.sort(copy);
int index1=0,index2=nums.length-1;
while(index2>index1){
    boolean flag1=copy[index1]==nums[index1];
    boolean flag2=copy[index2]==nums[index2];
    if(flag1){
        index1++;num++;
    }
    if(flag2){
        index2--;num++;
    }
    if(!flag1&&!flag2){
        break;
    }
}
if(index1==index2){
    num++;
}
return nums.length-num;
}
}
