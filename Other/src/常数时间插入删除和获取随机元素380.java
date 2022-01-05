import java.util.*;

/**
 * 380. O(1) 时间插入、删除和获取随机元素
 * 实现RandomizedSet 类：
 *
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 *
 * 思考：o1的插入，查询用hashset就行了，但是随机的获取需要下标，需要数组！
 * 那如果结合List和Set呢？
 * 1.插入，用set判断是否存在 (o1) 用list和set add (o1)
 * 2.随机获取,用list.get(random.nextInt())(o1)
 * 3.删除,首先判断set里是否存在(o1), 然后set的删除(o1) List的删除remove(Obj)需要从前到后一个一个判断==，效率为(O(n))
 * 因此为了快速删除，需要在set中记录数字在List的下标, 用remove(int index)但是这样之后，后面每个元素都要往前移一位，效率也是O（n）了
 * 那咋办呢，和List中最后一个元素交换位置,然后再remove！这样就不用移位了！ 记得在hashmap中更新最后一个元素的位置
 *
 */

public class 常数时间插入删除和获取随机元素380 {
    Map<Integer, Integer> map =new HashMap<>();
    List<Integer> list = new ArrayList<>();
    public 常数时间插入删除和获取随机元素380() {
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }else {
            list.add(val);
            map.put(val,list.size()-1);
            return true;
        }
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }else {
            Integer index = map.get(val);
            map.remove(val);//map删除
            int temp = list.get(index);//和最后一位换位
            int n = list.size()-1;
            list.set(index,list.get(n));
            list.set(n,temp);
            list.remove(n);//移除最后一位
            //原本的最后一位换过来了，更新index
            if(index!=n){ //万一删除的就是最后一位，交换后删除掉了就找不到了
                map.put(list.get(index),index);
            }

            return true;
        }
    }

    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}
