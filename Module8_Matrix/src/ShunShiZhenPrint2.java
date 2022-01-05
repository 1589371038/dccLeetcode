import java.util.ArrayList;
import java.util.List;

public class ShunShiZhenPrint2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (true) {
            for (int i = left; i <= right; ++i) ans.add(matrix[top][i]);
            if (++top > bottom) break;

            for (int i = top; i <= bottom; ++i) ans.add(matrix[i][right]);
            if (--right < left) break;

            for (int i = right; i >= left; --i) ans.add(matrix[bottom][i]);
            if (--bottom < top) break;

            for (int i = bottom; i >= top; --i) ans.add(matrix[i][left]);
            if (++left > right) break;
        }
        return ans;
    }

    //顺时针打印，四指针法
    public static List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> result =new ArrayList<>();
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while (true) {
            for (int i = left;i<=right; i++){
                result.add(matrix[top][i]);
            }
            top++;
            if(top>bottom) break;

            for(int i = top; i<=bottom; i++){
                result.add(matrix[i][right]);
            }
            right--;
            if(left>right) break;

            for(int i = right; i>=left; i--){
                result.add(matrix[bottom][i]);
            }
            bottom--;
            if(top>bottom) break;

            for(int i = bottom; i>=top; i-- ){
                result.add(matrix[i][left]);
            }
            left++;
            if(left>right) break;

        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> integers = spiralOrder1(matrix);
        System.out.println(integers);
    }

}
