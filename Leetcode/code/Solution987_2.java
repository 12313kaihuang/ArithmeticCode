package Leetcode.code;

import common.TreeNode;

import java.util.*;

@SuppressWarnings("unused")
public class Solution987_2 {

    List<NodeConfig> list = new LinkedList<>();

    //简化流程，一次排序
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        list.clear();
        dfs(root, 0, 0);

        list.sort((o1, o2) -> {
            if (o1.col != o2.col) return o1.col - o2.col;
            if (o1.depth != o2.depth) return o1.depth - o2.depth;
            return o1.val - o2.val;
        });

        List<List<Integer>> res = new ArrayList<>();
        int cur = list.get(0).col, index = -1;
        for (NodeConfig config : list) {
            if (config.col == cur && index >= 0) {
                res.get(index).add(config.val);
            } else {
                cur = config.col;
                index++;
                res.add(new ArrayList<>() {{
                    add(config.val);
                }});
            }
        }
        return res;
    }

    //遍历并记录每个节点所在的行、深度及对应值
    private void dfs(TreeNode root, int depth, int col) {
        if (root == null) return;
        list.add(new NodeConfig(depth, col, root.val));
        dfs(root.left, depth + 1, col - 1);
        dfs(root.right, depth + 1, col + 1);
    }

    static class NodeConfig {
        int depth;
        int col;
        int val;

        public NodeConfig(int depth, int col, int val) {
            this.depth = depth;
            this.col = col;
            this.val = val;
        }
    }
}
