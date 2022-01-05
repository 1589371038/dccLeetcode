import java.util.*;

public class KaoShi5 {
    int sum=0;
    public int translateNum (int num) {
        if(num<=0){
            return sum;
        }
        // write code here
        deepth(num+"",0);
        return sum;
    }

    private void deepth(String num, int index) {
        if(index==num.length()-1||index==num.length()){
            sum++;
            return;
        }
        if(num.charAt(index)>'2'||(num.charAt(index)=='2'&&num.charAt(index+1)>'5')){
            deepth(num,index+2);
        }
        else {
            deepth(num,index+1);
            deepth(num,index+2);
        }
    }
}
