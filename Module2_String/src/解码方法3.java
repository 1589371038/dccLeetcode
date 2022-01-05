import java.util.HashSet;
import java.util.Set;

/**
 * 自下而上地dp
 * dp[i]=dp[i-1]+dp[i-2] 如果分别符合单个和两个数字的解码分流条件
 * if s[i]=0 dp=0;
 * dp[i]=dp[i-1] 单个的符合了
 * if符合两个的 dp[i]=dp[i]+dp[i-2]
 */

public class 解码方法3 {
    public int numDecodings(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        Set<String> validNum = new HashSet<>();
        for (int i = 10; i <= 26; i++) {
            validNum.add(String.valueOf(i));
        }
        //dp i 表示从s的末尾往前第i位的解码个数
        int dp[] = new int[s.length()];
        //初始化末尾
        dp[s.length() - 1] = s.charAt(s.length() - 1) == '0' ? 0 : 1;
        for (int i = s.length() - 2; i >= 0; i--){
            if(s.charAt(i)=='0'){
                dp[i]=0;
                continue;
            }
            //单个数字分流
            dp[i]=dp[i+1];
            if(validNum.contains(s.substring(i,i+2))){
                if(i+2==s.length()){ //特殊情况，无法取得dp[s.length]
                    dp[i]++;
                }else {
                    dp[i]+=dp[i+2];
                }
            }
        }
        return dp[0];
    }
}
