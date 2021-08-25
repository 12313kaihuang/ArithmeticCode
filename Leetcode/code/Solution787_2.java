package Leetcode.code;

import java.util.Arrays;

@SuppressWarnings("unused")
public class Solution787_2 {


    /**
     * 官方题解 路子有点玄学 = =
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/cheapest-flights-within-k-stops/solution/k-zhan-zhong-zhuan-nei-zui-bian-yi-de-ha-abzi/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 10000 * 101 + 1; //极大值
        int[][] f = new int[k + 2][n];  //f[i][j]表示乘坐i趟航班到达j所花费的最小值
        for (int i = 0; i < k + 2; i++) Arrays.fill(f[i], INF);
        f[0][src] = 0;

        //k是中转数，所以最多乘坐k+1次航班,i从1开始（细节）
        for (int i = 1; i <= k + 1; i++) {
            for (int[] flight : flights) {
                f[i][flight[1]] = Math.min(f[i][flight[1]], f[i - 1][flight[0]] + flight[2]);
                System.out.println(String.format("f[%d][%d]=%d", i, flight[1], f[i][flight[1]]));
            }
        }
        int ans = INF;
        for (int i = 1; i <= k + 1; i++) {
            ans = Math.min(ans, f[i][dst]);
        }
        return ans == INF ? -1 : ans;
    }

    /**
     * 使用两个一维数组进行状态转移。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/cheapest-flights-within-k-stops/solution/k-zhan-zhong-zhuan-nei-zui-bian-yi-de-ha-abzi/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 10000 * 101 + 1;
        int[] f = new int[n];
        Arrays.fill(f, INF);
        f[src] = 0;
        int ans = INF;
        for (int t = 1; t <= k + 1; ++t) {
            int[] g = new int[n];
            Arrays.fill(g, INF);
            for (int[] flight : flights) {
                int j = flight[0], i = flight[1], cost = flight[2];
                g[i] = Math.min(g[i], f[j] + cost);
            }
            f = g;
            ans = Math.min(ans, f[dst]);
        }
        return ans == INF ? -1 : ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution787_2().findCheapestPrice(3,
                new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}},
                0, 2, 1));
    }
}
