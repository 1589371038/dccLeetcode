import java.util.*;

public class test {
    public static void main(String[] args) {
        HashMap<String,String> map=new HashMap<>();
       map.put("aaa","sas");
        map.put("111","233");
        HashMap<String,String> map2=new HashMap<>(100);
        map2.put("aaa","sas");
        map2.put("111","233");
        System.out.println(map.equals(map2));
    }

}
