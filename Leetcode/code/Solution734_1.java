package Leetcode.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 743. 网络延迟时间
 * <p>
 * 有 n 个网络节点，标记为1到 n。
 * 给你一个列表times，表示信号经过 有向 边的传递时间。times[i] = (ui, vi, wi)，
 * 其中ui是源节点，vi是目标节点， wi是一个信号从源节点传递到目标节点的时间。
 * 现在，从某个节点K发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回-1 。
 * <p>
 * 示例 1：
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：times = [[1,2,1]], n = 2, k = 1
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：times = [[1,2,1]], n = 2, k = 2
 * 输出：-1
 * <p>
 * 提示：
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 0 <= wi <= 100
 * 所有 (ui, vi) 对都 互不相同（即，不含重复边）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/network-delay-time
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution734_1 {

    private Node[] nodes;

    //得解决环路产生得无限递归问题
    Set<Integer> pathSet = new HashSet<>();

    //超时了  也不知道对不对  22/52
    public int networkDelayTime(int[][] times, int n, int k) {
        nodes = new Node[n + 1];
        //构建节点数组
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        //加载路径
        for (int[] path : times) {
            nodes[path[0]].children.add(path[1]);
            nodes[path[0]].time.add(path[2]);
        }

        int maxTime = -1;
        for (int i = 1; i <= n; i++) {
            if (i == k) continue;
            int time = findPath(nodes[k], nodes[i], 0);
//            System.out.println(String.format("%d to %d cost %d", nodes[k].val, nodes[i].val, time));
            if (time == -1) return -1;
            else maxTime = Math.max(time, maxTime);
        }
        return maxTime;
    }


    /**
     * @return start到target得时间 + time
     */
    private int findPath(Node start, Node target, int time) {
        if (pathSet.contains(start.val)) return -1;
        if (start == target) {
            pathSet.remove(start.val);
            return time;
        }
        pathSet.add(start.val);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < start.children.size(); i++) {
            int t = findPath(nodes[start.children.get(i)], target,
                    time + start.time.get(i));
            if (t >= 0) {
                res = Math.min(t, res);
            }
        }
        pathSet.remove(start.val);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    static class Node {
        int val;
        List<Integer> children;
        List<Integer> time; //传递时间

        public Node(int val) {
            this.val = val;
            children = new ArrayList<>();
            time = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution734_1().networkDelayTime(new int[][]{{1, 2, 1}, {2, 3, 7}, {1, 3, 4}, {2, 1, 2}},
                3, 1));
//        System.out.println(new Solution734_1().networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}},
//                4, 2));
//        System.out.println(new Solution734_1().networkDelayTime(new int[][]{{1, 2, 1}}, 2, 1));
//        System.out.println(new Solution734_1().networkDelayTime(new int[][]{{1, 2, 1}}, 2, 2));
    }
}
