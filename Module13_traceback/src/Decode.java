//91. 解码方法
//一条包含字母 A-Z 的消息通过以下方式进行了编码：
//
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//回溯法  12可能为 12，  也能1,2，弄完后回溯
//但是27 只能27，  26可以26， 2,6
//好像只要递归，不需要回溯
public class Decode {
    int sum=0;
    public int numDecodings(String s) {
   boolean [] mark=new boolean[s.length()];
    traceback(s,mark,0); //从第一个字母开始回溯
        return sum;
    }

    private void traceback(String s, boolean[] mark, int i) {
        if(s==null||s=="0"){
            return;
        }
        //如果i到了最后一位，说明回溯完毕
        if(i==s.length()-1||i==s.length()){
            sum++;
        }
        else {
            if(s.charAt(i)>'3'||i==s.length()-1||(s.charAt(i)=='2'&&s.charAt(i+1)>'6'))  {  //不用拆分的情况  大于27/大于3/末尾
              //  mark[i]=true;
                traceback(s,mark,i+1); //不用拆分则不需要回溯
            }
            else { //需要拆分的情况
                //这种只能10，不能1,0
                if(s.charAt(i)=='1'&&s.charAt(i+1)=='0') {
                    traceback(s,mark,i+2);
                }
                else {
                    // mark[i]=true;  //逗号先放两数中间 1,2
                    traceback(s, mark, i + 1); //推进
                    // mark[i]=false;  //回溯
                    //  mark[i+1]=true;
                    traceback(s, mark, i + 2); //重新推进
                }

            }

        }
    }
}
