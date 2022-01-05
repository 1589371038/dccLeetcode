public class ThreadTest2 {  //三个线程依次输出abc10次
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
        private  int n1=0;
        @Override
        public void run() {
            while (n1<=10){
                if(flag==0){
                    System.out.println("t1"+"  A");
                    n1++;
                    flag=1;
                }
            }
        }
    }
    public class Thread2 implements Runnable{
        private  int n2=0;
        @Override
        public void run() {
            while (n2<=10){
                if(flag==1){
                    System.out.println("t2"+"  B");
                    n2++;
                    flag=2;
                }
            }
        }
    }
    public class Thread3 implements Runnable{
        private  int n3=0;
        @Override
        public void run() {
            while (n3<=10){
                if(flag==2){
                    System.out.println("t3"+"  C");
                    n3++;
                    flag=0;
                }
            }
        }
    }
}
