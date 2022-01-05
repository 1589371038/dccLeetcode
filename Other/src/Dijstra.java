import java.util.Scanner;

//0 1 12 -1 -1 -1
//-1 0 9 3 -1 -1
//-1 -1 0 -1 5 -1
//-1 -1 4 0 13 15
//-1 -1 -1 -1 0 4
//-1 -1 -1 -1 -1 0
public class Dijstra {
    public static void main(String[] args) {
        int[][] weight = new int[6][];

        String[] pointsStr = { "V1", "V2", "V3", "V4", "V5","V6"};
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < pointsStr.length; i++) {
            String[] valuesStr = input.nextLine().split(" ");
            int[] values = new int[valuesStr.length];
            for (int j = 0; j < valuesStr.length; j++) {
                values[j] = Integer.parseInt(valuesStr[j]);
            }
            weight[i] = values;
        }
        input.close();

        method(weight, pointsStr);
    }
// -1是不可到达，改成integer。maxvalue
    private static void method(int[][] weight, String[] pointsStr) {
        for(int i=0;i<weight.length;i++){
            for(int j=0;j<weight[0].length;j++){
                if(weight[i][j]==-1){
                    weight[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        boolean [] s=new boolean[pointsStr.length];
        int n=pointsStr.length;
        int []dist=new int[n];
        int []prev=new int[n];
        for(int i=0;i<n;i++){
            dist[i]=weight[0][i];
            s[i]=false;
            if(dist[i]==Integer.MAX_VALUE){
                prev[i]=-1;
            }
            else {
                prev[i]=0;
            }
        }
        dist[0]=0;
        s[0]=true;
        for(int i=1;i<n;i++){
            int mindist=Integer.MAX_VALUE;
            int u=0;
            for(int j=0;j<n;j++){
                if((!s[j])&&dist[j]<mindist){
                    u=j;
                    mindist=dist[j];
                }
            }
            s[u]=true;
            for(int j=0;j<n;j++){
                if((!s[j])&&weight[u][j]<Integer.MAX_VALUE){
                   if(dist[u]+weight[u][j]<dist[j]){
                       dist[j]=dist[u]+weight[u][j];
                       prev[j]=u;
                   }
                }
            }
        }
        for(int i=0;i<dist.length;i++){
            if(dist[i]==-1){
                System.out.println(9999);}
            else {
                System.out.println(dist[i]);
            }
        }



    }
}
