//146. LRU缓存机制
//运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
//
//获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
//写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

import java.util.HashMap;

public class LRUchache_my {
 class DlinkedNode{
     int key;
     int value;
     DlinkedNode pre;
     DlinkedNode next;
     public  DlinkedNode(){}
     public  DlinkedNode(int key1,int value1){this.key=key1;this.value=value1; }
    }
    private int size=0;
 private int capacity=0;
private DlinkedNode head=new DlinkedNode();
 private DlinkedNode tail=new DlinkedNode();
    private HashMap<Integer,DlinkedNode> map;
        public LRUchache_my (int capacity) {
            this.capacity=capacity;
            map=new HashMap<>(capacity);
            head.next=tail;
            tail.pre=head;

        }

        public int get(int key) {
            DlinkedNode node = map.get(key);
            if(node==null){
                return -1;
            }else{
                moveFirst(node);
                return node.value;

            }

        }
    public void put(int key, int value) {
          DlinkedNode node =map.get(key);
          if(node!=null){
              node.value=value;
              moveFirst(node);
          }
          else{
              DlinkedNode newNode=new DlinkedNode(key,value);
              map.put(key,newNode);
              putFirst(newNode);
              size++;
              if(size>capacity){  //如果超过容量，hashmap和链表都要删除
                  int deleteKey=tail.pre.key;
                  deleteNode(tail.pre);
                  map.remove(deleteKey);
              }
          }
    }

    private void moveFirst(DlinkedNode node) {
           deleteNode(node);
           putFirst(node);
    }

    private void putFirst(DlinkedNode node) {
            node.pre=head;
            node.next=head.next;
            head.next.pre=node;
            head.next=node;
    }

    private void deleteNode(DlinkedNode node) {
            node.pre.next=node.next;
            node.next.pre=node.pre;
    }



}
