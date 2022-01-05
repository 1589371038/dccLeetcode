package myTest1;

public class MyThread extends Thread{
    @Override
    public void run() {
        for(int i=0;i<=100;i=i+2){
            System.out.print(i+"\t");
        }
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyThread m1=new MyThread();
        m1.start();
        for(int i=1;i<=100;i=i+2){
            System.out.print(i+"\t"+"main");
        }
        new Thread(() -> {
            for(int i=1;i<=100;i=i+2){
                System.out.print(i+"\t"+"匿名");
            }
        }).start();
        System.out.println(Thread.currentThread().getName());
        System.out.println(m1.getName());
        m1.setName("狗屎线程");
        System.out.println(m1.getName());

    }
}
