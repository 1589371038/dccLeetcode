/**
 * moon
 */

public class 测试手写LRU缓存 {
    public static void main(String[] args) {
        手写LRU缓存 LRU =new 手写LRU缓存(3);
        System.out.println(LRU.get(1));
        LRU.put(1,1);
        System.out.println(LRU.get(1));
        LRU.put(2,2);
        System.out.println(LRU.get(2));
        LRU.put(3,3);
        System.out.println(LRU.get(3));
        LRU.put(4,4); //这时候1被删除
        System.out.println(LRU.get(4));
        System.out.println(LRU.get(1));
        LRU.put(4,5); //这时候1被删除
        System.out.println(LRU.get(4));
        System.out.println(LRU.get(1));
    }
}
