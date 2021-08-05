package Leetcode.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 802. 找到最终的安全状态
 * <p>
 * 在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。
 * 如果到达的节点是终点（即它没有连出的有向边），则停止。
 * 对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，
 * 则将该起始节点称作是 安全 的。返回一个由图中所有安全的起始节点组成的数组作为答案。
 * 答案数组中的元素应当按 升序 排列。
 * 该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是graph的节点数。
 * 图以下述形式给出：graph[i] 是编号 j 节点的一个列表，满足 (i, j) 是图的一条有向边。
 * <p>
 * 示例 1：
 * 输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * 输出：[2,4,5,6]
 * 解释：示意图如上。
 * <p>
 * 示例 2：
 * 输入：graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
 * 输出：[4]
 * <p>
 * <p>
 * 提示：
 * n == graph.length
 * 1 <= n <= 10^4
 * 0 <= graph[i].length <= n
 * graph[i] 按严格递增顺序排列。
 * 图中可能包含自环。
 * 图中边的数目在范围 [1, 4 * 104] 内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-eventual-safe-states
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution802_1 {

    /**
     * 用于标记节点状态：
     * 0 -> 未被标记
     * 1 -> 标记一次,用于判断是否有环路
     * 2 -> 标记为安全节点
     */
    int[] color;

    /**
     * 官方题解1 三色标记
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe(graph, i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    /**
     * @param x 这里x既是对应下标位置，也是对应节点值
     */
    private boolean safe(int[][] graph, int x) {
        if (color[x] > 0) return color[x] == 2; //进入这里就说明可能有环路
        color[x] = 1;
        //递归x可到达的节点
        for (int y : graph[x]) {
            if (!safe(graph, y)) return false;
        }
        color[x] = 2;
        return true;
    }
}
