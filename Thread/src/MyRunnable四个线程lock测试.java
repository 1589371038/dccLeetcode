import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * moon
 */

public class MyRunnable四个线程lock测试 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();
        Condition condition4 = lock.newCondition();
        MyRunnable四个线程lock.setLock(lock);
        MyRunnable四个线程lock.setCondition1(condition1);
        MyRunnable四个线程lock.setCondition2(condition2);
        MyRunnable四个线程lock.setCondition3(condition3);
        MyRunnable四个线程lock.setCondition4(condition4);
        MyRunnable四个线程lock r1=new MyRunnable四个线程lock(0);
        MyRunnable四个线程lock r2=new MyRunnable四个线程lock(1);
        MyRunnable四个线程lock r3=new MyRunnable四个线程lock(2);
        MyRunnable四个线程lock r4=new MyRunnable四个线程lock(3);
        Thread t1=new Thread(r1);
        Thread t2=new Thread(r2);
        Thread t3=new Thread(r3);
        Thread t4=new Thread(r4);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
