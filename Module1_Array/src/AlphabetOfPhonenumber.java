import java.util.ArrayList;
import java.util.List;

public class AlphabetOfPhonenumber {
//    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
//    思路：回溯法
List<String> list=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
public List<String> letterCombinations(String digits) {
if(digits==null){return  list;}
 SpellFirstNum(digits,0);
return list;
}

    private void SpellFirstNum(String digits,int index) {
    if(index==digits.length()){return;}
    char first=digits.charAt(index);
    switch (first){
        case '2':
            sb.append('a');
            if (index==digits.length()-1){
                list.add(sb.toString());
            }
            SpellFirstNum(digits,index+1);
            sb.delete(sb.length()-1,sb.length());
            sb.append('b');
            if (index==digits.length()-1){
                list.add(sb.toString());
            }
            SpellFirstNum(digits,index+1);
            sb.delete(sb.length()-1,sb.length());
            sb.append('c');
            if (index==digits.length()-1){
                list.add(sb.toString());
            }
            SpellFirstNum(digits,index+1);
            sb.delete(sb.length()-1,sb.length());
            break;
        case '3':
            sb.append('d');
            if (index==digits.length()-1){
                list.add(sb.toString());
            }
            SpellFirstNum(digits,index+1);
            sb.delete(sb.length()-1,sb.length());
            sb.append('e');
            if (index==digits.length()-1){
                list.add(sb.toString());
            }
            SpellFirstNum(digits,index+1);
            sb.delete(sb.length()-1,sb.length());
            sb.append('f');
            if (index==digits.length()-1){
                list.add(sb.toString());
            }
            SpellFirstNum(digits,index+1);
            sb.delete(sb.length()-1,sb.length());
            break;
        case '4':
            sb.append('g');
            if (index==digits.length()-1){
                list.add(sb.toString());
            }
            SpellFirstNum(digits,index+1);
            sb.delete(sb.length()-1,sb.length());
            sb.append('h');
            if (index==digits.length()-1){
                list.add(sb.toString());
            }
            SpellFirstNum(digits,index+1);
            sb.delete(sb.length()-1,sb.length());
            sb.append('i');
            if (index==digits.length()-1){
                list.add(sb.toString());
            }
            SpellFirstNum(digits,index+1);
            sb.delete(sb.length()-1,sb.length());
            break;
        case '5':
            sb.append('j');
            if (index==digits.length()-1){
                list.add(sb.toString());
            }
            SpellFirstNum(digits,index+1);
            sb.delete(sb.length()-1,sb.length());
            sb.append('k');
            if (index==digits.length()-1){
                list.add(sb.toString());
            }
            SpellFirstNum(digits,index+1);
            sb.delete(sb.length()-1,sb.length());
            sb.append('l');
            if (index==digits.length()-1){
                list.add(sb.toString());
            }
            SpellFirstNum(digits,index+1);
            sb.delete(sb.length()-1,sb.length());
            break;
        case '6':
            sb.append('m');
            if (index==digits.length()-1){
                list.add(sb.toString());
            }
            SpellFirstNum(digits,index+1);
            sb.delete(sb.length()-1,sb.length());
            sb.append('n');
            if (index==digits.length()-1){
                list.add(sb.toString());
            }
            SpellFirstNum(digits,index+1);
            sb.delete(sb.length()-1,sb.length());
            sb.append('o');
            if (index==digits.length()-1){
                list.add(sb.toString());
            }
            SpellFirstNum(digits,index+1);
            sb.delete(sb.length()-1,sb.length());
            break;
        case '7':
            sb.append('p');
            if (index==digits.length()-1){
                list.add(sb.toString());
            }
            SpellFirstNum(digits,index+1);
            sb.delete(sb.length()-1,sb.length());
            sb.append('q');
            if (index==digits.length()-1){
                list.add(sb.toString());
            }
            SpellFirstNum(digits,index+1);
            sb.delete(sb.length()-1,sb.length());
            sb.append('r');
            if (index==digits.length()-1){
                list.add(sb.toString());
            }
            SpellFirstNum(digits,index+1);
            sb.delete(sb.length()-1,sb.length());
            sb.append('s');
            if (index==digits.length()-1){
                list.add(sb.toString());
            }
            SpellFirstNum(digits,index+1);
            sb.delete(sb.length()-1,sb.length());
            break;
        case '8':
            sb.append('t');
            if (index==digits.length()-1){
                list.add(sb.toString());
            }
            SpellFirstNum(digits,index+1);
            sb.delete(sb.length()-1,sb.length());
            sb.append('u');
            if (index==digits.length()-1){
                list.add(sb.toString());
            }
            SpellFirstNum(digits,index+1);
            sb.delete(sb.length()-1,sb.length());
            sb.append('v');
            if (index==digits.length()-1){
                list.add(sb.toString());
            }
            SpellFirstNum(digits,index+1);
            sb.delete(sb.length()-1,sb.length());
            break;
        case '9':
            sb.append('w');
            if (index==digits.length()-1){
                list.add(sb.toString());
            }
            SpellFirstNum(digits,index+1);
            sb.delete(sb.length()-1,sb.length());
            sb.append('x');
            if (index==digits.length()-1){
                list.add(sb.toString());
            }
            SpellFirstNum(digits,index+1);
            sb.delete(sb.length()-1,sb.length());
            sb.append('y');
            if (index==digits.length()-1){
                list.add(sb.toString());
            }
            SpellFirstNum(digits,index+1);
            sb.delete(sb.length()-1,sb.length());
            sb.append('z');
            if (index==digits.length()-1){
                list.add(sb.toString());
            }
            SpellFirstNum(digits,index+1);
            sb.delete(sb.length()-1,sb.length());
            break;
    }
    }
}
