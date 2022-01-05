package myTest2;

public class TestFX extends FanXing<String> implements FXInterface1<String,String> {
    @Override
    public void haha(String s) {

    }

    @Override
    public void haha2(String s) {

    }

    public static void main(String[] args) {
        FanXing<String> fanXing = new TestFX();
    }
}
