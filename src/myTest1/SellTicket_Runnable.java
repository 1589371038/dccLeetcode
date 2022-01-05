package myTest1;

public class SellTicket_Runnable {
    public static void main(String[] args) {
        MyRunnable myRunnable1=new MyRunnable();
        Thread t1=new Thread(myRunnable1);
        t1.start();
        Thread t2=new Thread(myRunnable1);
        t2.start();
        Thread t3=new Thread(myRunnable1);
        t3.start();
    }
}
