public class StaticProxy implements Strong {
    Strong strong;
    public StaticProxy(Strong s){
        this.strong=s;
    }
    public StaticProxy(){}
    @Override
    public String duanLian1(int num) {
        System.out.println("处理前咱这个算动态代理吗");
        strong.duanLian1(num);
        System.out.println("处理后咱这个算动态代理吗");
        return null;
    }

    @Override
    public String duanLian2(String s) {
        System.out.println("处理前咱这个算动态代理吗");
        strong.duanLian2(s);
        System.out.println("处理后咱这个算动态代理吗");
        return null;
    }

    public static void main(String[] args) {
        StaticProxy staticProxy=new StaticProxy(new Producer());
        staticProxy.duanLian1(12);
        staticProxy.duanLian2("哈哈哈");
    }
}
