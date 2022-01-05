/**
 * moon
 */

public class WaiNotify生产者消费者2 {
    public static final Object lock = new Object();
    public static volatile int stock = 0;
    static class Producer implements Runnable{
        @Override
        public void run(){
            while (true){
                try {
                    Thread.sleep(1000);
                    System.out.println("生产者歇一秒，生产队的驴都不带这么干的");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                synchronized (lock){
                    if(stock>10){ //超了就不生产了
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        stock++;
                        System.out.println("生产者生产一个商品，现在有"+stock);
                        lock.notifyAll();
                    }
                }
            }
        }
    }
    static class Consumer implements Runnable{

        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(1000);
                    System.out.println("消费者歇一秒，消费不动啦");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (lock){
                    if(stock<=0){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        stock--;
                        System.out.println("消费者消费一个商品，还剩下"+stock);
                        lock.notifyAll();
                    }
                }

            }

        }
    }
    public static void main(String[] args) {
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();


    }
}
