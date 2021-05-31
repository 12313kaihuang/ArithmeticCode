package Leetcode.code;


/**
 * 993. 二叉树的堂兄弟节点
 * <p>
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 * <p>
 * 提示：
 * 二叉树的节点数介于 2 到 100 之间。
 * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution993_1 {

    // x 和 y 的信息
    TreeNode xParent, yParent;
    int xDeep, yDeep;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, 0, null, x, y);
        return xDeep == yDeep && xParent != yParent;
    }

    // 前序遍历：根 - 左 - 右
    public void dfs(TreeNode node, int deep, TreeNode parent, int x, int y) {

        if (node == null) return;

        if (node.val == x) {
            xParent = parent;
            xDeep = deep;
        } else if (node.val == y) {
            yParent = parent;
            yDeep = deep;
        }

        dfs(node.left, deep + 1, node, x, y);
        dfs(node.right, deep + 1, node, x, y);
    }

    class TreeNode {
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