import java.util.Date;
import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("执行Mycallable");
        Date date=new Date();
        return "西八"+date;
    }
}
