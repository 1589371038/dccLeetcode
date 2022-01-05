public class MaxBathTub {
//    一个int数组组成的柱状图，寻找它形成的最大容量的容器  木桶原理
//    思考：暴力遍历或者策略
//    双指针法，从两头起，将短板向内移动！
public int maxArea(int[] height) {
    if (height==null){return 0;}
int index1=0,index2=height.length-1;
    int maxVolumn=0;
while(index1<index2){
     int volumn=Math.min(height[index1],height[index2])*(index2-index1);
     maxVolumn=maxVolumn>volumn?maxVolumn:volumn;
     if (height[index1]<height[index2]){
         index1++;
     }
     else{
         index2--;
     }
}
return maxVolumn;
}
}
