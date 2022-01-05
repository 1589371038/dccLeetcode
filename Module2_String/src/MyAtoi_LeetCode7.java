//8. 字符串转换整数 (atoi)
//请你来实现一个 atoi 函数，使其能将字符串转换成整数。
public class MyAtoi_LeetCode7 {
    public int myAtoi(String str) {
        if(str==null){
            return 0;
        }
       str = str.trim();
       if(str.length()<1){
           return 0;
       }
       String sign="";
       char firstChar=str.charAt(0);
       if(firstChar=='+'){
            sign="";  //如果是正数
           str=str.substring(1); //去掉符号
       }
       else if(firstChar=='-'){
            sign="-";//如果是负数
           str=str.substring(1); //去掉符号
       }
       else if(firstChar>=48&&firstChar<=57){ //如果是数字
            sign="";  //如果是数字
        }
       else {
           return 0;  //如果第一个字符不合适
       }
       int endPoint=0;
       for(endPoint=0;endPoint<str.length();endPoint++){
           if(str.charAt(endPoint)<48||str.charAt(endPoint)>57){
              break;
           }

       }
       if(endPoint==0){ //就怕加减号后面不是数字
           return 0;
       }
       str=str.substring(0,endPoint);
        //去掉首位的0
        while(str.startsWith("0")){
            str=str.substring(1);
        }
        if(str.length()<1){
            return 0;
        }
       if(str.length()>10){ //长度溢出
           if(sign=="-"){
               return Integer.MIN_VALUE;
           }
           else return Integer.MAX_VALUE;
       }
       else  if(Long.parseLong(str)>Integer.MAX_VALUE){
           if(sign=="-"){
               return Integer.MIN_VALUE;
           }
           else return Integer.MAX_VALUE;
       }
       else {  //在int范围内时
           str=sign+str;
           return Integer.parseInt(str);

       }


    }
}
