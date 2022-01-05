public class Dijstra_lh {
    private static  final int INF =Integer.MAX_VALUE;
    public static void dijkstra(int v0, int end, int[] prev, int[] dist, int nodeNum,int[][]  mMatrix) {

        boolean[] S = new boolean[nodeNum];                                  // 判断是否已存入该点到S集合中
        int n = nodeNum;
        for (int i = 0; i < n; ++i) {
            dist[i] = mMatrix[v0][i];
            S[i] = false;                                // 初始都未用过该点
            if (dist[i] == INF)
                prev[i] = -1;
            else
                prev[i] = v0;
        }
        dist[v0] = 0;
        S[v0] = true;
        for (int i = 1; i < n; i++) {
            int mindist = INF;
            int u = v0;                           // 找出当前未使用的点j的dist[j]最小值
            for (int j = 0; j < n; ++j)
                if ((!S[j]) && dist[j] < mindist) {
                    u = j;                             // u保存当前邻接点中距离最小的点的号码
                    mindist = dist[j];
                }
            S[u] = true;
            for (int j = 0; j < n; j++)
                if ((!S[j]) && mMatrix[u][j] < INF) {
                    if (dist[u] + mMatrix[u][j] < dist[j])     //在通过新加入的u点路径找到离v0点更短的路径
                    {
                        dist[j] = dist[u] + mMatrix[u][j];    //更新dist
                        prev[j] = u;                    //记录前驱顶点
                    }
                }
        }
        for (int i = 0; i <prev.length; i++) {
            System.out.print(prev[i]+" ");
        }
        System.out.println();
        //searchPath(prev, v0, end,nodeNum);


    }
}
