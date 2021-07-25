package Others.interview;

import java.util.Stack;

/**
 * 求两个叶子节点的公共祖先节点
 */
public class BaiduTest2 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //应该没什么问题  就是复杂度可能会有点高
    public TreeNode findParent(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (findNode(node.left, node1) && findNode(node.right, node2)) return node;
            if (findNode(node.left, node2) && findNode(node.right, node1)) return node;
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return null;
    }

    private boolean findNode(TreeNode root, TreeNode target) {
        if (root == null) return false;
        if (root == target) return true;
        return findNode(root.left, target) || findNode(root.right, target);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(new BaiduTest2().findParent(root, root.right.left, root.right.right).val);
    }
}
