/**
 * moon 成功
 */

public class MyRunnable四个线程Syn implements Runnable{
    private static int num = 0;
    private static Object lock = new Object(); //多个线程共有锁和计数
    private int flag;
    public MyRunnable四个线程Syn(int flag){ //flag线程私有，用于标记 0 1 2 3 当num%4=flag时输出，否则wait
        this.flag=flag;
    }
    @Override
    public void run() {
        while (true){
            if(num>100){
                break;
            }
            synchronized (lock){
                if(num%4==flag){
                    System.out.println(Thread.currentThread().getName()+"=="+num++);
                }else {
                    try{
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }
                lock.notifyAll();
            }
        }

    }
}
