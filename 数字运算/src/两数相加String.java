/**
 * moon
 */

public class 两数相加String {
    public static String add(String num1, String num2){
        int i = num1.length()-1;
        int j = num2.length()-1;
        StringBuilder res = new StringBuilder();
        int carry = 0;
        while (i>=0 || j>=0 ||carry>0){
            int sum = (i>=0?(num1.charAt(i)-'0'):0) +  (j>=0?(num2.charAt(j)-'0'):0) + carry;
            res.append(sum%10);
            carry = sum/10;
            i--;
            j--;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String add = add("923", "459");
        System.out.println(add);
    }
}
