package myTest2;

public interface FXInterface2<M,Q> {
    String s="123";
    public abstract void haha(M t);
    public abstract void haha2(Q e);
    public default void haha1(M t){
        System.out.println("haha1");
    }

}