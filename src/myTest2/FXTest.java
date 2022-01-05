package myTest2;

import java.util.ArrayList;
import java.util.List;

public class FXTest {
    public static void main(String[] args) {
        List<? extends Person> list1 =new ArrayList<>();
        List<? super Person> list2 =new ArrayList<>();
        list2.add(new Person());
        list2.add(new OldMan());
        System.out.println(list2);
        list2.forEach(System.out::println);
    }
}
