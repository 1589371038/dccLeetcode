import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 139. 单词拆分
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典，判定 s 是否可以由空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：拆分时可以重复使用字典中的单词。
 */
//我的想法：递归，首次单词匹配之后，截取剩下的部分递归匹配，结果取或
    //比如 appleloveme  [apple][app][lelo][veme][loveme]
    //匹配到[apple] 然后匹配loveme
    //匹配到[app] 然后匹配leloveme
    //结果：超时，这个思路没有剪枝，效率大概是n^3
public class 单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean result =false;
        if(s.equals("")){
            return true;
        }
        for(int i=0;i<wordDict.size();i++){
            String toMatch = wordDict.get(i);
            if(s.startsWith(toMatch)){
                result=result||wordBreak(s.substring(toMatch.length()),wordDict);
            }
        }
        return  result;
    }
    //新思路，用dp从底至上 dp[i]代表 o-i组成的字符是否能被拼凑
    //则 dp[i] = dp[j] (j<i) && i-j 组成的字符在字典中  用hashset减少查找复杂度
    // 从字典最大长度开始计算 j= i-max ++++++到j=i
    //结果正确，时间复杂度n^2
    public static boolean wordBreak1(String s, List<String> wordDict) {
        boolean []dp =new boolean[s.length()+1]; //0-s.length()
        dp[0]=true;  //dp1才表示第一个字符开头的字符串 dp i 表示以i-1为结尾的字符串是否匹配
        HashSet<String> set =new HashSet<>(wordDict);
        int maxLen=0;
        for(int i=0;i<wordDict.size();i++){
        maxLen=Math.max(maxLen,wordDict.get(i).length());
        }
        for(int i=0;i<s.length();i++){
            for(int j=Math.max(0,i-maxLen);j<=i;j++){
                if(dp[j]&&set.contains(s.substring(j,i+1))){
                    dp[i+1]=true;
                    break;
                }

            }
        }
        return dp[s.length()];
    }
    //新思路2，用一样的dp从底至上 dp[i]代表 o-i组成的字符是否能被拼凑
    //则 dp[i] = dp[j] (j<i) && i-j 组成的字符在字典中  用hashset减少查找复杂度
    // 从字典的每一个字符串开始匹配!
    //结果正确，时间复杂度n^2
    public static boolean wordBreak2(String s, List<String> wordDict) {
        boolean []dp =new boolean[s.length()+1]; //0-s.length()
        dp[0]=true;  //dp1才表示第一个字符开头的字符串 dp i 表示以i-1为结尾的字符串是否匹配
        HashSet<String> set =new HashSet<>(wordDict);
        int maxLen=0;
        for(int i=0;i<wordDict.size();i++){
            maxLen=Math.max(maxLen,wordDict.get(i).length());
        }
        for(int i=0;i<s.length();i++){
            for(String toMatch:wordDict){
                if(toMatch.length()<=i+1&& dp[i-toMatch.length()+1]&&s.substring(0,i+1).endsWith(toMatch)){
                    dp[i+1]=true;
                    break;
                }

            }
        }
        return dp[s.length()];
    }
    public static void main(String[] args) {
        wordBreak2("leetcode", Arrays.asList(new String[]{"leet","code"}));
    }
}
