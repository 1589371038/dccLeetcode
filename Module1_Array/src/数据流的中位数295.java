import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * 例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 * 中位数，就是排序后中间的两个数取平均值
 * 难点在于，如果每次插入数据就重新排序，那复杂度太高，那怎么在插入的时候高效获取中位数呢？
 *
 * 中位数就是第x大的数，那不用排序，用优先队列(堆)就能知道了
 *  (1 2 3 4大顶堆A) (小顶堆B 5 6 7 8) 一个大顶堆, 一个小顶堆
 *  插入(维护)：要保证中位数在堆顶，就得保证两个堆一样大或者只差1，并且A堆顶<B堆顶
 *  插入num
 *  我们默认A大小=B 或A=B+1
 *  1.num<A.top, 则插入A， 若A大过B超过1了，把Apop到B，保持均衡
 *  2.num>B.top, 则插入B， 若B大过A超了，把Bpop到A，保持均衡
 *  3.若在num在AB中间, 若Asize=Bsize插入A 若ASize>Bsize插入B
 *  查中位数： 两个堆大小相同，取堆顶平均数。 不同，取多的那个，假设大顶堆size多1，那就是大顶堆堆顶
 */

public class 数据流的中位数295 {
    PriorityQueue<Integer> A;
    PriorityQueue<Integer> B;
    public 数据流的中位数295() {
        A = new PriorityQueue<>((o1, o2) -> o2-o1);//大顶堆
        B = new PriorityQueue<>();//小顶堆
    }

    public void addNum(int num) {
        if(A.isEmpty()||num<=A.peek()){
            A.offer(num);
            if(A.size()> B.size()+1){
                B.offer(A.poll());
            }
        }else { //这时候很难判断B的大小，有可能无法peek,size是0，干脆全放B，超了再退
            B.offer(num);
            if(B.size()>A.size()){
                A.offer(B.poll());
            }

        }

    }

    public double findMedian() {
        if(A.size()> B.size()){
            return A.peek();
        }else {
            return (A.peek()+B.peek())/2.0;
        }

    }

}
