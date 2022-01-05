//两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
//

//给出两个整数 x 和 y，计算它们之间的汉明距离。
public class HanMingDistance {

    public int hammingDistance(int x, int y) {
        int yiHuo=x^y;  //异或之后1的数量
        int count=0;
        while(yiHuo>0){
            if((yiHuo&1)==1){
            count++;
            }
            yiHuo=yiHuo>>1;
        }
        return count;

    }
}
