package Leetcode.code;


import common.TreeNode;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * <p>
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，
 * 以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树[3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *  /    \
 * 15     7
 * 返回锯齿形层序遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution103_1 {

    //深度遍历
    //奇数行翻转list即可
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        int deep = 0;
        while (!nodes.isEmpty()) {
            int n = nodes.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = nodes.poll();
                list.add(node.val);
                if (node.left!=null)nodes.offer(node.left);
                if (node.right!=null)nodes.offer(node.right);
            }
            if (deep % 2 == 1) {
                Collections.reverse(list);//翻转
            }
            deep++;
            result.add(list);
        }
        return result;
    }

}
