import java.util.List;

public class test {
    public static void main(String[] args) {
       Calculator c=new Calculator();
       // String[] postString= {"5","2","3","*","-","9","+"};
        String midString="5+2*(3*(3-1*2+1))";
        String[] postString=c.mid2PostString(midString);
      float result=c.calPost(postString);
        System.out.println(result);

    }
}
