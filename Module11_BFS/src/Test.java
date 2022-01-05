

public class Test {
    public static void main(String[] args) {
        Island_200 is=new Island_200();
        char [][] chars={{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        char [][] chars1={{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        int i = is.numIslands(chars1);
        System.out.println(i);

    }
}
