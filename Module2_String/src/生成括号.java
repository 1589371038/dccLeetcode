import java.util.ArrayList;
import java.util.List;

/**
 * moon
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 有效括号组合需满足：左括号必须以正确的顺序闭合
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 思路：每次选择，可以选（）中的一个，但是有条件, (受限于库存  )受限于库存和（的数量< (必须多于)>
 *     可以回溯，也可以复制string
 */

public class 生成括号 {
    public static List<String> result = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {
    if(n<=0){
        return result;
    }
    deep("",0,0, n);
    return result;
    }

    private static void deep(String s, int numOfL, int numOfR, int n) {
        if(numOfL==n&&numOfR==n){
            result.add(s);
        }
        if(numOfL<n){
            deep(s+"(", numOfL+1,numOfR,n);
        }
        if(numOfR<n&&numOfL>numOfR){
            deep(s+")", numOfL,numOfR+1,n);
        }
    }

    public static void main(String[] args) {
        generateParenthesis(1);
    }
}
