package Leetcode.code;

/**
 * 787. K 站中转内最便宜的航班
 * <p>
 * 有 n 个城市通过一些航班连接。给你一个数组flights ，其中flights[i] = [fromi, toi, pricei] ，
 * 表示该航班都从城市 fromi 开始，以价格 pricei 抵达 toi。
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k站中转的路线，
 * 使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
 * <p>
 * 示例 1：
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * 输出: 200
 * <p>
 * 示例 2：
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * 输出: 500
 * <p>
 * 提示：
 * 1 <= n <= 100
 * 0 <= flights.length <= (n * (n - 1) / 2)
 * flights[i].length == 3
 * 0 <= fromi, toi < n
 * fromi != toi
 * 1 <= pricei <= 104
 * 航班没有重复，且不存在自环
 * 0 <= src, dst, k < n
 * src != dst
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cheapest-flights-within-k-stops
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution787_1 {

    static int sN;
    static int[][] sMatrix;
    static int ans = -1;

    /**
     * 需要注意环路
     * <p>
     * 超时了
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        sN = n;
        ans = -1;
        sMatrix = new int[n][n];
        for (int[] flight : flights) sMatrix[flight[0]][flight[1]] = flight[2];
        dfs(src, dst, 0, k);
        return ans;
    }

    private void dfs(int src, int dst, int cost, int k) {
        if (src == dst) {
            ans = ans == -1 ? cost : Math.min(ans, cost);
            return;
        } else if (k < 0) return;

        for (int i = 0; i < sN; i++) {
            if (sMatrix[src][i] > 0) {
                int temp = sMatrix[i][src];
                sMatrix[i][src] = 0; //因为有k的限制，所以可以不解决环路问题 但是及时这样也会超时 = =
                dfs(i, dst, cost + sMatrix[src][i], k - 1);
                sMatrix[i][src] = temp;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution787_1().findCheapestPrice(3,
                new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}},
                0, 2, 1));
        System.out.println(new Solution787_1().findCheapestPrice(3,
                new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}},
                0, 2, 0));
        System.out.println(new Solution787_1().findCheapestPrice(3,
                new int[][]{{0, 1, 100}, {1, 0, 100}, {1, 2, 100}, {0, 2, 500}},
                0, 2, 1));
    }
}
