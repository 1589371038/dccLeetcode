//快排  以左边为基点
public class QuickSort {
    //这个函数递归
    public void quicksort(int [] array,int left, int right){
        if(left<right){  //排除掉最后left>=right的
             int index =getIndex(array,left,  right); //index为一轮排序后基准值在的index
            quicksort(array,left,index-1);
            quicksort(array,index+1,right);
        }
    }

    private int getIndex(int[] array, int left, int right) {
        int tempt=array[left];                 //选一个基准值   如果选的不是left，将它和left交换，因为我们以left为起点
        while(left<right){
            while(left<right&&array[right]>=tempt){//从右边开始双指针
                right--;
            }  //循环完了，说明遇到右边的比temp小的了
            array[left]=array[right];
            while(left<right&&array[left]<=tempt){
                left++;
            }
            array[right]=array[left];
        } //循环之后，左边都小，右边都大
        array[left]=tempt;  //中间的值置回基准值
        return left;  //返回基准值位置
    }
}
