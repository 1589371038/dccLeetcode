package myTest1;

public class JiaoTiDaYin {
    public static void main(String[] args) {
        ThreadPrint tp=new ThreadPrint();
        Thread t1=new Thread(tp);
        Thread t2=new Thread(tp);
        t1.start();
        t2.start();
    }
}
 class ThreadPrint implements Runnable{
    private int num=0;
     @Override
     public void run() {
         while (true){
             synchronized (this) {
                 this.notify();
                 if(num<=100){
                     System.out.println(Thread.currentThread().getName()+"---"+num);
                     num++;
                 }else break;
                 try {
                     this.wait();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         }

     }
 }

