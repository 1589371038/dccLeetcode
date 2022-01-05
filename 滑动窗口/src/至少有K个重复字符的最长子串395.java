import java.util.Arrays;

/**
 * 395. 至少有 K 个重复字符的最长子串
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 *
 * 1 <= s.length <= 104
 * s 仅由小写英文字母组成
 * 1 <= k <= 105
 *
 * 如果用滑动窗口，你知道当窗口内满足条件(的每一字符出现次数都不少于 k)的时候，下一个字符如果是窗口内的字符，则右扩，如果不是，就不满足条件
 * 但是后面很可能这个字符往后走还有三个。所以不知道怎么往右扩，也不知道怎么往左缩
 *
 * 宫水三叶题解:https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/solution/xiang-jie-mei-ju-shuang-zhi-zhen-jie-fa-50ri1/
 *
 *  三叶提供了一个思路：字符只有26个！如果我们限制字符只有两个，那怎么滑动数组？
 *  先右扩，用数组统计每个字符的数量，同时统计窗口内不同的字符数 totalNum和大于等于K个的字符数KNum 如果Totalnum=Knum说明满足条件
 *  但是右扩后可能字符数大于2个，那我们就左缩直到totalNUm不超过两个！
 *  在左缩后可以保证totalNUm不超过两个，在这个前提下看窗口内是否满足Totalnum=Knum的条件！满足就更新嘛
 *
 *  限定两个字符的完成了，限定1-26个字符的都可以完成，复杂度为26*n！
 */

public class 至少有K个重复字符的最长子串395 {
    public int longestSubstring(String s, int k) {
        int maxLen=0;
        int[] count = new int[26];//统计窗口内字符数量 a-z 对应下标0-25
        for(int charCount=1; charCount<=26;charCount++){
            Arrays.fill(count,0);//每次指定字符数都是重新开始滑动窗口，重置统计
            //开始滑动 i为左端点 j为右端点 totalNum为不同的字符数 KNum为满足大于等于K的字符数
            int totalNum=0;
            int kNum=0;
            for(int i=0,j=0;j<s.length();j++){
                //右扩
                char c = s.charAt(j);
                count[c-'a']++;
                if( count[c-'a']==1){//新增字符
                    totalNum++;      //字符数++
                }
                if(count[c-'a']==k){
                    kNum++;   //次数>=K的字符数++
                }
                //左缩
                while (totalNum>charCount){
                    char c1 = s.charAt(i++); //去掉i所在的字符
                    count[c1-'a']--;
                    if(count[c1-'a']==0){
                        totalNum--;
                    }
                    if(count[c1-'a']==k-1){
                        kNum--;
                    }
                }
                //缩完了之后数量肯定<=k  这时候判断是否满足都是大于等于k个的字符
                if(totalNum==kNum){
                    maxLen=Math.max(maxLen,j-i+1);
                }
            }
        }
        return maxLen;
    }
}
