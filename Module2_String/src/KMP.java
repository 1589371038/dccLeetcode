//28. 实现 strStr()
//实现 strStr() 函数。
//
//给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
// 如果不存在，则返回  -1。
//可以用暴力，最好是kmp
public class KMP {
    public int strStr(String haystack, String needle) {
        if(needle==null||needle.length()==0){
            return 0;
        }
        if(haystack==null||haystack.length()==0){
            return -1;
        }
        //先计算部分匹配表next[]
        //创建一个 next 数组保存部分匹配值
        int[] next = new int[needle.length()];
        next[0] = 0; //如果字符串是长度为 1 部分匹配值就是 0
        for (int i = 1, j = 0; i < needle.length(); i++) {
            //当 needle.charAt(i) != needle.charAt(j) ，我们需要从 next[j-1]获取新的 j
            //直到我们发现 有 needle.charAt(i) == needle.charAt(j)成立才退出
            //这时 kmp 算法的核心点
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }

            //当 needle.charAt(i) == needle.charAt(j) 满足时，部分匹配值就是+1
            if(needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        //然后kmp算法
        for (int i = 0, j = 0; i < haystack.length(); i++) {
            //需要处理 haystack.charAt(i) != needle.charAt(j), 去调整 j 的大小
            //KMP 算法核心点, 可以验证...
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }

            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {//找到了 // j = 3 i
                return i - j + 1;
            }
        }
        return -1;
    }
}
