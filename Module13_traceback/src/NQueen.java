//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
import java.util.ArrayList;
import java.util.List;

public class NQueen {
    List<List<String >> results=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        List<char[]> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<n;j++){
                sb.append(".");
            }
            list.add(sb.toString().toCharArray());

        }
        tracback(list,0);
        return results;

    }

    private void tracback(List<char[]> list, int row) {
        int n=list.size();
        if(row==list.size()){
            List<String> listNew=new ArrayList<>();
            for(char[] chars:list){
                listNew.add(new String(chars));
            }
            results.add(listNew);
        }
        for(int col=0;col<n;col++){
            if(!valid(list,row,col)){
                continue;
            }
            list.get(row)[col]='Q';
            tracback(list,row+1);
            list.get(row)[col]='.';
        }
    }

    private boolean valid(List<char[]> list, int row, int col) {
        int n=list.size();
        //排除同一列
        for(int i=0;i<row;i++){  //排除同一列
            if(list.get(i)[col]=='Q'){
                return  false;
            }
        }
        for(int i=row, j=col;i>=0&&j>=0;i--,j--){ //排除左上角
            if(list.get(i)[j]=='Q'){
                return false;
            }
        }
        for(int i=row, j=col;i>=0&&j<n;i--,j++){ //排除右上角
            if(list.get(i)[j]=='Q'){
                return false;
            }
        }
        return true;

    }
}
