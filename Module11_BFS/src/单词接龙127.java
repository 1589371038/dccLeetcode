import java.util.*;
import java.util.stream.Collectors;

/**
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：
 * <p>
 * 序列中第一个单词是 beginWord 。
 * 序列中最后一个单词是 endWord 。
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典 wordList 中的单词。
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。
 * 如果不存在这样的转换序列，返回 0。
 * <p>
 * 典型的双向bfs
 * 注意：怎么判断是单词下一步能到达的单词: 1.过滤走过的 2.for循环比较每一位，若difference>2 直接排除，统计difference=1
 * 注意不是步数是单词数目
 * 开搞！
 *
 * 「双向 BFS」的基本实现思路如下：
 *
 * 创建「两个队列」分别用于两个方向的搜索；
 * 创建「两个哈希表」用于「解决相同节点重复搜索」和「记录转换次数」；
 * 为了尽可能让两个搜索方向“平均”，每次从队列中取值进行扩展时，先判断哪个队列容量较少；
 * 如果在搜索过程中「搜索到对方搜索过的节点」，说明找到了最短路径。
 *
 * 作者：AC_OIer
 * 链接：https://leetcode-cn.com/problems/word-ladder/solution/gong-shui-san-xie-ru-he-shi-yong-shuang-magjd/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class 单词接龙127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //先处理特殊情况
        if (beginWord.equals(endWord)) {
            return 2;
        }
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Deque<String> beginQueue = new ArrayDeque<>();
        beginQueue.offer(beginWord);
        int bStep = 1; //从开始端的步数
        Deque<String> endQueue = new ArrayDeque<>();
        endQueue.offer(endWord);
        int eStep = 1; //从结束端的步数

        Set<String> sRecord = new HashSet<>();
        sRecord.add(beginWord);
        Set<String> eRecord = new HashSet<>();
        eRecord.add(endWord);

        while (!(beginQueue.isEmpty() || endQueue.isEmpty())) {
            int bSize = beginQueue.size();
            int eSize = endQueue.size(); //从小点的开始展开，这样效率最高
            if(bSize<=eSize){
                for(int i=0;i<bSize;i++){
                    String poll = beginQueue.poll();
                    //如果连通了
                    if(eRecord.contains(poll)){
                        return bStep+eStep-1;
                    }
                    List<String> next = getNext(poll,wordList,sRecord);
                    for(String s:next){
                        beginQueue.offer(s);
                        sRecord.add(s);
                    }
                }
                bStep++;
            }else {
                for(int i=0;i<eSize;i++){
                    String poll = endQueue.poll();
                    //如果连通了
                    if(sRecord.contains(poll)){
                        return bStep+eStep-1;
                    }
                    List<String> next = getNext(poll,wordList,eRecord);
                    for(String s:next){
                        endQueue.offer(s);
                        eRecord.add(s);
                    }
                }
                eStep++;
            }
        }
        return 0;

    }

    private List<String> getNext(String poll, List<String> wordList, Set<String> sRecord) {
        return wordList.stream().filter(s-> !sRecord.contains(s)).filter(s->judge(poll,s))
                .collect(Collectors.toList()); //过滤掉走过的和走不到的，就是能走到的所有情况
    }

    private boolean judge(String poll, String s) { //此方法判断poll是否一步能走到s
        int diff=0;//字母不同的个数
        for(int i=0;i<s.length();i++){
            if(poll.charAt(i)!=s.charAt(i)){
                diff++;
                if(diff==2){
                    return false;
                }
            }
        }
        //此时diff可能为0或1
        return diff==1;
    }
}
