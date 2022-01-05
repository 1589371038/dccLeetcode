//上一个内存消耗过大，换成两个一维数组
public class Array_sum_equals_s1 {
    public int findTargetSumWays(int[] nums, int S) {
//        排除边界条件
        if(nums==null||nums.length==0||nums.length>20||Math.abs(S)>1000){
            return 0;
        }
//        int [][]dp=new int[nums.length][2001];
        int[] dp1=new int[2001];

        for(int j=0;j<2001;j++){
            if(nums[0]==j-1000||j-1000==-nums[0]){
                dp1[j]++;
            }
//            else{dp1[j]=0;} 这句没必要，默认为0
        }
        if(nums[0]==0){
            dp1[1000]++;
        }
//此处考虑0-2000边界越界的问题，已知越界的dp肯定为0，但是继续扩容有不合适，因此要加上判断
        for(int i=1;i<nums.length;i++){
            int[] dp2=new int[2001];
            for(int j=0;j<2001;j++){
//        不越界就用dp，越界就用0
                int n1=((j-nums[i])>=0&&(j-nums[i])<=2000)?dp1[j-nums[i]]:0;
                int n2=((j+nums[i])>=0&&(j+nums[i])<=2000)?dp1[j+nums[i]]:0;
                dp2[j]=n1+n2;

            }
         dp1=dp2;
        }
        return dp1[S+1000];
    }
}
