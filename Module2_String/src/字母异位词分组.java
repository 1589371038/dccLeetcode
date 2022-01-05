import java.util.*;
import java.util.stream.Collectors;

/**
 * 49. 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * 思考：按排序后的结果分组！
 */

public class 字母异位词分组 {
    class Entry<T1,T2> { //二元组 存储字符串以及其排序后的结果
        T1 t1;
        T2 t2;
        public T1 getT1() {
            return t1;
        }
        public void setT1(T1 t1) {
            this.t1 = t1;
        }
        public T2 getT2() {
            return t2;
        }
        public void setT2(T2 t2) {
            this.t2 = t2;
        }
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Entry<String, String> [] entries = new Entry[strs.length];
        for(int i=0;i<strs.length; i++){
            Entry<String, String> entry = new Entry<>();
            entry.setT1(strs[i]);
            entry.setT2(sorted(strs[i]));
            entries[i]=entry;
        }
        //根据第二个参数分组(排序后的String)
        Map<String, List<Entry<String, String>>> collect = Arrays.stream(entries).collect(Collectors.groupingBy(Entry::getT2));
        List<List<String>> result =collect.values().stream().map(list->{
            List<String> group =new ArrayList<>();
            for(Entry<String, String> entry:list){
                group.add(entry.getT1());
            }
            return group;
        }).collect(Collectors.toList());
        return result;
    }

    private String sorted(String str) {
        char[] chars=str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
