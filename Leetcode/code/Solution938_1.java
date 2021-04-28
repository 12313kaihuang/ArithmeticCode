package Leetcode.code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 938. 二叉搜索树的范围和
 * <p>
 * 给定二叉搜索树的根结点root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * <p>
 * 示例 1：
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 * <p>
 * 示例 2：
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 * <p>
 * 提示：
 * 树中节点数目在范围 [1, 2 * 104] 内
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 * 所有 Node.val 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-of-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution938_1 {

    private int sum = 0;

    /**
     * 中序遍历二叉搜索树得到的是一个单调递增的数组，所以在遍历的过程中判断就可以了
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        search(root, low, high);
        return sum;
    }

    private void search(TreeNode root, int low, int high) {
        if (root == null) return;
        if (root.left != null) search(root.left, low, high);
        if (root.val >= low && root.val <= high) sum += root.val;
        if (root.right != null) search(root.right, low, high);
    }

    /**
     * 官方题解1 深度优先遍历
     */
    public int rangeSumBST2(TreeNode root, int low, int high) {
        if (root == null) return 0;
        //一定root.left.val < root.val < root.right.val 所以

        //若root.val > high，则其右子树的所有节点都不会满足要求，所以遍历左子树并在其上找符合要求的
        if (root.val > high) return rangeSumBST2(root.left, low, high);
        //同理若root.val < low，则其左子树的所有节点都不会满足要求，所以遍历右子树
        if (root.val < low) return rangeSumBST2(root.right, low, high);
        return root.val + rangeSumBST2(root.left, low, high) + rangeSumBST2(root.right, low, high);
    }

    /**
     * 官方题解2  广度优先遍历 这个感觉理解起来有点绕
     */
    public int rangeSumBST3(TreeNode root, int low, int high) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) continue;
            //原理同上rangeSumBST2
            if (node.val > high) queue.offer(node.left);
            else if (node.val < low) queue.offer(node.right);
            else {
                sum += node.val;
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return sum;
    }

    public class TreeNode {
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