import java.util.*;

//字符串S由小写字母构成，长度为n。定义一种操作，每次都可以挑选字符串中任意的两个相邻字母进行交换。
// 询问在至多交换m次之后，字符串中最多有多少个连续的位置上的字母相同？
//字节跳动2018第二批第三题
public class Swap {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        char[] chars=s.toCharArray();
        int m=sc.nextInt();
        HashMap<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0;i<chars.length;i++){
            int a=chars[i]-'a';
            if(map.containsKey(a)){
                List<Integer> list=map.get(a);
                list.add(i);
            }
            else {
                List<Integer> list=new ArrayList<>();
                list.add(i);
                map.put(a,list);
            }
        }
        int maxLen=0;
      for(int i=0;i<26;i++){
          List<Integer> list = map.get(i);
          if(list!=null){
              int [][] dp=new int[list.size()][list.size()];
              //长度从小到大算，因为大的从小的递推
              for(int len=2;len<=list.size();len++){
                  for(int j=0;j+len-1<list.size();j++){ //j为开始算的起点
                      dp[j][j+len-1]=dp[j+1][j+len-2]+list.get(j+len-1)-list.get(j)-len+1;
                      if(dp[j][j+len-1]<=m&&len>maxLen){
                          maxLen=len;
                      }
                  }
              }
          }
      }
        System.out.println(maxLen);
    }
}
