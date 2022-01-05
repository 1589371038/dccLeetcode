public class ISBracketsInvalid {
//    题目：20.有效的括号
//    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//有效字符串需满足：
//1左括号必须用相同类型的右括号闭合。
//2左括号必须以正确的顺序闭合。
//3注意空字符串可被认为是有效字符串。
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/valid-parentheses
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
//    思路：so easy！第一 数量要对的上，第二顺序要对的上
//    怎么办呢？设置3个index，出现左括号就+1，右括号就-1，若中途index变成负数，false！ 若最后index！=0，false！
//    只要查一下ascii码表，三种括号的码就行啦！action！
//    ()40 41  []91 93  {} 123 125
//    后来证明这种方法有漏洞([)]顺序也对，数量也对，但是invalid
public boolean isValid(String s) {
if(s==null){
    return true;
}
int index1=0,index2=0,index3=0;
for(int i=0;i<s.length();i++){
    char ch=s.charAt(i);
    switch (ch){
        case 40:
            index1++;
            break;
        case 41:
            index1--;
            break;
        case 91:
            index2++;
            break;
        case 93:
            index2--;
            break;
        case 123:
            index3++;
            break;
        case 125:
            index3--;
            break;
        default: return false;
    }
    if(index1<0||index2<0||index3<0){
        return false;
    }
}
    if(index1!=0||index2!=0||index3!=0){
        return false;
    }
    return true;
}
}
