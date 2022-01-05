/**
 * moon
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 思路1：
 * num2每一位和num1相乘，然后相加，记得num2每增加一位，结果*10*n
 */

public class 字符串相乘 {
    public static String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        int zeros=0;
        String result = "0";
        for(int i=num2.length()-1;i>=0;i--){
            char c = num2.charAt(i);
            StringBuilder multi = multiplyMe(c,num1);
            for(int j=0;j<zeros;j++){
                multi.append("0");
            }
            zeros++;
            result= addMe(result,multi.toString());
        }
        return result;

    }
//字符串和字符串相加
    private static String addMe(String s1, String s2) {
        int i=s1.length()-1;
        int j=s2.length()-1;
        StringBuilder result = new StringBuilder();
        int carry=0;
        while (i>=0||j>=0||carry>0){
            if(i>=0){
                carry+=s1.charAt(i)-'0';
            }
            if(j>=0){
                carry+=s2.charAt(j)-'0';
            }
            result.append(carry%10);
            carry=carry/10;
            i--;
            j--;
        }
        return result.reverse().toString();

    }

    //字符串和字符相乘
    private static StringBuilder multiplyMe(char c, String num1) {
        StringBuilder result = new StringBuilder();
        int n = c-'0';
        int carry=0;
        int index=num1.length()-1;
        while (index>=0||carry>0){
            int multi = carry;
            if(index>=0) {
                multi += n * (num1.charAt(index) - '0');
            }
            result.append(multi%10);
            carry=multi/10;
            index--;
        }
        return result.reverse();
    }

    public static void main(String[] args) {

        String multiply = multiply("2", "3");
        System.out.println(multiply);
    }
}
