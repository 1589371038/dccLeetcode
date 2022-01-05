import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * <p>
 * 思路：感觉是遍历+回溯啊，
 * 遍历终止条件是当选择的index=length，到达终点说明都是回文串，可输出
 * 选择是：从start的index出发，往后index++，直到子字符串为回文串
 * 行为是：字符串list加上这个回文串
 * 回溯是：字符串list减去这个回文串
 * go！
 */

public class 分割回文字符串131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() < 1) {
            return result;
        }
        List<String> temp = new ArrayList<>();
        huisu(s, 0, temp, result);
        return result;
    }

    private void huisu(String s, int start, List<String> temp, List<List<String>> result) {
        if(start==s.length()){
            result.add(new ArrayList<>(temp));
        }
        for(int i=start;i<s.length();i++){
            if(isHuiwen(s,start,i)){
                temp.add(s.substring(start,i+1));//行为
                huisu(s,i+1,temp,result);
                temp.remove(temp.size()-1);//回溯

            }
        }

    }

    private boolean isHuiwen(String s, int start, int end) {
        while (start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
