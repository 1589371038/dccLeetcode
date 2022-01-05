import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 计算回文子串有太多重复计算
 * 用dp优化
 * dp[i][j]=dp[i+1][j-1]&&s[i]==s[j]
 * 初始化：i>=j时为true
 *
 * 注意递推时机
 */

public class 分割回文字符串131DP增强版 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() < 1) {
            return result;
        }
        //dp[i][j]表示从i到j的子串是否为回文串
        boolean [][]dp = new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],true);
        }
        for(int j=1;j<s.length();j++){
            for(int i=0;i<j;i++){
                dp[i][j]=dp[i+1][j-1]&&s.charAt(i)==s.charAt(j);
            }
        }

        List<String> temp = new ArrayList<>();
        huisu(s, 0, temp, result, dp);
        return result;
    }

    private void huisu(String s, int start, List<String> temp, List<List<String>> result, boolean[][] dp) {
        if(start==s.length()){
            result.add(new ArrayList<>(temp));
        }
        for(int i=start;i<s.length();i++){
            if(dp[start][i]){
                temp.add(s.substring(start,i+1));//行为
                huisu(s,i+1,temp,result,dp);
                temp.remove(temp.size()-1);//回溯

            }
        }

    }

}
