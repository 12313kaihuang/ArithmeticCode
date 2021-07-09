package Leetcode.others;

import java.util.*;

/**
 * LCP 07. 传递信息
 * <p>
 * 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
 * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
 * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
 * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
 * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
 * <p>
 * 示例 1：
 * 输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3
 * [[0,2],[0,4],[1,4],[2,0],[2,1],[2,3],[3,4]], k = 3
 * 输出：3
 * 解释：信息从小 A 编号 0 处开始，经 3 轮传递，到达编号 4。共有 3 种方案，分别是 0->2->0->4， 0->2->1->4， 0->2->3->4。
 * <p>
 * 示例 2：
 * 输入：n = 3, relation = [[0,2],[2,1]], k = 2
 * 输出：0
 * 解释：信息不能从小 A 处经过 2 轮传递到编号 2
 * <p>
 * 限制：
 * 2 <= n <= 10
 * 1 <= k <= 5
 * 1 <= relation.length <= 90, 且 relation[i].length == 2
 * 0 <= relation[i][0],relation[i][1] < n 且 relation[i][0] != relation[i][1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chuan-di-xin-xi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionLCP07_1 {


    /**
     * BFS 广度优先
     * <p>
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/chuan-di-xin-xi/solution/gong-shui-san-xie-tu-lun-sou-suo-yu-dong-cyxo/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int numWays(int n, int[][] rs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] r : rs) {
            int a = r[0], b = r[1];
            Set<Integer> s = map.getOrDefault(a, new HashSet<>());
            s.add(b);
            map.put(a, s);
        }

        Deque<Integer> d = new ArrayDeque<>();
        d.addLast(0);
        while (!d.isEmpty() && k-- > 0) {
            int size = d.size();
            while (size-- > 0) {
                int poll = d.pollFirst();
                Set<Integer> es = map.get(poll);
                if (es == null) continue;
                for (int next : es) {
                    d.addLast(next);
                }
            }
        }

        //结束后d中存的是k步从0能到的位置
        int ans = 0;
        while (!d.isEmpty()) {
            if (d.pollFirst() == n - 1) ans++;
        }
        return ans;
    }

    Map<Integer, Set<Integer>> map = new HashMap<>();
    int n, k, ans;

    /**
     * DFS深度优先
     * <p>
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/chuan-di-xin-xi/solution/gong-shui-san-xie-tu-lun-sou-suo-yu-dong-cyxo/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int numWays3(int _n, int[][] rs, int _k) {
        n = _n;
        k = _k;
        for (int[] r : rs) {
            int a = r[0], b = r[1];
            Set<Integer> s = map.getOrDefault(a, new HashSet<>());
            s.add(b);
            map.put(a, s);
        }
        dfs(0, 0);
        return ans;
    }

    void dfs(int u, int sum) {
        if (sum == k) {
            if (u == n - 1) ans++;
            return;
        }
        Set<Integer> es = map.get(u);
        if (es == null) return;
        for (int next : es) {
            dfs(next, sum + 1);
        }
    }

    /**
     * 动态规划
     * <p>
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/chuan-di-xin-xi/solution/gong-shui-san-xie-tu-lun-sou-suo-yu-dong-cyxo/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int numWays2(int n, int[][] relation, int k) {
        int[][] f = new int[k + 1][n];  //f[i][j]表示走i步到j的方案数
        f[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int[] r : relation) {
                int a = r[0], b = r[1];
                f[i][b] += f[i - 1][a];
            }
        }
        return f[k][n - 1];
    }


}
