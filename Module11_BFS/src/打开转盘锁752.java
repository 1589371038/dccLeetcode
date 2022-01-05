import java.util.*;

/**
 * bfs 起点0000 终点target  避开deadends 用map记录走过的
 */
public class 打开转盘锁752 {
    public static int openLock(String[] deadends, String target) {
        String start = "0000";

        Set<String> record = new HashSet<>();//记录哪些步走过
        record.add(start);

        //记录deadends,方便判断
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if(dead.contains(start)){
            return -1; //如果初始就是死锁
        }
        Deque<String> queue = new LinkedList<>();
        queue.offer(start);
        int time = 0; //拨锁的次数
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(target)) {
                    return time;
                }
                List<String> words = getNextWords(word, dead, record); //获取密码下一次能到达的密码，避开deadends和record；
                for (String w : words) {
                    queue.offer(w);
                }
            }
            time++;
        }
        return -1;

    }

    /**
     * 这个方法用来产生下一步能走到的所有情况
     */
    private static List<String>  getNextWords(String word, Set<String> dead, Set<String> record) {
        List<String> words = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            int num = word.charAt(i) - '0';
            int numPlus = (num + 1) % 10;  //拨+1  后的数字
            int numDelete = (num + 9) % 10; //拨-1
            char[] chars1 = word.toCharArray();

            chars1[i] = (char) (numPlus + '0');
            String stringPlus = new String(chars1); //拨+1后的String
            if (!dead.contains(stringPlus)&&!record.contains(stringPlus)){
                words.add(stringPlus);
                record.add(stringPlus); //走这一步，加入记录
            }

            chars1[i] = (char) (numDelete + '0');
            String stringDelete = new String(chars1);//拨-1后的String
            if(!dead.contains(stringDelete)&&!record.contains(stringDelete)){
                words.add(stringDelete);
                record.add(stringDelete);
            }
        }
        return words;
    }

    public static void main(String[] args) {
        int i = openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202");
        System.out.println(i);
    }
}
