import java.util.ArrayList;
import java.util.List;

/**
 * moon
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 皇后会攻击同一行同一列和同一斜线上的单位
 * <p>
 * 怎样更有效率地记录行和列是否被占用，依次决定能否走这一步呢？
 */

public class n皇后51 {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<char[]> qiPan = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(".");
        }
        for (int i = 0; i < n; i++) {
            qiPan.add(sb.toString().toCharArray());
        }
        //开始回溯
        traceback(qiPan, 0);
        return result;
    }

    private void traceback(List<char[]> qiPan, int row) {
        //终止条件 如果下棋下到超过最后一行说明完成了
        if (row == qiPan.size()) {
            List<String> successQipan = new ArrayList<>();
            for (char[] chars : qiPan) {
                successQipan.add(new String(chars));
            }
            result.add(successQipan);
        }
        for (int col = 0; col < qiPan.size(); col++) {
            if (judgeCanGo(qiPan, row, col)) { //遍历
                qiPan.get(row)[col] = 'Q';  //选择
                traceback(qiPan, row + 1);                      //进入下一层
                qiPan.get(row)[col] = '.';  //回溯
            }
        }
    }
//这种判断方式看上去很直观，但是用hash或者数组记录会更快
    private boolean judgeCanGo(List<char[]> qiPan, int row, int col) {
        int n = qiPan.size();
        //同一列有没有Q
        for (int i = 0; i < n; i++) {
            if (qiPan.get(i)[col] == 'Q') {
                return false;
            }
        }
        //左上是否有Q
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (qiPan.get(i)[j] == 'Q') {
                return false;
            }
        }
        //右上是否有Q
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (qiPan.get(i)[j] == 'Q') {
                return false;
            }
        }
        return true;
    }


}
