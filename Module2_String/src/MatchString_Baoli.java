//判断String1是否包含String2, 若不包含，返回-1,包含，返回index
//暴力匹配
public class MatchString_Baoli {
    public static int violenceMatch(String s1,String s2){
        int len1=s1.length();
        int len2=s2.length();
        if(len2>len1){
            return -1;
        }
        char[] chars1=s1.toCharArray();
        char[]chars2=s2.toCharArray();
        int i=0;
        int j=0;
        while(i<len1&&j<len2){
            if(chars1[i]==chars2[j]){
                i++;j++;
            }
            else{
                i=i-j+1;
                j=0;

            }
        }
        if(j==len2){
            return i-j;
        }
        else return -1;
    }
}
