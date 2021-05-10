package Leetcode.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. 叶子相似的树
 * <p>
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个叶值序列 。
 * <p>
 * 举个例子，如上图所示，给定一棵叶值序列为(6, 7, 4, 9, 8)的树。
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是叶相似的。
 * 如果给定的两个根结点分别为root1 和root2的树是叶相似的，则返回true；否则返回 false 。
 * <p>
 * 示例 1：
 * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：root1 = [1], root2 = [1]
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：root1 = [1], root2 = [2]
 * 输出：false
 * <p>
 * 示例 4：
 * 输入：root1 = [1,2], root2 = [2,2]
 * 输出：true
 * <p>
 * 示例 5：
 * 输入：root1 = [1,2,3], root2 = [1,3,2]
 * 输出：false
 * <p>
 * 提示：
 * 给定的两棵树可能会有1到 200个结点。
 * 给定的两棵树上的值介于 0 到 200 之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/leaf-similar-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution872_1 {
    private List<Integer> leaves;

    /**
     * 其实考点在于树的遍历，找出所有根节点然后比较即可
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.9 MB, 在所有 Java 提交中击败了96.98%的用户
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1Leaves = new ArrayList<>();
        List<Integer> root2Leaves = new ArrayList<>();
        getLeaves(root1, root1Leaves);
        getLeaves(root2, root2Leaves);
        return root1Leaves.equals(root2Leaves);
    }

    //中序遍历找到符合要求的根节点并加入列表
    //题解里面叫dfs？深度优先可以理解为先左搜到底；广度优先是一层一层搜
    private void getLeaves(TreeNode root, List<Integer> leaves) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        } else {
            if (root.left != null) getLeaves(root.left, leaves);
            if (root.right != null) getLeaves(root.right, leaves);
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
