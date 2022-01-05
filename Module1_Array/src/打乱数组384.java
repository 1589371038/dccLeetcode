import java.util.*;
import java.util.stream.Collectors;

/**
 * 384. 打乱数组
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
 *
 * 实现 Solution class:
 *
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 *
 * 思路：洗牌算法！
 * reset嘛，简单，用一个数组存储初始值，System.arraycopy复制就好了
 * 洗牌怎么洗最快？and保证纯随机？
 * 随机需要用random随机一个下标，比如 1 2 3 4 5 6 第一次选了4，填充到数组第一个，但是后面5和6就得往前挪
 * 效率就成了n*n了
 * 洗牌算法：洗过的和最后一个交换位置 1 2 3 6 5 4 然后第二次从1-5开始洗牌！这样不用挪了
 * gogogo
 *
 * 更厉害的洗牌算法：不用复制一个数组，在num的基础上，随机，然后随机的数字放到前面去，然后从新的下标开始随机
 * 比如 1 2 3 4 5 6 第一次选了4  交换位置 4 | 2 3 1 5 6
 * 下次从2-6 也就是下标1-5开始随机，比如随机到了1，交换位置 4 1 | 3 2 5 6
 * 下次从下标2-5开始随机
 */

public class 打乱数组384 {
    int [] origin;
    int [] now;

    public 打乱数组384(int[] nums) {
        origin = new int[nums.length];//初始化
        System.arraycopy(nums, 0,origin,0,nums.length);
        now = new int[nums.length];//初始化
        System.arraycopy(nums, 0,now,0,nums.length);
    }

    public int[] reset() {
        System.arraycopy(origin, 0,now,0,now.length); //把原始数组重置到now
        return now;
    }

    public int[] shuffle() {
        //用一个List复制origin来洗牌
        List<Integer> list = Arrays.stream(origin).boxed().collect(Collectors.toList());
        for(int i=0;i<now.length;i++){
            //从0到len-1-i随机一个数字作为下标
            Random random = new Random();
            int index = random.nextInt(origin.length - i);
            now[i]=list.get(index);
            //和尾部交换 尾部下标为len-1-i
            int tailIndex = origin.length-1-i;
            int temp = list.get(index);
            list.set(index,list.get(tailIndex));
            list.set(tailIndex,temp);
        }
        return now;
    }
    //第二种，原地洗牌，放到前面
    public int[] shuffle2() {
        for(int i=0;i<now.length;i++){
            Random random = new Random();
            int index = i+random.nextInt(now.length-i); //i是左边起点
            int temp = now[i];
            now[i] = now[index];
            now[index] = temp;
        }
        return now;
    }

}
