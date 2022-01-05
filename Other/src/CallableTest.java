import java.util.concurrent.*;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Callable callable=new MyCallable();
        Future future = executorService.submit(callable);
        String s = future.get().toString();
        System.out.println(s);;
    }

}
