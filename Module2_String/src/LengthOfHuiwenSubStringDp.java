/**
 * 5. 最长回文子串
 * 注意dp初始化和时机
 * dp[i][j] 要从i与j差1，到i与j差2，到i与j差3一直
 */

public class LengthOfHuiwenSubStringDp {
    public static String longestPalindrome(String s) {
        boolean [][] dp =new boolean[s.length()][s.length()];  //dp i j 为下标i到j的字符串是否为回文
        int finalI=0;
        int finalJ=0;
        int size=0;
        for(int i=0; i<s.length(); i++){ //初始化两组
            dp[i][i]=true;
            if(size<1){  //如果是回文串，判断是否比最大的大
                        finalI=i;
                        finalJ=i;
                        size=1;
                    }
            if(i+1<s.length()){
                dp[i][i+1]=s.charAt(i)==s.charAt(i+1);
                    if(dp[i][i+1]&&size<2){
                        finalI=i;
                        finalJ=i+1;
                        size=2;
                    }
            }
        }
        int plus = 2;//j比i大plus
        for(;plus<s.length();plus++){
        for(int i=0,j=i+plus; j<s.length();i++,j++){
            dp[i][j]=dp[i+1][j-1]&&s.charAt(i)==s.charAt(j);
                    if(dp[i][j]&&j-i+1>size){
                        finalI=i;
                        finalJ=j;
                        size=j-i+1;
                    }
        }}
        return s.substring(finalI,finalJ+1);
    }

    public static void main(String[] args) {
        String abbac = longestPalindrome("abbac");
        System.out.println(abbac);
    }
}
