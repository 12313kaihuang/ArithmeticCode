package Leetcode.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 783. 二叉搜索树节点最小距离
 * <p>
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 * <p>
 * 示例1：
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * <p>
 * 示例2：
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution783_1 {

    /**
     * 二叉搜索树的性质：
     * 1.若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
     * 2.若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
     * 3.任意节点的左、右子树也分别为二叉查找树；
     * 4.没有键值相等的节点。
     * <p>
     * 根据特性，中序遍历二叉树得到的会是一个单调递增的数列
     */
    public int minDiffInBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        if (root != null) midRead(nodes, root);
//        System.out.println(nodes);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nodes.size() - 1; i++) {
            int abs = Math.abs(nodes.get(i) - nodes.get(i + 1));
            if (abs < min) min = abs;
        }
        return min;
    }

    private void midRead(List<Integer> nodes, TreeNode root) {
        if (root.left != null) midRead(nodes, root.left);
        nodes.add(root.val);
        if (root.right != null) midRead(nodes, root.right);
    }

    public static void main(String[] args) {

    }

    static class TreeNode {
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
