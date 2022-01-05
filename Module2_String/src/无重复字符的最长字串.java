import java.util.HashMap;

public class 无重复字符的最长字串 {
    public static void main(String[] args) {
        String s="abcabcbb";
        int result=lengthOfLongestSubstring(s);
        System.out.println(result);
    }
    public static int lengthOfLongestSubstring(String s) {
  int len=s.length();
  StringBuilder sb=new StringBuilder();
  int indexStart=0;
  int maxLen=0;
  while(indexStart<len){
      int index=sb.lastIndexOf(String.valueOf(s.charAt(indexStart)));
      if(index==-1) {
          sb.append(s.charAt(indexStart));
      }
      else{
          sb.delete(0,index+1);
          sb.append(s.charAt(indexStart));
      }
      maxLen=Math.max(maxLen,sb.length());
      indexStart++;
  }
  return maxLen;
    }
    public int lengthOfLongestSubstring1(String s) {
        int maxLen=0;
        int left=0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))&&map.get(s.charAt(i))>=left){
                left = map.get(s.charAt(i))+1;
            }
            map.put(s.charAt(i),i);
            maxLen = Math.max(maxLen, i-left+1);
        }
        return maxLen;
    }
}
