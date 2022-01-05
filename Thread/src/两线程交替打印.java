/**
 * moon
 */

public class 两线程交替打印 {

    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread t1 = new Thread(runnable, "线程1");
        Thread t2 = new Thread(runnable, "线程2");
        t1.start();
        t2.start();
    }
}

class MyRunnable implements Runnable {
    int i = 1;

    @Override
    public void run() {
        while (true) { //轮询
            synchronized (this) {
                this.notify();//获取锁后，唤醒另一个线程
                try {
                    Thread.sleep(500); //延迟一下，交替打印好看一点
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i <= 100) { //小于100就打印
                    System.out.println(Thread.currentThread().getName() + "---" + i);
                    i++;
                    try {
                        wait(); //输出完了释放锁,给另一个线程
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;//停止循环
                }
            }
        }
    }
}