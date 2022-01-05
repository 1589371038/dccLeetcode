package myTest2;


import java.io.Serializable;

public class Animal implements Serializable {
    public static final long serialVersionUID=234556456L;
    private String nameqwe;
    private Integer age;
    public Animal(){}
    public Animal(String name){
        this.nameqwe=name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nameqwe='" + nameqwe + '\'' +
                ", age=" + age +
                '}';
    }
}
