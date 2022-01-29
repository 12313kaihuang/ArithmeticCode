package Leetcode.code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. 腐烂的橘子
 * <p>
 * 在给定的m x n网格grid中，每个单元格可以有以下三个值之一：
 * 值0代表空单元格；
 * 值1代表新鲜橘子；
 * 值2代表腐烂的橘子。
 * 每分钟，腐烂的橘子周围4 个方向上相邻 的新鲜橘子都会腐烂。
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回-1。
 * <p>
 * 示例 1：
 * 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * <p>
 * 示例 2：
 * 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * <p>
 * 示例 3：
 * 输入：grid = [[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 * <p>
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] 仅为0、1或2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotting-oranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution994_1 {

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    public int orangesRotting(int[][] grid) {
        int count = 0, ans = 0;
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>(); //存烂橘子
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
                else if (grid[i][j] == 1) {
                    //剪枝？
                    ++count;
                }
            }
        }
        if (count == 0) return 0;
        while (!queue.isEmpty() && count != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = cell[0] + dx[j];
                    int y = cell[1] + dy[j];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        --count;
                        grid[x][y] = 2;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            ans++;
        }
        return count <= 0 ? ans : -1;
    }
}
