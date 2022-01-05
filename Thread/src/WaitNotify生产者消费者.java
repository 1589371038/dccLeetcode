import java.util.ArrayList;
import java.util.List;

/**
 * moon  不加限制，消费者库存为0也能消费，生产者也没限制, 也就没有同步了，各干各的,谁抢到线程谁干活
 */

public class WaitNotify生产者消费者 {
    public static List<Integer> goods = new ArrayList<>(); //商品
    public static int max = 10; //最大库存数
    public static  int stock; //库存

    public static void main(String[] args) {
        Thread thread1=new Thread(new producer());
        thread1.start();
        Thread thread2=new Thread(new consumer());
        thread2.start();
    }
    static class consumer implements Runnable {

        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(500+(long)Math.random()*1000);
                } catch (InterruptedException e) {
                    System.out.println("消费者要休息一秒");
                }
                synchronized (goods){
                    while (stock<=0){
                        try {
                            System.out.println("没库存啦消费不了,消费者wait");
                            goods.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    stock--;
                    System.out.println("消费者消费了，还剩下"+stock+"商品");
                    goods.notifyAll();
                }


            }
        }
    }
   static class producer implements Runnable{
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(300+(long)Math.random()*1000);
                } catch (InterruptedException e) {
                    System.out.println("生产者要休息一秒");
                }
                synchronized (goods){
                    while (stock>max){
                        System.out.println("库存过多，生产者wait");
                        try {
                            goods.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    stock++;
                    System.out.println("生产者生产商品了，有"+stock+"个");
                    goods.notifyAll();
                }

            }
        }
    }

}