import java.util.ArrayList;
import java.util.List;

/**
 * 140. 单词拆分 II
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * 说明：
 *
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 *
 * 思考：单词拆分1要求判断是否可以拆分，可以用dp递推的方式来判断
 * 但是这道题需要把拆分的结果拿出来，是典型的回溯做法:
 * 回溯终止条件：index=s.length
 * 从index=0开始判断是否存在单词匹配，如果是，选择此单词，String temp+ " "+单词
 * 然后递归到下一步index从index+单词数开始
 * 回溯,String减去上一个单词的长度+1(空格)
 *
 * String操作这么频繁就用stringbuilder吧
 * 最后的结果删除首个" "
 */

public class 单词拆分2_140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        if(s==null||s.length()<1||wordDict==null||wordDict.size()<1){
            return result;
        }
        //找到长度最大的单词
        int wordSize=0;
        for(String word:wordDict){
            wordSize=Math.max(wordSize,word.length());
        }
        StringBuilder sb = new StringBuilder();
        //开始回溯
        traceBack(s, 0, wordDict, result, sb, wordSize);
        return result;
    }

    private void traceBack(String s, int index, List<String> wordDict, List<String> result, StringBuilder sb, int wordSize) {
        if(index==s.length()){
            result.add(sb.toString().substring(1)); //第一个空格去掉
            return;
        }
        for(int j=index;j<s.length()&&(j-index)<wordSize;j++){ //单词为下标从i到j的子串
            if(wordDict.contains(s.substring(index,j+1))){
                int sbLen = sb.length();//记录添加单词前的起点
                sb.append(" "+s.substring(index,j+1));//选择
                traceBack(s,j+1,wordDict,result,sb,wordSize);
                sb.delete(sbLen, sb.length()); //从添加单词前的起点开始删除
            }
        }
    }
}
