package myTest1;

public class SellTicket {


    public static void main(String[] args) {
        ThreadTicket t1=new ThreadTicket("A线程");
        t1.setPriority(4);
        t1.start();
        ThreadTicket t2=new ThreadTicket("B线程");
        t1.setPriority(8);
        t2.start();
    }

}
class ThreadTicket extends Thread{
    private volatile static int ticketNum=100;
    public ThreadTicket(String name){
        super(name);
    }
    @Override
     public void run() {
        while (true){
            synchronized (Thread.class){
                if(ticketNum>0){
                    System.out.println(getName()+"正在售卖第"+ticketNum+"张票");
                    ticketNum--;
                }else {break;}
            }



        }
    }
}
