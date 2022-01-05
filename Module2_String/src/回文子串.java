/**
 * 647. 回文子串
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 *
 * 回文字符串 是正着读和倒过来读一样的字符串。
 *
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 * 思路：从不同的回文中心出发向两边扩张，一边判断一边统计
 * 回文中心有两种，数字以及两个数字中间
 * [1,2,3]  1,2,3 以及[12]中间 [23]中间
 */

public class 回文子串 {
    public int countSubstrings(String s) {
        if(s==null||s.length()<1){
            return 0;
        }
        int totalCount=0;
        //1.以数字为中心
        for(int i=0;i<s.length();i++){
            int left=i;
            int right=i;
            while (left>=0&&right<s.length()){
                if(s.charAt(left)==s.charAt(right)){
                    totalCount++;
                    left--;
                    right++;
                }else {
                    break;
                }
            }
        }
        //以空隙为中心 i为左边，i+1为右边
        if(s.length()>=2) { //至少两个才有空隙
            for (int i = 0; i < s.length() - 1; i++) {
                int left=i;
                int right=i+1;
                while (left>=0&&right<s.length()){
                    if(s.charAt(left)==s.charAt(right)){
                        totalCount++;
                        left--;
                        right++;
                    }else {
                        break;
                    }
                }

            }
        }
        return totalCount;
    }
}
