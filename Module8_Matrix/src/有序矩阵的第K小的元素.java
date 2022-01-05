/**
 * 378. 有序矩阵中第 K 小的元素
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 *
 * 思考：右下角是最大的，可以一个一个方形的右下角定位 no
 * 思考2：对于任何一个数字，可以用n的复杂度计算出小于等于此数字的数量，那找到count(a)<k<=count(a+1)  a+1就是答案了
 * count(a)表示小于等于a的数字的数量
 *
 * 细节1：count(min->max)  注意不是单纯的二分查找，而是找到最小的符合条件的一个
 * 还记得有个二分查找，找到第一个x嘛？ 比如11112223333444555666找到第一个3，则需要mid<=3时 right=mid, mid<3时left=mid+1
 * 这里一样的，因为数字可能不在矩阵中，比如矩阵中有数字6和9  count(6)=k 那么count7,8,都等于k count9>k,那么就要找出6
 * 细节2：这种找法，希望不能出现死循环, left=a right=a+1的时候，mid应该=a，因此mid=a+(b-a)>>1!
 *
 * 题解：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/er-fen-chao-ji-jian-dan-by-jacksu1024/
 */

public class 有序矩阵的第K小的元素 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length-1;
        int start = matrix[0][0];
        int end = matrix[n][n];
        while (start<end){
            int mid = start+((end-start)>>1);
            if(count(mid, matrix)>=k){
                end = mid;
            }else {
                start = mid+1;
            }
        }
        return start;

    }
//从左下角开始找
    private int count(int k, int[][]matrix) {
        int i=matrix.length-1;
        int j=0;
        int sum=0;
        while (i>=0&&j<matrix.length){
            if(matrix[i][j]<=k){
                sum+=i+1;
                j++;//下一列
            }else {
                i--;
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(-9/2+"--"+-9%2);
    }
}
