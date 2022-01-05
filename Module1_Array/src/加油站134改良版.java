/**
 * moon
 */

public class 加油站134改良版 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int[] pure = new int[gas.length];
        for(int i=0;i<pure.length;i++){
            pure[i]=gas[i]-cost[i];
        }
        a:   for(int i=0;i<pure.length;i++){//以每一个加油站为起点
            int pureCount=0;
            for(int j=i, count =0;count<pure.length;j=(j+1)%pure.length,count++){
                pureCount+=pure[j];
                if(pureCount<0){  //从i出发走到j失败了，那从i-j-1出发都到不了j，因此下次循环i直接从j开始
                    if(i==j){
                        continue a; //如果第一步走不下去，从j+1开始  由于i会++所以实际上从j+1开始
                    }else {
                        i=i+count-1; //如果是后面走不到j，从新的起点开始

                        continue a;
                    }

                }
            }
            return i; //如果环游一周还没有遇到没油，说明成功了
        }
        return -1;
    }

    public static void main(String[] args) {
        //canCompleteCircuit(new int[]{5,5,1,3,4}, new int[]{8,1,7,1,1});
        canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3});
    }
}
