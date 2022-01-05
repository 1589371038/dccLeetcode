package myTest1;
//import myTest2.Circle ;


public class test {
    public static void main(String[] args) {
Account account=new Account(20,100,0.1);
Thread1 t1=new Thread1();
t1.setAccount(account);
Thread2 t2=new Thread2();
t2.setAccount(account);
t1.start();
t2.start();

    }

}
