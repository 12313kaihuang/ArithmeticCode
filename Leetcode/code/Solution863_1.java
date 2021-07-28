package Leetcode.code;

import common.TreeNode;

import java.util.*;

/**
 * 863. 二叉树中所有距离为 K 的结点
 * <p>
 * 给定一个二叉树（具有根结点root），一个目标结点target，和一个整数值 K 。
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution863_1 {

    //因为每个节点值具有唯一性，所以可以用来当key
    //用于存储夫节点
    private Map<Integer, TreeNode> parentMap = new HashMap<>();
    List<Integer> res = new ArrayList<>();

    /**
     * 官方题解
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        res.clear();
        findParents(root);
        findNode(target, null, 0, k);
        return res;
    }

    //构建parentMap
    private void findParents(TreeNode root) {
        if (root.left != null) {
            parentMap.put(root.left.val, root);
            findParents(root.left);
        }
        if (root.right != null) {
            parentMap.put(root.right.val, root);
            findParents(root.right);
        }
    }

    /**
     * 查找目标子树
     *
     * @param node  当前节点
     * @param from  从哪个节点来当，用于避免无限递归
     * @param depth 当前距离
     * @param k     目标距离
     */
    private void findNode(TreeNode node, TreeNode from, int depth, int k) {
        if (node == null) return;
//        System.out.println(String.format("add %d,from %d,%d,%k", node.val, from.val, depth, k));
        if (depth == k) {
            res.add(node.val);
            return;
        }

        //这里判断是否==from是因为，例如 1 3 5 from为3
        //3这里会调用findNode(1,3,x,x)，若不判断from当话又会调用到findNode(3,1,x,x);
        //会产生无限递归调用
        if (node.left != from) {
            findNode(node.left, node, depth + 1, k);
        }
        if (node.right != from) {
            findNode(node.right, node, depth + 1, k);
        }

        TreeNode parent = parentMap.get(node.val);
        if (parent != from) {
            findNode(parent, node, depth + 1, k);
        }
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
