//14. 最长公共前缀
//编写一个函数来查找字符串数组中的最长公共前缀。
//
//如果不存在公共前缀，返回空字符串 ""。
public class LonggestPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length<1){
            return "";
        }
        //先找到最小串的长度
        int minLength=strs[0].length();
        for(int i=1;i<strs.length;i++){
            minLength=Math.min(minLength,strs[i].length());
        }
        String result ="";
         for(int i=0;i<minLength;i++){
             char theChar=strs[0].charAt(i);
             for(int j=1;j<strs.length;j++){
                 if(strs[j].charAt(i)!=theChar){
                     return strs[0].substring(0,i);
                 }
             }
         }
         return strs[0].substring(0,minLength);
    }
}
