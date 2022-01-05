
//no.32 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
public class MaxValidBrackets {

   public  int MaxValid(String  s){
       int[] dp=new int[s.length()];
       int maxLen=0;
       for(int i=1;i<s.length();i++){
           if(s.charAt(i)==')'){
               if(s.charAt(i-1)=='('){
                   dp[i]=i>=2?(dp[i-2]+2):2;
               }
               else if(s.charAt(i-1)==')'){
                   if((i-dp[i-1]-1)>=0&&s.charAt(i-dp[i-1]-1)=='('){
                       dp[i]=dp[i-1]+2+ (i-dp[i-1]-2)>=0?dp[i-dp[i-1]-2]:0;
                   }
               }
           }
           maxLen= Math.max(dp[i], maxLen);
       }
       return maxLen;
   }
//最长有效括号 dp[i]表示以i为结尾的字符串的最长有效长度
    // 那么 () i前面是这样的话 dp[i] = dp[i-2]+2 (i>=2)
    // 如果)) 看左边括号是否有效匹配哦，如果有    (---)) 看再左边能否和i位置的)匹配，如果成了((---))就至少有这么多
    //也有可能()((---)),要考虑
    public  int MaxValid2(String  s){
        int[] dp =new int[s.length()];
        int maxLen = 0;
        for(int i = 1; i<s.length(); i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){//()
                    dp[i]=getDp(dp, i-2)+2;
                    maxLen = Math.max(maxLen, dp[i]);
                }else { //))
                    if(getDp(dp,i-1)>0&&(i-getDp(dp,i-1)-1)>=0/*防止charat越界*/){ //如果左边右括号组成有效的了
                        //这里charAt可能越界
                        dp[i]=s.charAt(i-getDp(dp,i-1)-1)=='('/*匹配上了*/?
                                getDp(dp,i-1)+2+getDp(dp,i-getDp(dp,i-1)-2)
                                :0;
                        maxLen = Math.max(maxLen, dp[i]);
                    }
                }
            }
        }
        return maxLen;
    }
    int getDp(int[] dp , int i){
       if(i>=0 && i<dp.length){
           return dp[i];
       }else return 0;
    }
}
