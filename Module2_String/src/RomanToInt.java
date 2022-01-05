//13. 罗马数字转整数
//罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
public class RomanToInt {
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        char pre=chars[0];
        int sum=0;
        for(int i=1;i<chars.length;i++){
            if(value(chars[i])>value(pre)){
                sum-=value(pre);
            }
            else {
                sum+=value(pre);
            }
            pre=chars[i];
        }
        sum+=value(pre);
        return sum;

    }
    private  int value(char c){
        switch (c){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default: return 0;
        }

    }
}
