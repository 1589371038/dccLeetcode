package myTest1;
//多线程经典案例：生产者消费者模式，
public class Producer_Consumer_Test {
    public static void main(String[] args) {
        Clerk clerk=new Clerk();
        Producer producer=new Producer(clerk);
        producer.setName("生产者1");
        Consumer consumer=new Consumer(clerk);
        consumer.setName("消费者1");
        producer.start();
        consumer.start();
    }



}
class Clerk{ //店员  手里有商品
private int productNum=0;

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    public synchronized void produce() {
        if(productNum<20){
            productNum++;
            System.out.println("生产第"+productNum+"个产品");
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consume() {
        if(productNum>0){
            System.out.println("消费第"+productNum+"个产品");
            productNum--;
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Producer extends Thread{//生产者
    private Clerk clerk;
    public Producer(Clerk clerk){
        this.clerk=clerk;
    }

    public Clerk getClerk() {
        return clerk;
    }

    public void setClerk(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+"生产者生产商品");
        while (true){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produce();
        }

    }
}
class Consumer extends Thread{
    private Clerk clerk;
    public Consumer(Clerk clerk) {
        this.clerk=clerk;
    }

    public Clerk getClerk() {
        return clerk;
    }

    public void setClerk(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+"消费者消费商品");
        while (true){
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consume();
        }
    }
}
