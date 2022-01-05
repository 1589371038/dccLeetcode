package myTest1;

public class Student {
    public String name;
    private int age;
    int score;
   public Student(){
        System.out.println("父类被初始化");
    }
    public Student(String name){
        System.out.println("父类被初始化,有参数");
    }

    public static void main(String[] args) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String name1 = getName();
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    private void speak(){
        System.out.println("父类在说话");
    }
    public void doSpeak(){
        this.speak();
    }
}
