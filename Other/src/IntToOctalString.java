//int转八进制
public class IntToOctalString {
    public String intToOctal(int num){
        StringBuilder sb=new StringBuilder();
        while(num!=0){
           int yu=num%8;
            num/=8;
            sb.append(String.valueOf(yu));
        }
        String result=sb.reverse().toString();

        return result;
    }
}
