public class ThreadTest {  //三个线程依次从1输出到100，核心是用volatile的flag和i
    private volatile int i=0;
    private volatile int flag=0;

    public  void gogogo() {
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());
        Thread thread3 = new Thread(new Thread3());
        thread1.start();
        thread2.start();
        thread3.start();
    }
    public class Thread1 implements Runnable{
        @Override
        public void run() {
            while (i<=100){
                if(flag==0){
                    System.out.println("t1"+"  "+i);
                    i++;
                    flag=1;
                }

            }
        }
    }
    public class Thread2 implements Runnable{
        @Override
        public void run() {
            while (i<=100){
                if(flag==1) {
                    System.out.println("t2" + "  " + i);
                    i++;
                    flag = 2;
                }
            }
        }
    }
    public class Thread3 implements Runnable{
        @Override
        public void run() {
            while (i<=100){
                if(flag==2) {
                    System.out.println("t3" + "  " + i);
                    i++;
                    flag = 0;
                }
            }
        }
    }
}
