import java.util.HashMap;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 */
public class LengthofLonggestSubStringMe {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        int ands=0;
        for(int i=0,j=0;j<s.length();j++){
            if(hm.containsKey(s.charAt(j))&&hm.get(s.charAt(j))>=i){
                i=hm.get(s.charAt(j))+1;
            }
            ands=Math.max(ands,j-i+1);
            hm.put(s.charAt(j),j);
        }
        return ands;
    }
    public int calculate(String s){
        int max = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int i = 0,  j = 0; j < s.length(); j++){
            if(hashMap.containsKey(s.charAt(j))&&hashMap.get(s.charAt(j))>=i){
                i = hashMap.get(s.charAt(j))+1;
            }

            if(j-i+1>max){
                max = j - i+1;
            }
            hashMap.put(s.charAt(j),j);

        }
        return max;
    }
}
