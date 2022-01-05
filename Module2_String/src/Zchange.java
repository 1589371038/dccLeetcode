//6. Z 字形变换
//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
public class Zchange {
    public String convert(String s, int numRows) {
        //先考虑特殊
        if(s==null||s.length()<=1||numRows==1){  //居然还有numRows==1我是没想到
            return s;
        }
        int len=numRows*2-2;
       int n=s.length()/(len);   //竖着的是numrows个，斜着的是numrows-2个
        int yu=s.length()%(len);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<numRows;i++){
            for(int j=0;j<n;j++){   //先拼n个凑整的
                int index11=j*len+i;  //竖着的index
                sb.append(s.charAt(index11));
                //斜着的index，需要先判断i不能是0和numsRows-1（斜着的比竖着小两个，才是z字）
                if(i!=0&&i!=numRows-1){
                    int index12=(j+1)*len-i;
                    sb.append(s.charAt(index12));
                }
            }
            //再拼余数,如果有余数需要
            if(yu>0){
                int index21=n*len+i; //竖着的index，需要判断是否越界
                if(index21<s.length()) {
                    sb.append(s.charAt(index21));
                }
                //斜着的index，需要先判断i不能是0和numsRows-1（斜着的比竖着小两个，才是z字）
                if(i!=0&&i!=numRows-1) {
                    int index22 = (n + 1) * len - i;
                    if(index22<s.length()) { //判断越界
                        sb.append(s.charAt(index22));
                    }
                }
                }
            }

        return  sb.toString();
    }
}
