//不用Integer.parseInt将字符串转换为整数，要考虑超过Integer.MAxvalue问题
//先判断位数
public class StringToInteger {
    public int stringToInteger(String s){
        if(s==null||s.length()<1){
            throw new RuntimeException("未输入值");
        }
        if(s.length()>10){
            throw new RuntimeException("输入的int超长了");
        }
        long result=0;
        long wei=1;
        for(int i=s.length()-1;i>=0;i--){
            result+=(s.charAt(i)-48)*wei;
            wei*=10;
        }
        if(result>Integer.MAX_VALUE){
            throw new RuntimeException("输入的int超长了");
        }
        else return (int)result;
    }
}
