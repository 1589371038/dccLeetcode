import java.util.ArrayList;
import java.util.List;

//438. 找到字符串中所有字母异位词
//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
//字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
//说明：
//字母异位词指字母相同，但排列不同的字符串。
//不考虑答案输出的顺序。
public class findSonAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        char [] charsS=s.toCharArray();
        char[] charsP=p.toCharArray();
        int left=0;
        int right=0;
        List<Integer> results=new ArrayList<>();
        int[] windows=new int[26];
        int[] needs=new int[26];
        for(int i=0;i<charsP.length;i++){
            int num=charsP[i]-'a';
            needs[num]++;
        }
        while(right<charsS.length){
            int numRight=charsS[right]-'a';
            windows[numRight]++;
            right++;
            while(windows[numRight]>needs[numRight]){
                int numLeft=charsS[left]-'a';
                windows[numLeft]--;
                left++;
            }
            if(right-left==charsP.length){
                results.add(left);
            }

        }
        return results;

    }
}
