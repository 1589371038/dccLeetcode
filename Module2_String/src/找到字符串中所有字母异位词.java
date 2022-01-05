import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 *  初始的想法是：排序后一样的是异位词 ，但是每一位都排序最后超时了
 *
 *  正确解法：创造一个数组26大小，代表每个字母出现的次数，往后滑动一位就维护一下数组
 *  用Arrays.equals()做对比，它对比每一位的equals
 */

public class 找到字符串中所有字母异位词 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result=new ArrayList<>();
        if(s==null||p==null||s.length()<p.length()){
            return result;
        }
        int len1 = s.length();
        int len2 = p.length();
        int [] marks =new int[26];
        int [] markp =new int[26];
        for(int i=0;i<p.length();i++){
            markp[p.charAt(i)-'a']++; //初始化目标数组
            marks[s.charAt(i)-'a']++;  //初始化第一个指针位置
        }
        if(Arrays.equals(marks,markp)){
         result.add(0);
        }
        for(int i=1;i+len2<=len1;i++){
            marks[s.charAt(i+len2-1)-'a']++;
            marks[s.charAt(i-1)-'a']--;
            if(Arrays.equals(marks,markp)){
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> anagrams = findAnagrams("abab", "ab");
    }
}
