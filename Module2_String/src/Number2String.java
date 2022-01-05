/**
 * 273. 整数转换英文表示
 * 将非负整数 num 转换为其对应的英文表示。
 * 将非负整数 num 转换为其对应的英文表示。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：num = 123
 * 输出："One Hundred Twenty Three"
 * 示例 2：
 *
 * 输入：num = 12345
 * 输出："Twelve Thousand Three Hundred Forty Five"
 * 示例 3：
 *
 * 输入：num = 1234567
 * 输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 示例 4：
 *
 * 输入：num = 1234567891
 * 输出："One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-english-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Number2String {
    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }
        return numberToWordsRecursion(num, 0 , "");
    }
    public String numberToWordsRecursion(int num, int multi, String result) {
        if (num == 0){
            return result;
        }
        String wei = "";
        switch (multi){
            case 0 :
                wei = ""; break;
            case 1:
                wei = "Thousand"; break;
            case 2:
                wei = "Million"; break;
            case 3:
                wei = "Billion"; break;
        }
        String thisNum = String.valueOf(num %1000);
        String thisResult = bit3Transform(thisNum);
        if (multi != 0){
        thisResult = thisResult + " ";
        }
        thisResult = thisResult + wei;
        if(multi != 0){
            thisResult = thisResult + " ";
        }
        result = thisResult + result;
        return numberToWordsRecursion(num/1000,multi+1, result);

    }

    public static void main(String[] args) {
        Number2String number2String = new Number2String();
      //  System.out.println(number2String.bit3Transform("12"));
        System.out.println(number2String.numberToWordsRecursion(100, 0 , ""));
        System.out.println(number2String.numberToWordsRecursion(20, 0 , ""));
    }
    public String bit3Transform (String num){
        String s ="";
        if(num.length() >= 3){ //百位
            s = s + soloTransform(String.valueOf(num.charAt(0)))+" "+"Hundred"; //如果是100 后面hundred
            if(!num.substring(num.length()-2) .equals("00") ){
                s = s + " ";
            }
        }
        if(num.length() >= 2){ //十位
            if(num.charAt(num.length()-2) == '1'){ //10-19
                s = s + decadeTransform2(num.substring(num.length()-2));
                return s;
            }else { //20-99 00-09
                String one = soloTransform(num.substring(num.length()-1,num.length()));
                s = s + decadeTransform1(num.substring(num.length()-2,num.length()-1));
                int flag = 0;
                if (decadeTransform1(num.substring(num.length()-2,num.length()-1)) != ""){
                    s = s + " ";
                    flag =1;

                }
                if (one !=""){
                    s = s  + one;
                }else if(flag == 1)s = s.substring(0, s.length()-1);

            }
        }
        if(num.length() == 1){
            s = s + soloTransform(num);
        }
        return s;
    }
    public String soloTransform(String num){
        switch (num){
            case "1":
                return "One";
            case "2":
                return "Two";
            case "3":
                return "Three";
            case "4":
                return "Four";
            case "5":
                return "Five";
            case "6":
                return "Six";
            case "7":
                return "Seven";
            case "8":
                return "Eight";
            case "9":
                return "Nine";
            default: return "";
        }
    }
    // 十位,2-9
    public String decadeTransform1(String num){
        switch (num){
            case "2":
                return "Twenty";
            case "3":
                return "Thirty";
            case "4":
                return "Forty";
            case "5":
                return "Fifty";
            case "6":
                return "Sixty";
            case "7":
                return "Seventy";
            case "8":
                return "Eighty";
            case "9":
                return "Ninety";
            default: return "";
        }
    }
    // 十位,10-19
    public String decadeTransform2(String num){
        switch (num){
            case "10":
                return "Ten";
            case "11":
                return "Eleven";
            case "12":
                return "Twelve";
            case "13":
                return "Thirteen";
            case "14":
                return "Fourteen";
            case "15":
                return "Fifteen";
            case "16":
                return "Sixteen";
            case "17":
                return "Seventeen";
            case "18":
                return "Eighteen";
            case "19":
                return "Nineteen";
            default: return "";
        }
    }
}
