import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * moon 成功
 */

public class 三个线程交替打印lockCondition实现 {
    private static Lock lock = new ReentrantLock();
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();
    private static Condition condition3 = lock.newCondition();
    private static volatile int flag = 1;
    public static void main(String[] args) {
       Thread threadA = new Thread(){
           @Override
           public void run() {
               for(int i=0;i<10;i++){
                   try {
                       lock.lock();
                       while (flag!=1){ //没轮到自己就condition1.await();
                           try {
                               condition1.await();
                           } catch (InterruptedException e) {
                               e.printStackTrace();
                           }
                       }
                       //如果轮到自己则输出
                       System.out.println("A");
                       flag=2;
                       condition2.signalAll(); //执行完了则呼唤2线程
                   } finally {
                       lock.unlock();
                   }

               }
           }
       };
       Thread threadb = new Thread(){
           @Override
           public void run() {
               for(int i=0;i<10;i++){
                   try {
                       lock.lock();
                       while (flag!=2){ //没轮到自己就condition1.await();
                           try {
                               condition2.await();
                           } catch (InterruptedException e) {
                               e.printStackTrace();
                           }
                       }
                       //如果轮到自己则输出
                       System.out.println("B");
                       flag=3;
                       condition3.signalAll(); //执行完了则呼唤2线程
                   } finally {
                       lock.unlock();
                   }

               }
           }
       };
       Thread threadc = new Thread(){
           @Override
           public void run() {
               for(int i=0;i<10;i++){
                   try {
                       lock.lock();
                       while (flag!=3){ //没轮到自己就condition1.await();
                           try {
                               condition3.await();
                           } catch (InterruptedException e) {
                               e.printStackTrace();
                           }
                       }
                       //如果轮到自己则输出
                       System.out.println("C");
                       flag=1;
                       condition1.signalAll(); //执行完了则呼唤2线程
                   } finally {
                       lock.unlock();
                   }

               }
           }
       };

       threadA.start();
       threadb.start();
       threadc.start();
    }

}
