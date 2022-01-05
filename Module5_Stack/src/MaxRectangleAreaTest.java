public class MaxRectangleAreaTest {
    public static void main(String[] args) {
        MaxRectangleArea ma=new MaxRectangleArea();
        char[][] chars={{'1','0','0'},{'1','1','1'},{'1','1','1'},{'0','1','0'}};
        int result=ma.maximalRectangle(chars);
        System.out.println(result);
    }
}
