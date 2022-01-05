//三个线程交替打印1-100，共享数据为次数nums和flag
public class JiaoTiDaYin2 {
    public static void main(String[] args) {
        Integer nums=0;
        Integer flag=1;
        MThread1 m1=new MThread1();
        m1.setNums(nums);
        m1.setFlag(flag);
        Thread t1=new Thread(m1);
        MThread2 m2=new MThread2();
        m2.setNums(nums);
        m2.setFlag(flag);
        Thread t2=new Thread(m2);
        MThread3 m3=new MThread3();
        m3.setNums(nums);
        m3.setFlag(flag);
        Thread t3=new Thread(m3);
        t1.start();
        t2.start();
        t3.start();
    }

}

class MThread1 implements Runnable{
    private Integer nums;//多个多线程类共享数据，只能对外暴露一个接口。set引入一个共享的integer
    private Integer flag;

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        synchronized (Thread.class){
        while (true){
                if(nums<=100){
                    if(flag==1){ //到你了你就打印
                        System.out.println(Thread.currentThread().getName()+"--"+nums);
                        nums++;
                        flag=2;
                        Thread.class.notifyAll();
                    }
                    try {
                        Thread.class.wait(); //不论是否打印，都要wait并且唤醒其他线程

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else {
                    break;
                }
            }

        }
    }
}

class MThread2 implements Runnable{
    private Integer nums;//多个多线程类共享数据，只能对外暴露一个接口。set引入一个共享的integer
    private Integer flag;

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        synchronized (Thread.class){
        while (true){
                if(nums<=100){
                    if(flag==2){
                        System.out.println(Thread.currentThread().getName()+"--"+nums);
                        nums++;
                        flag=3;
                        Thread.class.notifyAll();
                    }
                    try {
                        Thread.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else {
                    break;
                }
            }

        }
    }
}

class MThread3 implements Runnable{
    private Integer nums;//多个多线程类共享数据，只能对外暴露一个接口。set引入一个共享的integer
    private Integer flag;

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        synchronized (Thread.class){
        while (true){
                if(nums<=100){
                    if(flag==3){
                        System.out.println(Thread.currentThread().getName()+"--"+nums);
                        nums++;
                        flag=1;
                        Thread.class.notifyAll();
                    }
                    try {
                        Thread.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else {
                    break;
                }
            }

        }
    }
}
