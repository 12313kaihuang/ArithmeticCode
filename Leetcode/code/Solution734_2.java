package Leetcode.code;

@SuppressWarnings("unused")
public class Solution734_2 {

    int N = 110;
    int[][] matrix = new int[N][N];
    int INF = 0x3f3f3f3f;
    int n, k;

    /**
     * floyd 邻接矩阵  O(n^3)
     * <p>
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/network-delay-time/solution/gong-shui-san-xie-yi-ti-wu-jie-wu-chong-oghpz/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int networkDelayTime(int[][] times, int _n, int _k) {
        n = _n;
        k = _k;
        //初始化矩阵值，w[i][j] 表示从i到j所需最短时间
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
        floyd();
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, matrix[k][i]);
        }
        return res >= INF / 2 ? -1 : res;
    }

    void floyd() {
        for (int p = 1; p <= n; p++) { //中间节点
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    //floyd 状态转换方程，基于动态规划
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][p] + matrix[p][j]);
                }
            }
        }
    }


}
