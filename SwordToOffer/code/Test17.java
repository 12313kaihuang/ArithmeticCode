package ArithmeticCode.SwordToOffer.code;

import ArithmeticCode.common.TreeNode;

/**
 * Created by Hy on 2019/12/04 20:00
 * <p>
 * 树的子结构
 */
public class Test17 {

    public class Solution {
        public boolean HasSubtree(TreeNode root1, TreeNode root2) {
            //这里root2为null时返回false的原因是题目要求 空树不是任意一个树的子结构
            if (root1 == null || root2 == null) return false;
            return isSubTree(root1, root2)
                    || HasSubtree(root1.left, root2)
                    || HasSubtree(root1.right, root2);
        }

        /**
         * 判断root2是否是root1的子树
         *
         * @param root1 root1
         * @param root2 root2
         * @return root2是否是root1的子树
         */
        private boolean isSubTree(TreeNode root1, TreeNode root2) {
            //这里root2（a）的并不完全是HasSubtree中的root2（b） 而是root2或root2的子树，
            //但是因为HasSubtree加了判断了，所以如果此时root2为null，那么必定是原root2的子节点
            //所以当root2为null时，说明原root2遍历到根节点了，所以返回true
            //注意这里应当先判断root2 因为当root1 root2同时为null时，依然应该返回true
            if (root2 == null) return true;
            if (root1 == null) return false;
            if (root1.val == root2.val) {
                return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
            }
            return false;
        }
    }
}
