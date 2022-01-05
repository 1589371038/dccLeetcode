public class Producer implements Strong{
    @Override
    public String duanLian1(int num) {
        System.out.println("积极锻炼1"+num+"次");
        return "锻炼成功，得到增强1";
    }

    @Override
    public String duanLian2(String s) {
        System.out.println("积极锻炼2"+s);
        return "锻炼成功，得到增强2";
    }
    public void view(){
        System.out.println("我看见一座座山");
    }
}
