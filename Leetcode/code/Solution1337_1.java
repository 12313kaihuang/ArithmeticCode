package Leetcode.code;

import java.util.*;

/**
 * 1337. 矩阵中战斗力最弱的 K 行
 * <p>
 * 给你一个大小为m * n的矩阵mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 * 请你返回矩阵中战斗力最弱的k行的索引，按从最弱到最强排序。
 * 如果第i行的军人数量少于第j行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 * <p>
 * 示例 1：
 * 输入：mat =
 * [[1,1,0,0,0],
 * [1,1,1,1,0],
 * [1,0,0,0,0],
 * [1,1,0,0,0],
 * [1,1,1,1,1]],
 * k = 3
 * 输出：[2,0,3]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 2
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 2
 * 行 4 -> 5
 * 从最弱到最强对这些行排序后得到 [2,0,3,1,4]
 * <p>
 * 示例 2：
 * 输入：mat =
 * [[1,0,0,0],
 * [1,1,1,1],
 * [1,0,0,0],
 * [1,0,0,0]],
 * k = 2
 * 输出：[0,2]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 1
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 1
 * 从最弱到最强对这些行排序后得到 [0,2,3,1]
 * <p>
 * 提示：
 * m == mat.length
 * n == mat[i].length
 * 2 <= n, m <= 100
 * 1 <= k <= m
 * matrix[i][j] 不是 0 就是 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution1337_1 {

    public int[] kWeakestRows(int[][] mat, int k) {
        List<int[]> list = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            //存储战力值，所处index
            list.add(new int[]{findLastSolderPos(mat[i]) + 1, i});
        }
        list.sort(Comparator.comparingInt(o -> o[0]));
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i)[1];
        }
        return res;
    }

    /**
     * 二分 + 堆
     * <p>
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/solution/gong-shui-san-xie-yi-ti-shuang-jie-po-su-7okx/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int[] kWeakestRows2(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            return b[1] - a[1];
        });
        for (int i = 0; i < m; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (mat[i][mid] >= 1) l = mid;
                else r = mid - 1;
            }
            int cur = mat[i][r] >= 1 ? r + 1 : r;
            if (q.size() == k && q.peek()[0] > cur) q.poll();
            if (q.size() < k) q.add(new int[]{cur, i});
        }
        int[] ans = new int[k];
        int idx = k - 1;
        while (!q.isEmpty()) ans[idx--] = q.poll()[1];
        return ans;
    }

    //n>=2，鉴于数组是有规律的所以可以使用二分法来查找最后一个军人的位置
    private int findLastSolderPos(int[] mat) {
        int start = 0, end = mat.length - 1;
        if (mat[start] == 0) return -1;
        int mid;
        while (start < end - 1) {
            mid = (start + end) / 2;
//            System.out.println("prev = " + mat[mid] + ", " + start + ", " + end);
            if (mat[mid] == 1) start = mid;
            else end = mid - 1;
        }
        return mat[end] == 1 ? end : start;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution1337_1().findLastSolderPos(new int[]{1, 1, 0, 0, 0}));
//        System.out.println(new Solution1337_1().findLastSolderPos(new int[]{1, 1, 1, 1, 0}));
//        System.out.println(new Solution1337_1().findLastSolderPos(new int[]{1, 0, 0, 0, 0}));
        System.out.println(new Solution1337_1().findLastSolderPos(new int[]{1, 1, 0, 0, 0}));
//        System.out.println(new Solution1337_1().findLastSolderPos(new int[]{1, 1, 1, 1, 1}));
    }
}
