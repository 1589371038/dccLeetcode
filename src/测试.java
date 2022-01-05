import java.util.Deque;
import java.util.LinkedList;

/**
 * moon
 */

public class 测试 {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        deque.poll();
        deque.push(4);
        deque.add(5);
        deque.offer(6);
        System.out.println("");
    }
}
