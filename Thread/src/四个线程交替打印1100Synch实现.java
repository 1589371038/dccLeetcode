/**
 * moon 成功
 */

public class 四个线程交替打印1100Synch实现 {
    public static void main(String[] args) {
        MyRunnable四个线程Syn r1=new MyRunnable四个线程Syn(0);
        MyRunnable四个线程Syn r2=new MyRunnable四个线程Syn(1);
        MyRunnable四个线程Syn r3=new MyRunnable四个线程Syn(2);
        MyRunnable四个线程Syn r4=new MyRunnable四个线程Syn(3);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(r4);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
