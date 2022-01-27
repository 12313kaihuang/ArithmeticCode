package Leetcode.code;

import common.TreeNode;

/**
 * 617. 合并二叉树
 * <p>
 * 给你两棵二叉树： root1 和 root2 。
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。
 * 你需要将这两棵树合并成一棵新二叉树。
 * 合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；
 * 否则，不为 null 的节点将直接作为新二叉树的节点。
 * 返回合并后的二叉树。
 * <p>
 * 注意: 合并过程必须从两个树的根节点开始。
 * <p>
 * 示例 1：
 * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * 输出：[3,4,5,5,4,null,7]
 * <p>
 * 示例 2：
 * 输入：root1 = [1], root2 = [1,2]
 * 输出：[2,2]
 * <p>
 * 提示：
 * 两棵树中的节点数目在范围 [0, 2000] 内
 * -10^4 <= Node.val <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution617_1 {

    /**
     * dfs? self
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    /**
     * 严格来说题目要求合并成一个新的树，那么原树结构不应该发生变化
     * 所以每次创建一个新的节点
     */
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        //每次都new一个结点出来
        TreeNode root = new TreeNode();
        //某个结点为null时就看成是加上0
        root.val += (t1 == null) ? 0 : t1.val;
        root.val += (t2 == null) ? 0 : t2.val;
        //递归填充左右子树，如果某个结点已经为null了，就直接传入null和另外一个结点的左/右孩子
        root.left = mergeTrees((t1 == null) ? null : t1.left, (t2 == null) ? null : t2.left);
        root.right = mergeTrees((t1 == null) ? null : t1.right, (t2 == null) ? null : t2.right);
        return root;
    }
}
