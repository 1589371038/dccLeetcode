import java.util.HashMap;
import java.util.Map;

/**
 *146. LRU 缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 */

public class 手写LRU缓存 {
    class DualNode { //存储单元的基本结构，双链表节点
        int key;
        int value;
        public DualNode(int key,int value){
            this.key = key;
            this.value = value;
        }
        public DualNode(){
        }
        DualNode pre;
        DualNode next;
    }
    DualNode head;
    DualNode tail; //head和tail用于寻找定位
    int capacity;
    int size;
    Map<Integer,DualNode> map ;
    public 手写LRU缓存(int capacity){//构造方法构造容量
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        head = new DualNode();
        tail = new DualNode();
        head.next=tail;
    }

    public int get(int key){
        DualNode dualNode = map.get(key);
        if(dualNode==null){ //找不到
            return -1;
        }else {
            remove(dualNode);
            toHead(dualNode);
            return dualNode.value; //找到了，需要更新在链表中的顺序,删除原节点的位置关系，并放入头部
        }
    }
    public void put(int key, int value){
        if(map.containsKey(key)){ //如果有，更新map存储的值并且把这个节点放入头部
            DualNode dualNode = map.get(key);
            dualNode.value=value;
            remove(dualNode);
            toHead(dualNode);
        }else { //如果不包含，就是新增
            DualNode node = new DualNode(key,value);
            map.put(key,node);
            toHead(node);  //新增并且放入头节点
            size++;
            if(size>capacity){ //如果超过了，从链表和map中删除 尾巴前的节点
                DualNode toRemove = tail.pre;
                map.remove(toRemove.key);
                remove(tail.pre);
                size--;
            }
        }
    }

    private void toHead(DualNode dualNode) {
        dualNode.next=head.next;
        head.next.pre = dualNode;
        head.next=dualNode;
        dualNode.pre=head;
    }

    private void remove(DualNode dualNode) {
        dualNode.pre.next = dualNode.next;
        dualNode.next.pre = dualNode.pre;
    }

}
