import java.util.Scanner; public class day01 {  public static void main(String[] args){
    System.out.print("请输入值：");
    Scanner s = new Scanner(System.in);
    while(s.hasNextLine()){
        String a = s.nextLine(); //将s.next()赋值给变量a
         if("/n".equals(a)){
             break;
         }else
             {     System.out.println(a);
             }     }  } }