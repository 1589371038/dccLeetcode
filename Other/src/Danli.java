public class Danli {
    private Danli(){}
    private static Danli danli=null;
    public static Danli getDanli(){
        if(danli==null){
            synchronized (Danli.class){
                if(danli==null) {
                    danli = new Danli();
                }
            }

        }
        return danli;
    }
}
