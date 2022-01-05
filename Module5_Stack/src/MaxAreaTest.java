public class MaxAreaTest {
    public static void main(String[] args) {
        int [] a=new int[]{1,2,3,4,6,5};
        MaxArea ma=new MaxArea();
        int result=ma.largestRectangleArea(a);
        System.out.println(result);
    }
}
