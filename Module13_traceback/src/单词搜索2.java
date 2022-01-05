import java.util.*;

/**
 * 212. 单词搜索 II
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
 *
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 * 回溯嘛，和单词搜索1的区别在于需要搜索多个单词了，一个一个来呗，每次来了知乎，把标记的数组充值
 *
 *
 */

public class 单词搜索2 {
    public List<String> findWords(char[][] board, String[] words) {
    boolean [][] flag = new boolean[board.length][board[0].length];
    List<String> result = new ArrayList<>();
    Map<String,Boolean> resultMap = new HashMap<>(); //用于确定这个单词之前上搜索过
    for(int i = 0;i<words.length;i++){
        if(resultMap.containsKey(words[i])){
            if(resultMap.get(words[i])){ //如果有且为true
                result.add(words[i]);   //因为words单词太多，为了避免重复计算
            }
            continue;
        }
        if(find(board,words[i],flag)){
            result.add(words[i]);
           resultMap.put(words[i],true); //找到了是true
        }else {
            resultMap.put(words[i],false); //没找到是false
        }
        //每次搜索完单词重新清空flag
        for(int m=0;m<flag.length;m++){
            Arrays.fill(flag[m],false);
        }

    }
    return result;
    }
    public boolean find(char[][] board, String word, boolean[][] flag){
        for(int i=0;i<board.length;i++){//每个点都可能是起点
            for(int j=0;j<board[0].length;j++){
                if(jumpThisStep(board,i,j,word,0,flag)){
                    return true;
                }
            }
        }
        return false;
        }

    private boolean jumpThisStep(char[][] board, int i, int j, String word, int index, boolean[][] flag) {
        //走不了这一步的情况
        if(i<0||i>=board.length||j<0||j>=board[0].length||flag[i][j]||board[i][j]!=word.charAt(index)){
            return false;
        }
        //走这一步
        flag[i][j] = true;
        //如果是最后一步，就成功了
        if(index==word.length()-1){
            return true;
        }
        if(jumpThisStep(board,i-1,j,word,index+1,flag)||
                jumpThisStep(board,i+1,j,word,index+1,flag)||
                jumpThisStep(board,i,j-1,word,index+1,flag)||
                jumpThisStep(board,i,j+1,word,index+1,flag)){
            return true; //有一个方向成功了就成功了
        }
        flag[i][j] = false; //回溯
        return false;
    }
}
