//258. 各位相加
//给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
public class GeWeiXiangJia {
    public static int solution(int num){
        if(num<10){
            return num;
        }else {
            int carry=10;
            int newNum=0;
            while (num>0){
                newNum+=num%carry;
                num=num/10;
            }
            return solution(newNum);
        }
    }

    public static void main(String[] args) {
        int solution = solution(1238);
        System.out.println(solution);
    }
    int addDigits(int num)
    {
        if(0 == num % 9)
        {
            return 9;
        }
        return num % 9;
    }

}
