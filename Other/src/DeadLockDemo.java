

public class DeadLockDemo extends Thread {

    private String lock1;
    private String lock2;

    public DeadLockDemo(String lock1, String lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + "获得资源: " + lock1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + "获得资源: " + lock2);
            }
        }
    }

    public static void main(String[] args) {
        String lock1 = "lock1";
        String lock2 = "lock2";
        new DeadLockDemo(lock1, lock2).start();
        new DeadLockDemo(lock2, lock1).start();
    }
}