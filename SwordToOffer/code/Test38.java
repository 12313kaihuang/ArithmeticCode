package ArithmeticCode.SwordToOffer.code;

import ArithmeticCode.common.TreeNode;

/**
 * Created by Hy on 2020/01/14 10:03
 * <p>
 * 平衡二叉树
 */
public class Test38 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return Math.abs(left - right) <= 1 && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getDepth(node.left), getDepth(node.right));
    }

    public boolean IsBalanced_Solution2(TreeNode root) {
        return getDepth2(root) != -1;
    }

    /**
     * 利用递归的特性（自底向上），
     * 当发现子树不是平衡二叉树时直接返回-1并依次传递到根节点处。（剪枝）
     */
    private int getDepth2(TreeNode node) {
        if (node == null) return 0;
        int left = getDepth2(node.left);
        if (left == -1) return -1;
        int right = getDepth2(node.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}
