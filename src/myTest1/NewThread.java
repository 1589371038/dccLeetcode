package myTest1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class NewThread{
    public static void main(String[] args) {
        CallThread ct=new CallThread();
        FutureTask futureTask=new FutureTask(ct);
        Thread thread=new Thread(futureTask);
        thread.start();
        Object o = null;
        try {
            o = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(o);
    }
}

 class CallThread implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("运行callable线程");
        return "哈哈哈";
    }
}
