package myTest2;

public interface FXInterface1<T,E> {
    String s="123";
    public abstract void haha(T t);
    public abstract void haha2(E e);
    public default void haha1(T t){
        System.out.println("haha1");
    }

}
