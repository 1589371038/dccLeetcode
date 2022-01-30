import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 71. 简化路径
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 * <p>
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；
 * 两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。
 * 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 * <p>
 * 思路
 * 1提取/和/之间的字符串(这个才是难点)
 * 2用栈 对于. 不操作 对于..pop 对于字母入栈
 */

public class 简化路径71 {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        int len = path.length();
        for (int i = 1; i < len; ) {
            while (i<len&&path.charAt(i) == '/' ) {
                i++;
            }
            if(i==len){
                break;
            }
            int j = i + 1;
            while (j<len&&path.charAt(j)!='/'){
                j++;
            }
            String item = path.substring(i,j);
            if(item.equals("..")){
               if(!stack.isEmpty()) stack.pop();
            }else if(item.equals(".")){
            }else {
                stack.push(item);
            }
            i=j+1;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append("/"+stack.pollLast());
        }
        if(sb.length()==0){
            return "/";
        }else {
            return sb.toString();
        }
    }
}
