import java.util.PriorityQueue;

//数组第k大的数
public class 数组中的第K个最大的元素 {
    // 第一种方法，用现成的最小堆
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(k);
        for(int i=0;i<nums.length;i++){
            if(i<k){
                pq.offer(nums[i]);
            }
            else{
                if(nums[i]>pq.peek()){
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
        }
        return pq.peek();
    }
//------------------------------------------------------------------------------------------------------------------
    /**
     * 第二种方法，手写一个最小堆
     * 构造堆，有三个操作
     * 1.可以初始化(堆化)一个原有的乱序数组：方法是把每一个非叶子节点(n/2到1按顺序) 每个都堆化(往下一层找left和right，替换最小的那个)
     * 2.新增，在构造好的堆上新增一个，在数组末尾新增数字后往上堆化置换，如果比它父节点小就置换
     * 3.删除头节点(poll) 删除头节点后需要重新堆化，方法是先和数组末尾数字置换,然后让根节点不断向下堆化置换
     * 4.如果是先poll再add，可以直接将新数字放入头节点，重新把根节点向下堆化（适用于本题）
     *
     * 另外，堆排序就是建好堆后不断pop！
     *
     * 参考
     * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/java-pai-xu-xiao-ding-dui-shi-xian-by-yankuangshig/
     */
    public int findKthLargest1(int[] nums, int k) {
        buildHeap(nums, k); // 堆化前k个元素
        for(int i=k; i<nums.length; i++){ //后面的元素和堆顶比
            if(nums[i]<=nums[0]){
                continue;
            }
            swap(nums, i, 0); // 把堆顶换下来
            heaper(nums, k, 0); // 重新堆化堆顶
        }
        return nums[0];
    }



    /**
     * 数组前k个数建堆,也就是非叶子节点堆化
     * @param nums
     * @param k
     */
    private void buildHeap(int[] nums, int k) {
        for(int i = k/2; i>=0; i-- ){
            heaper(nums, k, i);
        }
    }

    /**
     * 堆化第i个元素，也就是不断和其两个子节点作比较并且做交换
     * @param nums
     * @param size
     * @param i
     */
    private void heaper(int[] nums, int size, int i) {
        int indexSmall = i; // 此数字以及左右子树最小的index，也就是要置换的index
        while(true){
            if(2*i+1<size && nums[2*i+1]<nums[indexSmall]){ // 左子树比
                indexSmall = 2*i+1;
            }
            if(2*i+2<size && nums[2*i+2]<nums[indexSmall]){ // 右子树比
                indexSmall = 2*i+2;
            }
            if(indexSmall == i){ // 没有置换，则结束
                break;
            }else {
                swap(nums, i, indexSmall);
                i = indexSmall;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    //-------------------------------------------------------------------------------------------------------------
    //手写一个堆排序吧
    public void heapSort(int [] nums){
        int[] a = new int[nums.length];
        int n = a.length;
        System.arraycopy(nums, 0, a, 0, a.length);
        for(int i = n/2; i>=0; i--){ // 建堆
            heaper(a, n, i);
        }
        int heapSize = n;
        for(int i=0; i<nums.length; i++){ // 取堆顶并且重新堆化
            nums[i] = a[0]; // 堆顶为最小值

            swap(a, 0, heapSize-1); // 堆顶和最后一个交换
            heapSize--; // 交换之后堆的大小-1
            heaper(a, heapSize, 0);

        }
    }
}
