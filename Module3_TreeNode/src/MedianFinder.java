import java.util.PriorityQueue;

public class MedianFinder {
    // 小顶堆存大数
    PriorityQueue<Integer>  pq2= new PriorityQueue<>();
    // 大顶堆存小数
    PriorityQueue<Integer>  pq1= new PriorityQueue<>((o1, o2)->o2-o1);

    /** initialize your data structure here. */
    public MedianFinder() {
    }

    public void addNum(int num) {
        if(pq1.isEmpty()){
            pq1.offer(num);
        }else if(pq2.isEmpty()){ //如果pq1有,pq2没有，必须保证pq2的数字大于pq1
            pq1.offer(num);
            pq2.offer(pq1.poll());
        }else { // 俩个都不为空则比大小
            if(num<=pq1.peek()){
                pq1.offer(num);
                if(pq1.size()>pq2.size()+1){
                    pq2.offer(pq1.poll());
                }
            }else if(num>=pq2.peek()){
                pq2.offer(num);
                if(pq2.size()>pq1.size()){
                    pq1.offer(pq2.poll());
                }
            }else{ // 如果在中间
                if(pq1.size()==pq2.size()){
                    pq1.offer(num);
                }else{
                    pq2.offer(num);
                }
            }
        }

    }

    public double findMedian() {
        if(pq1.size()!=pq2.size()){
            return pq1.peek();
        }else{
            return (pq1.peek()+pq2.peek())/2.0;
        }

    }

}
