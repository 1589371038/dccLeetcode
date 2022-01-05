package myTest2;

import java.io.*;

public class test3 {
    public static void main(String[] args) {
     //testWrite();
    testRead();
    }
    public static void testWrite(){
        ObjectOutputStream  oos= null;
        Animal animal=null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("animal.data"));
            animal=new Animal("乌鸦");
            oos.writeObject(animal);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public static void testRead(){
        ObjectInputStream ois= null;
        try {
            ois = new ObjectInputStream(new FileInputStream("animal.data"));
            Object o = ois.readObject();
            Animal a=(Animal) o;
            System.out.println(a);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
