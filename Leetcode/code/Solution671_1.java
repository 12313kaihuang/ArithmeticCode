package Leetcode.code;

import common.TreeNode;

import java.util.Stack;

/**
 * 671. 二叉树中第二小的节点
 * <p>
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为2或0。
 * 如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * <p>
 * 提示：
 * 树中节点数目在范围 [1, 25] 内
 * 1 <= Node.val <= 2^31 - 1
 * 对于树中每个节点 root.val == min(root.left.val, root.right.val)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution671_1 {

    //根据题意，root.val 肯定是最小到，所以遍历找到再小的值就是第二小的
    //广搜
    public int findSecondMinimumValue(TreeNode root) {
        int min = root.val, rootVal = min;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left == null) continue;
            //因为存在两个字节点都等于root.val都情况，所以两个if判断需要分开
            if (node.left.val == rootVal) {
                //right.val >= rootVal，此时第二小的值要么是right.val，要么就在left子树中
                stack.push(node.left);
                if (node.right.val != rootVal)
                    min = min == rootVal ? node.right.val : Math.min(min, node.right.val);
            }
            if (node.right.val == rootVal) {
                //同理
                stack.push(node.right);
                if (node.left.val != rootVal)
                    min = min == rootVal ? node.left.val : Math.min(min, node.left.val);
            }
        }
        return min == rootVal ? -1 : min;
    }

    //深搜
    private int min = -1;
    private int rootVal;

    public int findSecondMinimumValue2(TreeNode root) {
        min = -1;
        rootVal = root.val;
        dfs(root);
        return min;
    }

    private void dfs(TreeNode root) {
        if (root.left == null) return;
        if (root.left.val == rootVal) {
            if (root.right.val != rootVal) {
                min = min == -1 ? root.right.val : Math.min(min, root.right.val);
            }
            dfs(root.left);
        }
        if (root.right.val == rootVal) {
            if (root.left.val != rootVal) {
                min = min == -1 ? root.left.val : Math.min(min, root.left.val);
            }
            dfs(root.right);
        }
    }
}
