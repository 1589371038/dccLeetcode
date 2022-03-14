import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * moon
 * 不就是去重的全排列2嘛
 * swap法
 * 去重要么在swap的时候去重 要么最终结果用hashset去重
 */

public class 剑指Offer38字符串的排列 {
    Set<String> results = new HashSet<>();
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        dfs(chars, 0, results);
        String[] resultString = new String[results.size()];
         return new ArrayList<String>(results).toArray(resultString);
    }

    private void dfs( char[] chars , int i,  Set<String>  results) {
        // 终点
        if(i == chars.length-1){
            results.add(new String(chars));
        }else {
            for(int j = i; j<chars.length; j++){
                swap(chars, i, j);
                dfs(chars, i+1,results);
                swap(chars, i, j);
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
