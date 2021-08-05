package Leetcode.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("unused")
public class Solution802_2 {

    /**
     * 官方题解2 拓扑排序
     * <p>
     * 根据题意，若一个节点没有出边，则该节点是安全的；若一个节点出边相连的点都是安全的，则该节点也是安全的。
     * 根据这一性质，我们可以将图中所有边反向，得到一个反图，然后在反图上运行拓扑排序。
     * 具体来说，首先得到反图 rg 及其入度数组 inDeg。将所有入度为 0 的点加入队列，然后不断取出队首元素，
     * 将其出边相连的点的入度减一，若该点入度减一后为 0，则将该点加入队列，如此循环直至队列为空。
     * 循环结束后，所有入度为 0 的节点均为安全的。我们遍历入度数组，并将入度为 0 的点加入答案列表。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/find-eventual-safe-states/solution/zhao-dao-zui-zhong-de-an-quan-zhuang-tai-yzfz/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] inDeg = new int[n]; //入度表
        List<List<Integer>> rg = new ArrayList<>(); //用户记录反图
        //构建反图与入度表
        for (int i = 0; i < n; i++) rg.add(new ArrayList<>());
        for (int x = 0; x < n; x++) {
            for (int y : graph[x]) {
                rg.get(y).add(x);
            }
            inDeg[x] = graph[x].length;
        }

        //将入度为0的节点入队
        Queue<Integer> queue = new LinkedList<>();
        for (int x = 0; x < n; x++) {
            if (inDeg[x] == 0) queue.offer(x);
        }

        //拓扑排序
        while (!queue.isEmpty()) {
            Integer y = queue.poll();
            for (int x : rg.get(y)) {
                if (--inDeg[x] == 0) { //若去除y节点后，x节点入度也为0了，那就也将x加入队列
                    queue.offer(x);
                }
            }
        }

        //返回所有入度为0的节点
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0) ans.add(i);
        }
        return ans;
    }
}
