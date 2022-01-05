//给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
//
//'?' 可以匹配任何单个字符。
//'*' 可以匹配任意字符串（包括空字符串）。
public class Match_44 {
    public boolean isMatch(String s, String p) {
        if(s==null||p==null){
            return false;
        }
        int lens=s.length();
        int lenp=p.length();
        boolean dp[][]=new boolean[lenp+1][lens+1];//0为空，1才是第一个所以为length+1
        dp[0][0]=true;
        for(int i=1;i<lenp+1;i++){
            dp[i][0]=dp[i-1][0]&&p.charAt(i-1)=='*';
        }
        for(int i=1;i<lenp+1;i++){
            for(int j=1;j<lens+1;j++){
                if(p.charAt(i-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(p.charAt(i-1)>='a'&&p.charAt(i-1)<='z'){
                      if(p.charAt(i-1)==s.charAt(j-1)){
                          dp[i][j]=dp[i-1][j-1];
                      }
                }
                else {
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
                }

            }
        }
        return dp[lenp][lens];

    }
}
