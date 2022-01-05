/**
 * moon
 */

public class 最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1==null||text2==null||text1.length()<1||text2.length()<1){
            return 0;
        }
        int [][]dp =new int[text1.length()][text2.length()];
        for(int j=0;j<text2.length();j++){ //初始化第一行
            if(text1.charAt(0)==text2.charAt(j)){
                for(;j<text2.length();j++){
                    dp[0][j]=1;
                }
                break;
            }
        }
        for(int i=0;i<text1.length();i++){
            if(text2.charAt(0)==text1.charAt(i)){
                for(;i<text1.length();i++){
                    dp[i][0]=1;
                }
            }
        }
        //开始dp
        for(int i=1;i<text1.length();i++){
            for(int j=1;j<text2.length();j++){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()-1][text2.length()-1];
    }
}
