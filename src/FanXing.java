public class FanXing<R,T> {
    private R result;
    private T canshu;
    public FanXing(R r,T t){
        this.result=r;
        this.canshu=t;
    }
    public R method(T t){
        return result;
    }
}
