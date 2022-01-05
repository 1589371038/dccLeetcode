package MyTest3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamAPITest {
    public static void main(String[] args) {
        List<Employee> list=new ArrayList<>();
        list.add(new Employee(10,"马老师"));
        list.add(new Employee(43,"萨克斯"));
        list.add(new Employee(42,"开发商"));
        list.add(new Employee(54,"咖啡师"));
        list.stream().filter(e->e.getAge()>40).forEach(e-> System.out.println(e));
        Optional<Employee> max = list.stream().max(Comparator.comparingDouble(Employee::getAge));
        System.out.println(max);
    }
}
