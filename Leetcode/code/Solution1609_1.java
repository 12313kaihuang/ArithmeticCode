package Leetcode.code;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1609. 奇偶树
 * <p>
 * 如果一棵二叉树满足下述几个条件，则可以称为 奇偶树 ：
 * 二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
 * 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
 * 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
 * 给你二叉树的根节点，如果二叉树为 奇偶树 ，则返回 true ，否则返回 false 。
 * <p>
 * 示例 1：
 * 输入：root = [1,10,4,3,null,7,9,12,8,6,null,null,2]
 * 输出：true
 * 解释：每一层的节点值分别是：
 * 0 层：[1]
 * 1 层：[10,4]
 * 2 层：[3,7,9]
 * 3 层：[12,8,6,2]
 * 由于 0 层和 2 层上的节点值都是奇数且严格递增，而 1 层和 3 层上的节点值都是偶数且严格递减，因此这是一棵奇偶树。
 * <p>
 * 示例 2：
 * 输入：root = [5,4,2,3,3,7]
 * 输出：false
 * 解释：每一层的节点值分别是：
 * 0 层：[5]
 * 1 层：[4,2]
 * 2 层：[3,3,7]
 * 2 层上的节点值不满足严格递增的条件，所以这不是一棵奇偶树。
 * <p>
 * 示例 3：
 * 输入：root = [5,9,1,3,5,7]
 * 输出：false
 * 解释：1 层上的节点值应为偶数。
 * <p>
 * 示例 4：
 * 输入：root = [1]
 * 输出：true
 * <p>
 * 示例 5：
 * 输入：root = [11,8,6,1,3,9,11,30,20,18,16,12,10,4,2,17]
 * 输出：true
 * <p>
 * 提示：
 * 树中节点数在范围 [1, 10^5] 内
 * 1 <= Node.val <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/even-odd-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution1609_1 {
    //层次遍历
    public boolean isEvenOddTree(TreeNode root) {
        int deep = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            int count = nodeQueue.size();
            TreeNode last = null;
            List<Integer> nodes = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TreeNode node = nodeQueue.poll();
                nodes.add(node.val);
                if (node.left != null) nodeQueue.offer(node.left);
                if (node.right != null) nodeQueue.offer(node.right);
            }
            if (!check(nodes, (deep & 1) == 0)) return false;
            deep++;
        }
        return true;
    }

    public boolean isEvenOddTree2(TreeNode root) {
        int deep = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            int count = nodeQueue.size();
            int prev = (deep & 1) == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = 0; i < count; i++) {
                TreeNode node = nodeQueue.poll();
                if ((deep & 1) == (node.val & 1)) return false;  //优化判断1
                if (((deep & 1) == 0 && node.val <= prev)
                        || ((deep & 1) == 1 && node.val >= prev)) return false; //优化判断2
                prev = node.val;
                if (node.left != null) nodeQueue.offer(node.left);
                if (node.right != null) nodeQueue.offer(node.right);
            }
            deep++;
        }
        return true;
    }

    private boolean check(List<Integer> nodes, boolean odd) {
        int index = 0;
        System.out.println("check:" + nodes + "," + odd);
        if ((nodes.get(0) & 1) == (odd ? 0 : 1)) return false;
        while (index < nodes.size() - 1
                && (odd ? nodes.get(index) < nodes.get(index + 1) : nodes.get(index) > nodes.get(index + 1))
                && (nodes.get(index + 1) & 1) == (odd ? 1 : 0)) index++;
        return index == nodes.size() - 1;
    }
}
