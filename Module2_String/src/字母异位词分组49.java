import java.util.*;

/**
 * 49. 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 我的思路  先对每个String内部排序，这样就可以把字母异位词变成相同的词
 * 再把String数组排序，这样相同的词就凑一起了，但是排序过程要把单词下标也带上，map.entry(key为index，map为String)
 * 例如  1:eat 3:eat 8:eat 2:full 4:full 5:
 * 然后顺序读取，每相同的一组的下标，在原数组中提取String组成List
 */

public class 字母异位词分组49 {
    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        if (strs.length < 1) {
            return result;
        }
        String[] sortedStrs = new String[strs.length];
        System.arraycopy(strs, 0, sortedStrs, 0, strs.length);
        Map<Integer, String> index2String = new HashMap<>();
        for (int i = 0; i < sortedStrs.length; i++) {
            char[] chars = sortedStrs[i].toCharArray();
            Arrays.sort(chars);
            sortedStrs[i] = String.valueOf(chars);
            index2String.put(i, sortedStrs[i]);
        }
        List<Map.Entry<Integer, String>> list = new ArrayList<>(index2String.entrySet()); //放在一块，排序
        Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {

            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        //处理结果
        int indexL = 0;
        int indexR = 0;
        while (indexR < strs.length) {
            List<String> same = new ArrayList<>();
            while (indexR<strs.length&&list.get(indexR).getValue().equals(list.get(indexL).getValue())) {
                same.add(strs[list.get(indexR).getKey()]);
                indexR++;
            }
            result.add(same);
            indexL = indexR;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"vbs", "adc", "ap","dca", "pa"};
        System.out.println(groupAnagrams(strings));
    }
}
