

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//22. 括号生成
public class AllPossilbleBrackets {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<String> arrayList=generateParenthesis1(n);
        System.out.println(arrayList.size());
    }
    public static List<String> generateParenthesis(int n) {
        ArrayList<String> arrayList=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        int left=n;
        int right=n;
        getbracktes(arrayList,sb,left,right);
        return arrayList;
    }

    private static void getbracktes(ArrayList<String> arrayList,StringBuilder sb, int left, int right) {
        if(left>right||left<0||right<0){
            return;
        }
        if(left==0&&right==0){
            arrayList.add(sb.toString());
            return;
        }
        sb.append("(");
        getbracktes(arrayList,sb,left-1,right);
        sb.deleteCharAt(sb.length()-1);
        sb.append(")");
        getbracktes(arrayList,sb,left,right-1);
        sb.deleteCharAt(sb.length()-1);
    }
//新写的 用回溯+dfs遍历
    public static List<String> generateParenthesis1(int n) {
        StringBuilder sb =new StringBuilder();
        List<String> result = new ArrayList<>();
        traceback(result, sb, n, n);
        return result;
     }

    private static void traceback(List<String> result, StringBuilder sb, int numLeft, int numRight) {
        if(numLeft==0&&numRight==0){
            result.add(sb.toString());
            return;
        }
        //无论什么时候左括号都能加,只要库存够
        if(numLeft>0){
            sb.append('(');
            traceback(result, sb, numLeft-1, numRight);
            sb.deleteCharAt(sb.length()-1);
        }
        //numleft<numRight的时候右括号才能加
        if(numRight>0&&numLeft<numRight){
            sb.append(')');
            traceback(result, sb, numLeft, numRight-1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
