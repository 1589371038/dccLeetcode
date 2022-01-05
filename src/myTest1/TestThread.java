package myTest1;

public class TestThread {


    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder("hahaha");
        ThreadQ tq=new ThreadQ(sb);
        ThreadW tw=new ThreadW(sb);
        tq.start();
        tw.start();
    }
}
class ThreadQ extends Thread{
    final StringBuilder sb;
    public ThreadQ(StringBuilder sb){
        this.sb=sb;
    }
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            synchronized (sb){
            sb.notify();
            System.out.println(Thread.currentThread().getName()+sb);
            try {
                sb.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }}


    }
}
class ThreadW extends Thread{
    final StringBuilder sb;
    public ThreadW(StringBuilder sb){
        this.sb=sb;
    }
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            synchronized (sb){
                sb.notify();
                System.out.println(Thread.currentThread().getName()+sb);
                try {
                    sb.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
