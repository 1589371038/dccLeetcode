import java.util.*;

//56. 合并区间
//给出一个区间的集合，请合并所有重叠的区间。
//
//  intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
//思想：先对左端点排序，然后再按顺序merge,  每次只用拿新的数组对比前面已经好的最后一组来比
public class Merge {
    public static int[][] merge(int[][] intervals) {
        if(intervals==null){
            return null;
        }
        if(intervals.length<1){
            return new int[0][0];
        }
        int [][] result=new int[intervals.length][intervals[0].length];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int point=0;
        result[point][0]=intervals[0][0];  //result数组为合并后的，但是长度一样，记录当前长度为第point个
        result[point][1]=intervals[0][1];
        for(int i=0;i<intervals.length;i++){
          if(result[point][1]>=intervals[i][0]){
              result[point][1]=Math.max(result[point][1],intervals[i][1]);
          }
          else {
              point++;
              result[point][0]=intervals[i][0];
              result[point][1]=intervals[i][1];

          }
        }
        //从result中截取point数组
        int [][] newResult=new int[point+1][2];
        System.arraycopy(result,0,newResult,0,point+1);
        return newResult;
    }

    public static void main(String[] args) {
        int [][] array={{1,3},{2,6},{7,9}};
        int[][] merge = merge(array);
        System.out.println("a");
    }
    public int[][] merge1(int[][] intervals) {
    if(intervals == null){
        return null;
    }
    if(intervals .length == 0){
        return new int[0][0];
    }
    Arrays.sort(intervals, new Comparator<int []>(){ //按照第一个数字排序
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0]-o2[0];
        }
    });
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        for(int i = 1; i<intervals.length; i++){
            int [] toCompare = merged.get(merged.size()-1); //list里最新的一个数组
            //第一种情况，需要合并
            if(intervals[i][0] <= toCompare[1]){
                toCompare[1] = Math.max(toCompare[1],intervals[i][1]);  //更新右边端点
            }else {//第二种情况，不合并，新增
                merged.add(intervals[i]);
            }
         }
        int[][] result = merged.toArray(new int[merged.size()][]);
        return result;


    }

}
