public class 最多删除一个字符得到回文 {
    public boolean validPalindrome(String s) {
        if(s == null ||s.equals("")){
            return true;
        }
        return judge(s, 0, s.length()-1, true);
    }

    private boolean judge(String s, int i, int j, boolean oneChance) {
        while (i < j){
            if (s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else {
                if(oneChance){ // 有一次机会则删除两边
                    return judge(s, i+1, j, false) || judge(s, i, j-1, false);
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
