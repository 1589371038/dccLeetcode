package MyTest3;

import java.io.InputStream;
import java.util.Properties;

public class FanShe {
    public static void main(String[] args) {
        try {
            InputStream is = FanShe.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties=new Properties();
            properties.load(is);
           String name = properties.getProperty("name");
            System.out.println(name);
        } catch (Exception e) {
            e.printStackTrace();

    }
}}
