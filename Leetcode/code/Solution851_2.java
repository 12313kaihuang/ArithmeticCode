package Leetcode.code;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("unused")
public class Solution851_2 {

    /**
     * 拓扑排序
     *
     * 作者：LeetCode-Solution
     *     链接：https://leetcode-cn.com/problems/loud-and-rich/solution/xuan-nao-he-fu-you-by-leetcode-solution-jnzm/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; ++i) {
            g[i] = new ArrayList<Integer>();
        }
        int[] inDeg = new int[n];
        for (int[] r : richer) {
            g[r[0]].add(r[1]);
            ++inDeg[r[1]];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = i;
        }
        Queue<Integer> q = new ArrayDeque<Integer>();
        for (int i = 0; i < n; ++i) {
            if (inDeg[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int y : g[x]) {
                if (quiet[ans[x]] < quiet[ans[y]]) {
                    ans[y] = ans[x]; // 更新 x 的邻居的答案
                }
                if (--inDeg[y] == 0) {
                    q.offer(y);
                }
            }
        }
        return ans;
    }


}
