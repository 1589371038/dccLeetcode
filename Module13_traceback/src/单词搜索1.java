//79. 单词搜索
//给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
//单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
public class 单词搜索1 {
    public boolean exist(char[][] board, String word) {
        boolean[][] flag = new boolean[board.length][board[0].length]; //flag是地图，默认false可以走，走过了就标记为true
        // 后面失败了就回溯成false
        int k = 0;//从第0个单词开始匹配
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {   //以矩阵每一个字母为起点
                if (jumpThisStep(board, word, flag, i, j, k)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean jumpThisStep(char[][] board, String word, boolean[][] flag, int i, int j, int k) {
        //先判断这一步能不能走
        if ((i < 0 || i >= board.length) || (j < 0 || j >= board[0].length) || flag[i][j] || board[i][j] != word.charAt(k)) {
            return false;
        }
        //若没被淘汰，这一步可以走，标记为true,并且判断后续
        flag[i][j] = true;
        //若走完这一步，到了单词末尾，则true
        if (k == word.length() - 1) {
            return true;
        }
        //继续向上下左右突进，若有一个成了，就成了   k要加一，是下一个单词了
        if (jumpThisStep(board, word, flag, i + 1, j, k + 1) ||
                jumpThisStep(board, word, flag, i, j + 1, k + 1) ||
                jumpThisStep(board, word, flag, i - 1, j, k + 1) ||
                jumpThisStep(board, word, flag, i, j - 1, k + 1)
        ) {
            return true;
        } else {
            flag[i][j] = false;
            return false;
        }
        //成不了，得回溯
    }

    //2021.11.2.新写，刚入职携程，危机感很重
    //思路，递归加回溯，每走一步就判断这一步能不能走，如果不能(超过边界，已经走过，字符串不匹配)，returnfalse
    //如果能走 走这一步，记录flag[i][j] = true, 判断前后左右走下一步能不能成功，又有一个成功就成功，否则失败，撤回flag[i][j]=false;
    public boolean exist1(char[][] board, String word) {
        boolean[][] flag = new boolean[board.length][board[0].length];//
        int index = 0;//走word的指针
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (chooseThisStep(flag, i, j, board, word, index)) { //从每一个起点出发,有一个成了就成了
                    return true;
                }
            }
        }
        return false;

    }

    private boolean chooseThisStep(boolean[][] flag, int i, int j, char[][] board, String word, int index) {
        //能走？越界||走过||不匹配
        if (i < 0 || j < 0 || i > flag.length || j > flag[0].length || board[i][j] != word.charAt(index) || flag[i][j]) {
            return false;
        }
        flag[i][j] = true;//走
        if(index+1 == word.length()){
            return true;
        }
        //终止条件,走到最后一个单词
        if (chooseThisStep(flag, i - 1, j, board, word, index+1) ||
                chooseThisStep(flag, i + 1, j, board, word, index+1) ||
                chooseThisStep(flag, i, j - 1, board, word, index+1) ||
                chooseThisStep(flag, i, j + 1, board, word, index+1)) {
            return true;
        } else {
            flag[i][j] = false;
            return false;
        }
    }


}

