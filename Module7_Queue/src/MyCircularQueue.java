//622循环队列，数组实现
public class MyCircularQueue {
int [] queque;
int size=0;
int indexHead=0;
    int indexTail=0;
int count=0;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
queque=new int[k];
size=k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
if(isEmpty()){
    queque[0]=value;
    indexHead=0;
    count++;
    return true;
}
else if(count<size){
    count++;
     indexTail=(indexHead+count-1)%size;
     queque[indexTail]=value;
     return true;
}
else {
    return false;
}
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        else {
           indexHead=(indexHead+1)%size;
           count--;
           return true;
        }

    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()){
            return -1;
        }
      return queque[indexHead];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        indexTail=(indexHead+count-1)%size;
        return queque[indexTail];

    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return count==0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
return count==size;
    }
}
