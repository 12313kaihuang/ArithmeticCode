package Leetcode.code;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class Solution987_3 {

    List<int[]> list = new LinkedList<>();

    //改用自定义数组
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        list.clear();
        dfs(root, 0, 0);

        list.sort((o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            if (o1[1] != o2[1]) return o1[1] - o2[1];
            return o1[2] - o2[2];
        });
//        for (int[] config : list) {
//            System.out.println(Arrays.toString(config));
//        }

        List<List<Integer>> res = new ArrayList<>();
        int cur = list.get(0)[0], index = -1;
        for (int[] config : list) {
            if (config[0] == cur && index >= 0) {
                res.get(index).add(config[2]);
            } else {
                cur = config[0];
                index++;
                res.add(new ArrayList<>() {{
                    add(config[2]);
                }});
            }
        }
        return res;
    }

    //遍历并记录每个节点所在的行、深度及对应值
    private void dfs(TreeNode root, int depth, int col) {
        if (root == null) return;
        list.add(new int[]{col, depth, root.val});
        dfs(root.left, depth + 1, col - 1);
        dfs(root.right, depth + 1, col + 1);
    }
}
