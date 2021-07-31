package Leetcode.code;

import common.TreeNode;

import java.util.*;

/**
 * 987. 二叉树的垂序遍历
 * <p>
 * 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
 * 对位于(row, col)的每个结点而言，其左右子结点分别位于(row + 1, col - 1)和(row + 1, col + 1) 。
 * 树的根结点位于 (0, 0) 。
 * <p>
 * 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，
 * 形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。
 * 返回二叉树的 垂序遍历 序列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution987_1 {

    Map<Integer, List<NodeConfig>> map = new HashMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map.clear();
        dfs(root, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> cols = new LinkedList<>(map.keySet());
        Collections.sort(cols);
        for (int col : cols) {
            List<NodeConfig> configs = new LinkedList<>(map.get(col));
            configs.sort((o1, o2) -> o1.depth == o2.depth ? o1.val - o2.val : o1.depth - o2.depth);
            List<Integer> vals = new ArrayList<>();
            configs.forEach(nodeConfig -> vals.add(nodeConfig.val));
            res.add(vals);
        }
        return res;
    }

    //遍历并记录每个节点所在的行、深度及对应值
    private void dfs(TreeNode root, int depth, int col) {
        if (root == null) return;
        map.putIfAbsent(col, new LinkedList<>());
        List<NodeConfig> list = map.get(col);
        list.add(new NodeConfig(depth, root.val));
        dfs(root.left, depth + 1, col - 1);
        dfs(root.right, depth + 1, col + 1);
    }

    static class NodeConfig {
        int depth;
        int val;

        public NodeConfig(int depth, int val) {
            this.depth = depth;
            this.val = val;
        }
    }
}
