/**
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 思路2： len1和len2相乘，结果的长度在len1+len2-1到len1+len2之间
 *        每一位相乘，最多是两位数，
 *        i位置和j位置相乘，小位在i+j+1 大位落在i+j
 *        初始化一个int[len1+len2]统计每一位的数据  然后倒序计算真正的每一位数据(取余)
 */

public class 字符串相乘2 {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        int[] tempMulti = new int[num1.length()+num2.length()];
        for(int i=num1.length()-1;i>=0;i--){
            for(int j=num2.length()-1;j>=0;j--){
                tempMulti[i+j+1]=tempMulti[i+j+1]+(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i=tempMulti.length-1;i>=0;i--){
            if(i==0&&tempMulti[0]==0){ //如果最高位是0就不加
                break;
            }
            result.append(tempMulti[i]%10);
            if(i>0) {
                tempMulti[i - 1] += tempMulti[i] / 10;
            }
        }
        String s = result.reverse().toString();
        return s;
    }
}
