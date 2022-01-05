package myTest1;

public class lanHan {
    private static lanHan l=null;
    private lanHan(){}
    public lanHan getLanHan(){
        if(l==null){
            synchronized (lanHan.class){
                if(l==null){
                    l=new lanHan();
                }
            }
        }
        return l;
    }
}
