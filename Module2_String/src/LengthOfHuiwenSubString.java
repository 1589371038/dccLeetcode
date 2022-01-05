//计算最大回文子串
//从会问中心向两个方向延展
public class LengthOfHuiwenSubString {
    public String longestPalindrome(String s) {
            int n=s.length();
            int length=0;
            int maxLength=0;
            String result="";
            int left,right;
            for(int i=0;i<=2*n-1;i++){
                left=i/2;
                right=left+i%2;
                StringBuffer sbtemp=new StringBuffer();
                while(left>=0&&right<=n-1&&s.charAt(left)==s.charAt(right)){
                    if(left==right){
                        sbtemp.append(s.charAt(left));length++;
                    }
                    else{
                        sbtemp.append(s.charAt(right));
                        length++;
                        sbtemp.insert(0,s.charAt(left));
                        length++;
                    }

                    left--;
                    right++;
                }
                result=maxLength>length?result:sbtemp.toString();
                maxLength=maxLength>length?maxLength:length;
                sbtemp.delete(0,sbtemp.length());
                length=0;
            }
            return result;
        }
}
