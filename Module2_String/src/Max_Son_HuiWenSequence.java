

//516. 最长回文子序列
//思路：dp  书上有记
public class Max_Son_HuiWenSequence {

    public void test1(){
        int result=longestPalindromeSubseq("abbaa");
        System.out.println(result);
    }
    public int longestPalindromeSubseq(String s) {
int len=s.length();
int [][] dp=new int[len][len];
for(int j=0;j<len;j++){
    dp[j][j]=1;
    int i=j-1;   //当ij相邻时只用相等来判断
    if(i>=0){
        dp[i][j]=s.charAt(i)==s.charAt(j)?2:1;
    }
    for( i=j-2;i>=0;i--){
        if(s.charAt(i)==s.charAt(j)){
            dp[i][j]=dp[i+1][j-1]+2;
        }
        else{
            dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
        }

    }
}
return dp[0][len-1];
    }
    public int longestPalindromeSubseq2(String s) {
        int[][]dp = new int[s.length()][s.length()];
        for(int j = 0; j<s.length(); j++){
            dp[j][j]=1;
            for(int i=j-1; i>=0; i--){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else {
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }

            }
        }
        return dp[0][s.length()-1];
    }
}
