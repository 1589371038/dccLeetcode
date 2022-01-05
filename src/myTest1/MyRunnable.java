package myTest1;

import java.util.concurrent.locks.ReentrantLock;

public class MyRunnable implements Runnable {
    private volatile int ticketNum=10;
    private ReentrantLock lock1=new ReentrantLock();
    @Override
    public  void run() {
        while (true){
                lock1.lock();
                if(ticketNum>0){
                    System.out.println(Thread.currentThread().getName()+"正在售卖第"+ticketNum+"张票");
                    ticketNum--;
                }else break;

                lock1.unlock();


        }
    }
}
