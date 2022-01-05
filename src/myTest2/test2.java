package myTest2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class test2 {
    public static void main(String[] args) {
        File file1=new File("3.png");
        File file2=new File("33.png");
        FileInputStream fileInputStream=null;
        FileOutputStream fileOutputStream=null;
        try {
            fileInputStream=new FileInputStream(file1);
            fileOutputStream=new FileOutputStream(file2);
            byte[] bytes=new byte[500];
            int len=0;
            while ((len=fileInputStream.read(bytes))!=-1){
                fileOutputStream.write(bytes,0,len);
                System.out.println("复制一次，字节长度为"+len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
