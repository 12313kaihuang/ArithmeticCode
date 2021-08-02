package Leetcode.code;

import java.util.Arrays;

@SuppressWarnings("unused")
public class Solution734_3 {

    int N = 110;
    int[][] matrix = new int[N][N];  //矩阵
    int[] dist = new int[N];
    boolean[] vis = new boolean[N];
    int INF = 0x3f3f3f3f;
    int n, k;

    /**
     * dijkstra O(n^2)
     * <p>
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/network-delay-time/solution/gong-shui-san-xie-yi-ti-wu-jie-wu-chong-oghpz/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int networkDelayTime(int[][] times, int _n, int _k) {
        n = _n;
        k = _k;
        //矩阵初始化值
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = matrix[j][i] = i == j ? 0 : INF;
            }
        }
        //遍历times并赋值
        for (int[] t : times) {
            int u = t[0], v = t[1], c = t[2];
            matrix[u][v] = c;
        }
        dijkstra();
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i]);
        }
        return ans > INF / 2 ? -1 : ans;
    }

    void dijkstra() {
        Arrays.fill(vis, false); //应该是用来避免环路的？
        Arrays.fill(dist, INF);
        dist[k] = 0;  //dist[i]表示k到i到最短路径和
        for (int p = 1; p <= n; p++) {
            int t = -1;
            //遍历dist，找出当前距离k最近的一个节点t作为中间节点
            for (int i = 1; i <= n; i++) {
                if (!vis[i] && (t == -1 || dist[i] < dist[t])) t = i;
            }

            vis[t] = true;
            for (int i = 1; i <= n; i++) {
                dist[i] = Math.min(dist[i], dist[t] + matrix[t][i]);
            }
        }
    }


}
