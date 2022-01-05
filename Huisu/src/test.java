public class test {
    public static void main(String[] args) {
        Matrix_findWord mf=new Matrix_findWord();
        char[][] board={ {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}};
       boolean result= mf.exist(board,"SEA");
        System.out.println(result);
    }
}
