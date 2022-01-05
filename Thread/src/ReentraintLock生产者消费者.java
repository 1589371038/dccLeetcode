import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * moon
 */

public class ReentraintLock生产者消费者 {
    ReentrantLock lock = new ReentrantLock();
    Condition con1 = lock.newCondition();
    Condition con2 = lock.newCondition();
    List<String> list = new ArrayList<>();

    void pro(){
        while(true){
            try {
                lock.lock();
                while(list.size()==10){
                    con2.signal();
                    con1.await();
                }
                list.add("a");
                System.out.println(Thread.currentThread().getName()+" add:"+list.size());
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }
    }

    void cus(){
        while(true){

            try {
                lock.lock();
                System.out.println(lock.getWaitQueueLength(con1));
                while(list.size()==0){
                    con1.signal();
                    con2.await();
                }
                list.remove(0);
                System.out.println(Thread.currentThread().getName()+" rem:"+list.size());
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }
    }

    public static void main(String[] args) throws Exception {
        ReentraintLock生产者消费者 r = new ReentraintLock生产者消费者();
        new Thread(r::pro).start();
        new Thread(r::pro).start();
        new Thread(r::pro).start();
        new Thread(r::pro).start();
        new Thread(r::pro).start();
        new Thread(r::cus).start();
        new Thread(r::cus).start();
        new Thread(r::cus).start();
        new Thread(r::cus).start();
        new Thread(r::cus).start();
    }
}
