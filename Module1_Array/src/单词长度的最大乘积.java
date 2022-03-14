/**
 * 剑指 Offer II 005. 单词长度的最大乘积
 * 给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
 * 输入: words = ["abcw","baz","foo","bar","fxyz","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "fxyz"。它们不包含相同字符，且长度的乘积最大。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/aseY1I
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 思路： 最笨的方法：两两相比是否有相同字符，复杂度 n^2 * 字符长度
 * 比较两个string是否有相同字符的时候，一个用hashset存所有字符，另一个遍历字符，看是否set包含字符
 * 这样效率很低：
 * 优化：字符都是小写，是有限状态。可以映射到int的低26位上 也就是0和1 1表示字符存在
 * 那么有相同字符，就是两个int 相与 ！= 0
 */

public class 单词长度的最大乘积 {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] wordsInt = new int[n];
        for (int i = 0; i < n; i++) {
            wordsInt[i] = build(words[i]);
        }
        int maxLen = 0;
        for(int i=0; i<n-1; i++){
            for(int j= i+1; j<n; j++){
                if((wordsInt[i] & wordsInt[j]) == 0){ //如果这样，说明没有重复字符
                    maxLen = Math.max(maxLen, words[i].length()*words[j].length());
                }
            }
        }
        return maxLen;
    }

    private int build(String word) {
        int res = 0;
        for (char c : word.toCharArray()) {
            res = res | (1 << (c - 'a'));
        }
        return res;
    }
}
