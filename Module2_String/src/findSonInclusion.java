//567. 字符串的排列
//        给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
//
//        换句话说，第一个字符串的排列之一是第二个字符串的子串。
public class findSonInclusion {
    public boolean checkInclusion(String s1, String s2) {

        if(s1==null||s2==null||s1.length()>s2.length()){
            return  false;
        }
        if(s1.length()==0){
            return true;
        }
        char[] charS1=s1.toCharArray();
        char[] charS2=s2.toCharArray();
        int [] window=new int[26];
        int [] need=new int[26];
        for(char c:charS1){
            need[c-'a']++;
        }
        int left=0;
        int right=0;
        boolean result=false;
        while(right<s2.length()){
            int rightNum=charS2[right]-'a';
            window[rightNum]++;
            while(window[rightNum]>need[rightNum]){
                int leftNum=charS2[left]-'a';
                window[leftNum]--;
                left++;
            }
            if(right-left==s1.length()-1){
                return true;
            }
            right++;
        }
        return result;

    }
}
