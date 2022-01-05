//7. 整数反转
//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//
//示例 1:
//假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
// 请根据这个假设，如果反转后整数溢出那么就返回 0。
public class Reverse {
    public int reverse(int x) {
      String s=Integer.toString(x);
      String sign="";
      if(s.startsWith("-")){
          sign="-";
          s=s.substring(1);
      }
      String sReverse=stringReverse(s);
      if(Long.parseLong(sReverse)>Integer.MAX_VALUE){
          return 0;
      }
      sReverse=sign+sReverse;
      return Integer.parseInt(sReverse);
    }

    private String stringReverse(String s) {
        char[] chars = s.toCharArray();
        int start=0;
        int end=chars.length-1;
        while (start<end){
            char temp=chars[start];
            chars[start]=chars[end];
            chars[end]=temp;
            start++;
            end--;
        }
        return new String(chars);
    }
}
