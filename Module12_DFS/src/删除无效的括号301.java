import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * moon
 * 301. 删除无效的括号
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 *
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 * 输入：s = "()())()"
 * 输出：["(())()","()()()"]
 *
 *
 * 经典的dfs：
 * 为什么不用回溯：其实可以回溯，但是String结构太简单了，没必要，直接带到下一层参数就行了
 * dfs的顺序是按照String的index顺序，每一步都做出选择：是否保留这个字符！然后走到下一步
 * 注意要点：
 * 1.用set记录结果集，用maxLen记录最长的有效括号的长度
 * 终结条件：1.走到最后一步，如果走到最后一步，看结果的长度，如果和maxLen一样长，放入set，如果>n=maxLen 刷新maxLen，消除之前的set的结果
 * 计算maxOfBrackets 为min(左括号，右括号)
 * 剪枝： 左括号不能超过maxOfBrackets， 右括号不能超过左括号数量
 *
 * 选择：左括号：若满足条件则可选可不选，若超了只能不选
 *       右括号：若满足条件则可选可不选，若超了只能不选
 *       字母：无脑选
 */

public class 删除无效的括号301 {
    Set<String> results = new HashSet<>();
    int maxLen = 0;// 字符串的最大长度初定为0
    int maxOfBrackets;
    public List<String> removeInvalidParentheses(String s) {
        int l = 0;
        int r = 0;
        for(char c : s.toCharArray()){
            if(c=='('){
                l++;
            }
            if(c==')'){
                r++;
            }
        }
        maxOfBrackets = Math.min(l,r);
        dfs(0, "", s, 0, 0);
        return new ArrayList<>(results);
    }

    private void dfs(int index, String sNow, String s, int numL, int numR) {
        if(numL>maxOfBrackets){ // 剪枝（的限制
            return;
        }
        if(numR>numL){ // 剪枝）的限制
            return;
        }
        if(index==s.length()){ // 终点
            if(numL==numR){ // 合法的括号
                if(sNow.length()>maxLen){ // 刷新记录了，之前的清空
                    results.clear();
                    results.add(sNow);
                    maxLen = sNow.length();
                }else if(sNow.length()==maxLen){
                    results.add(sNow);
                }
            }
            return;
        }
        // 如果index没到终点，就要做选择了
        char c = s.charAt(index);
        if(c=='('){ // 可选可不选
            dfs(index+1, sNow+'(',s,numL+1,numR);
            dfs(index+1, sNow,s,numL,numR);
        }else if(c == ')'){ // 可选可不选
            dfs(index+1, sNow+')',s,numL,numR+1);
            dfs(index+1, sNow,s,numL,numR);
        }else { // 字母随便加
            dfs(index+1,sNow+c,s,numL,numR);
        }
    }
}
