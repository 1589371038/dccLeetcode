import java.util.Scanner;

public class KaoShi1{
    public String findMaxSubstr (String str) {
        String result=null;
        int left=0;int right=0;
        int maxLen=0;
        while(right<str.length()-1){
            while (right<str.length()-1&&!str.substring(left,right+1).contains(Character.toString(str.charAt(right+1)))){
                right++;
                if(right-left+1>maxLen){
                    maxLen=right-left+1;
                    result=str.substring(left,right+1);
                }
            }
            if(right<str.length()-1){
                left=left+str.substring(left,right+1).indexOf(str.charAt(right+1))+1;
                right= Math.max(right, left);
            }


        }
        return result;
    }


}