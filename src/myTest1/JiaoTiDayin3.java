package myTest1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JiaoTiDayin3 {
    public static void main(String[] args) {
        Func func=new Func();
        ThreadA threadA=new ThreadA(func);
        ThreadB threadB=new ThreadB(func);
        ThreadC threadC=new ThreadC(func);
//        Thread t1=new Thread(threadA);
//        t1.start();
//        Thread t2=new Thread(threadB);
//        t2.start();
//        Thread t3=new Thread(threadC);
//        t3.start();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(threadA);
        executorService.submit(threadB);
        executorService.submit(threadC);
    }
}
class Func{
    int num=0;
    int flag=1;
    public synchronized void printA() throws InterruptedException {
        while (true){
            Thread.sleep(100);
            if(flag==1){
                System.out.println(Thread.currentThread().getName()+"--"+num);
                num++;
                flag=2;
                notifyAll();
            }
            wait();
        }
    }
    public synchronized void printB() throws InterruptedException {
        while (true){
            Thread.sleep(100);
            if(flag==2){
                System.out.println(Thread.currentThread().getName()+"--"+num);
                num++;
                flag=3;
                notifyAll();
            }
            wait();
        }
    }
    public synchronized void printC() throws InterruptedException {
        while (true){
            Thread.sleep(100);
            if(flag==3){
                System.out.println(Thread.currentThread().getName()+"--"+num);
                num++;
                flag=1;
                notifyAll();
            }
            wait();
        }
    }
}
class ThreadA implements Runnable{
    Func func;
    public ThreadA(Func func){
        this.func=func;
    }
    @Override
    public void run() {
        try {
            func.printA();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class ThreadB implements Runnable{
    Func func;
    public ThreadB(Func func){
        this.func=func;
    }
    @Override
    public void run() {
        try {
            func.printB();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class ThreadC implements Runnable{
    Func func;
    public ThreadC(Func func){
        this.func=func;
    }
    @Override
    public void run() {
        try {
            func.printC();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
