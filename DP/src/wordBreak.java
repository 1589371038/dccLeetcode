import java.util.List;

//139. 单词拆分
//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
//说明：
//拆分时可以重复使用字典中的单词。
//你可以假设字典中没有重复的单词。
public class wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        int size=wordDict.size();
boolean [] dp=new boolean[n+1];
dp[0]=true;//空单词可以为true
        for(int i=1;i<n+1;i++){
            for(int j=0;j<size;j++){
                String word=wordDict.get(j);
                if(word.length()<=i&&dp[i-word.length()]&&s.substring(i-word.length(),i).equals(word)){
                    dp[i]=true;
                    break;//true了就跳过，节省计算时间
                }
            }
        }
        return dp[n];
    }
}
