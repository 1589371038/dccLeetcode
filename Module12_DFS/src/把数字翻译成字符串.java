/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，
 * 1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。
 * 请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * 思路：典型的dfs，String类型直接参数传过去都不用回溯
 * 数字和字符的map规则是 '0'=48  a = 97  num+49
 * 不不不，String拼的结果都不需要传过去，只需要统计个数
 *
 */

public class 把数字翻译成字符串 {
    int count = 0;
    public int translateNum(int num) {
        String numS = String.valueOf(num);
        dfs(numS, 0);
        return count;
    }

    private void dfs(String nums, int i) {
        if(i == nums.length()){
            count++;
            return;
        }
        dfs(nums, i+1); // 单个字母的翻译 o-9，进入下一步
        if(i+1<nums.length()){
            int towNum = Integer.parseInt(nums.substring(i, i + 2));
            if(towNum<26 && towNum>10){
                dfs(nums,i+2);
            }
        }
    }
}
