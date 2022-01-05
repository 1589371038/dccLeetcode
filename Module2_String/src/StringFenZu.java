import java.util.*;

public class StringFenZu {
    public List<List<String>> groupAnagrams(String[] strs) {
List<List<String>> results=new ArrayList<List<String>>() ;
        HashMap<String,List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String key=paixu(strs[i]);
            if(map.containsKey(key)){
                map.get(key).add(strs[i]);
            }
            else{
                List<String> list=new ArrayList<>();
                list.add(strs[i]);
                map.put(key,list);
            }
        }
        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            results.add(entry.getValue());
        }
        return results;
    }

    private String paixu(String str) {
        char[] chars=str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
