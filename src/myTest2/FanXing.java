package myTest2;

import java.util.HashMap;

public class FanXing<H> {
    private H madam;
    public void setMadam(H madam){
        this.madam=madam;
    }
    public void setMadam2(H madam){
        this.madam=madam;
    }
    public void printF(){
        System.out.println(madam);
    }

    public static void main(String[] args) {
        FanXing<String> fanXing=new FanXing<>();
        fanXing.setMadam("123");
        fanXing.printF();
        FanXing<HashMap> fanXingmap=new FanXing<>();
        fanXingmap.setMadam(new HashMap());
        fanXingmap.printF();
        FanXing fanXing3=new FanXing<>();
        fanXing3.setMadam(123);
        fanXing3.setMadam2("shit");
        fanXing3.printF();
    }
}
