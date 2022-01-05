import java.util.Scanner;

public class Match_String_kmp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        int[] next=getNext(s2);
        int result=kmpMatch(s1,s2,next);
        System.out.println(result);
    }
    public static int kmpMatch(String s1,String s2,int[] next){
if(s2.length()>s1.length()){
    return -1;
}
int i=0,j=0;
while(i<s1.length()&&j<s2.length()){
    if(s1.charAt(i)==s2.charAt(j)){
       i++;j++;
    }
    else{ //如果匹配失败
        if(j==0){  //如果失配的为s2的第一个（j=0）则next[j-1]取不到，直接i++
            i++;
        }
        else if(next[j-1]==0){//如果没有部分匹配  则i从i, j从0(从头开始匹配)
       j=0;}
       else{//如果有部分匹配   则i依旧从i,j从匹配好的index 也就是next[j-1]
           j=next[j-1];
    }
    }
}
if(j==s2.length()){
    return i-j;
}
else{
    return -1;
}

    }
    public static int[] getNext(String s){ //next为部分值匹配表
        int[] next=new int[s.length()];
        int matchIndex=0;       //matchIndex是匹配成功的指数
        for(int i=1;i<next.length;i++){  //0位置位0，从第二个数开始匹配，匹配的位置为matchIndex
            if(s.charAt(i)==s.charAt(matchIndex)){
                next[i]=++matchIndex;        //匹配成功,matchindex+1
            }
            else{
                matchIndex=0;   //失败则从头开始匹配，
                if(s.charAt(i)==s.charAt(matchIndex)){
                    matchIndex++;
                    next[i]=1;
                }
                 else      //再失败就next[i]=0
                next[i]=0;
            }
        }
        return next;
    }
}
