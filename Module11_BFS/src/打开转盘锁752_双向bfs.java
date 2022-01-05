import java.util.*;
import java.util.stream.Collectors;

/**
 * 单向bfs，每一层节点都爆增，
 * 从源节点和目标节点双向bfs，可以更快，时间和空间都节省
 * 思路：两个队列，两个set记录走过的路，while 循环本来单向的时候是队列不为空, 双向则为，队列之一为空就停止
 * 那while里谁先展开呢？ 哪个队列的size小就先展开(这样效率最高)
 * 展开后先判断是否走过/ 是dead  然后判断是否连通(如果另一个set包含此节点，双向搜索就联通了，此时两边搜索的距离之和就是步数)
 * 否则就加入队列啦
 * 链接：https://leetcode-cn.com/problems/open-the-lock/solution/gong-shui-san-xie-yi-ti-shuang-jie-shuan-wyr9/
 * 注：我的双向在队列中是一层一层走的，每次步数+1，
 * 但是也有更细粒度的做法，每次都队列中一个一个走，选择更短的队列来走，这样应该会更好，那这样如何存储步数？
 * 答案是原本用set记录走过的路，现在用map，key为 1234的密码， value为走到这的步数
 */

public class 打开转盘锁752_双向bfs {
    public int openLock(String[] deadends, String target) {
        if (target == "0000") {
            return 0;
        }
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains(target) || dead.contains("0000")) {
            return -1;
        }
        //特殊情况处理完毕
        String start = "0000";
        Set<String> startRecord = new HashSet<>();
        startRecord.add(start);
        Set<String> endRecord = new HashSet<>();
        endRecord.add(target);

        Deque<String> startQueue = new LinkedList<>();
        startQueue.offer(start);
        Deque<String> endQueue = new LinkedList<>();
        endQueue.offer(target);

        int sStep = 0; //start开始的bfs步数
        int eStep = 0; //end开始的bfs步数
        while (!(startQueue.isEmpty() || endQueue.isEmpty())) {//有一个为空就结束
            int sSize = startQueue.size();
            int eSize = endQueue.size();
            if (sSize <= eSize) { //挑小的开始bfs扩展 这里从start开始扩展
                for (int i = 0; i < sSize; i++) {
                    String poll = startQueue.poll();
                    if (endRecord.contains(poll)) {//如果联通了
                        return sStep + eStep;
                    }
                    List<String> nextOfPoll = getNext(poll); //获取扩展后的所有密码情况
                    //过滤掉走过的以及dead中的
                    List<String> next = nextOfPoll.stream()
                            .filter(s -> !(dead.contains(s) || startRecord.contains(s)))
                            .collect(Collectors.toList());
                    for (String n : next) {
                        startQueue.offer(n);
                        startRecord.add(n);
                    }
                }
                sStep++;//一轮走完，步数+1
            } else {  //从end开始扩展
                for (int i = 0; i < eSize; i++) {
                    String poll = endQueue.poll();
                    if (startRecord.contains(poll)) {//如果联通了
                        return sStep + eStep;
                    }
                    List<String> nextOfPoll = getNext(poll); //获取扩展后的所有密码情况
                    List<String> next = nextOfPoll.stream() //过滤
                            .filter(s -> !(dead.contains(s) || endRecord.contains(s)))
                            .collect(Collectors.toList());
                    for (String n : next) {
                        endQueue.offer(n);
                        endRecord.add(n);
                    }
                }
                eStep++;//一轮走完，步数+1
            }
        }
        return -1;//循环完了还没找到,-1
    }

    private List<String> getNext(String poll) { //获取所有下一步拨锁的情况，不做重复性校验
        List<String> results = new ArrayList<>();
        char[] chars = poll.toCharArray();
        for (int i = 0; i < 4; i++) {
            int num = chars[i] - '0';
            int nextNum = (num + 1) % 10;
            int preNum = (num + 9) % 10;
            chars[i] = (char) (nextNum + '0');
            results.add(new String(chars));
            chars[i] = (char) (preNum + '0');
            results.add(new String(chars));
            chars[i] = (char) (num + '0'); //复原，下一轮继续用
        }
        return results;
    }
}
