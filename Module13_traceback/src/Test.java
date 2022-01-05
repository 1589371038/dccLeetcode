import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        //测试皇后
//        NQueen queen=new NQueen();
//        List<List<String>> lists = queen.solveNQueens(8);
//        System.out.println("haha");

        //测试零钱
//        零钱兑换2_518 s = new 零钱兑换2_518();
//        int [] array =new int[]{7};
//        System.out.println(s.change(0,array));

        //测试分割回文字符串
//        分割回文字符串131 s = new 分割回文字符串131();
//        List<List<String>> aab = s.partition("aab");
//        for(List<String> list :aab){
//            for(String s1:list){
//                System.out.print(s1+" ");
//            }
//            System.out.println(" ");
//        }
   单词拆分2_140 s = new 单词拆分2_140();
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pen");
        list.add("applepen");
        list.add("pine");
        list.add("pineapple");
   s.wordBreak("pineapplepenapple",list);

    }


}
