import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
         Producer producer=new Producer();
        Object myProxy = getMyProxy(producer);
        Strong myProxy1=(Strong) myProxy;
        String s = myProxy1.duanLian1(123);
        String hahaha = myProxy1.duanLian2("hahaha");
        System.out.println(s);
        System.out.println(hahaha);
    }

    public static Object getMyProxy(Object beProxy){
        Object newProducer=Proxy.newProxyInstance(beProxy.getClass().getClassLoader(), beProxy.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("前处理");
                Object result = method.invoke(beProxy, args);
                System.out.println("后处理");
                return result;
            }
        });
       return newProducer;
    }

}
