import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * moon  这个版本失败了！！
 */

public class MyRunnable四个线程lock implements Runnable{
    private static Lock lock;
    private static Condition condition1;



    private static Condition condition2;
    private static Condition condition3;
    private static Condition condition4;
    private static int num = 1;
    private int flag;
    public MyRunnable四个线程lock(int flag){
        this.flag=flag;
    }

    @Override
    public void run() {
       while (true){
           if(num>100){break;}
           try {
               lock.lock();
               if(num%4==flag){
                   System.out.println(Thread.currentThread().getName()+"---"+num++);
               }else {
                   switch (flag){
                       case 0:
                           try {
                               condition1.await();
                           } catch (InterruptedException e) {
                               e.printStackTrace();
                           }
                       case 1:
                           try {
                               condition2.await();
                           } catch (InterruptedException e) {
                               e.printStackTrace();
                           }
                       case 2:
                           try {
                               condition3.await();
                           } catch (InterruptedException e) {
                               e.printStackTrace();
                           }
                       case 3:
                           try {
                               condition4.await();
                           } catch (InterruptedException e) {
                               e.printStackTrace();
                           }
                   }
               }
               switch (flag){
                   case 0: condition2.signalAll(); break;
                   case 1: condition3.signalAll();break;
                   case 2: condition4.signalAll();break;
                   case 3: condition1.signalAll();break;

               }
           } catch (Exception e) {
               e.printStackTrace();
           } finally {
               lock.unlock();
           }


       }

    }
    public static void setLock(Lock lock) {
        MyRunnable四个线程lock.lock = lock;
    }

    public static void setCondition1(Condition condition1) {
        MyRunnable四个线程lock.condition1 = condition1;
    }

    public static void setCondition2(Condition condition2) {
        MyRunnable四个线程lock.condition2 = condition2;
    }

    public static void setCondition3(Condition condition3) {
        MyRunnable四个线程lock.condition3 = condition3;
    }

    public static void setCondition4(Condition condition4) {
        MyRunnable四个线程lock.condition4 = condition4;
    }
}
