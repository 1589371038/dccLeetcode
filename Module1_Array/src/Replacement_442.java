//424. 替换后的最长重复字符
//给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
//
//滑动窗口
public class Replacement_442 {
    public int characterReplacement(String s, int k) {
        if(s==null){
            return 0;
        }
        char[] chars = s.toCharArray();
        int left=0;
        int right=0;
        int []count=new int[26];
        int longgest=0;
        int maxLen=0;
        while(right<chars.length){
            char c=chars[right];
            count[c-'A']++;
            longgest=Math.max(longgest,count[c-'A']);
            if(longgest+k<right-left+1){
                count[chars[left]-'A']--;
                left++;
            }
            maxLen=Math.max(maxLen,right-left+1);

           right++;
        }
        return maxLen;

    }
}
