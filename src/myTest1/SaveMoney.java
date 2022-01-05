package myTest1;

public class SaveMoney {
    public static void main(String[] args) {
        accountThread accountThread=new accountThread();
        Thread t1=new Thread(accountThread);
        Thread t2=new Thread(accountThread);
        t1.start();
        t2.start();
    }


}
class accountThread implements Runnable{
    private int account=0;
    @Override
    public void run() {
        for(int i=0;i<3;i++){
            synchronized (accountThread.class){
                account=account+1000;
                System.out.println(Thread.currentThread().getName()+"存了1000元钱，现在有"+account+"元");
            }

        }
    }
}
