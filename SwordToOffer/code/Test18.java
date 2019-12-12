package ArithmeticCode.SwordToOffer.code;

import ArithmeticCode.common.TreeNode;

import java.util.Stack;

/**
 * Created by Hy on 2019/12/11 15:19
 * <p>
 * 二叉树的镜像
 */
public class Test18 {


    public class Solution {
        public void Mirror(TreeNode root) {
            revert(root);
        }

        public void revert(TreeNode treeNode) {
            if (treeNode == null) {
                return;
            }

            TreeNode node = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = node;

            revert(treeNode.left);
            revert(treeNode.right);
        }

        public void Mirror2(TreeNode root) {
            TreeNode node, temp;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                node = stack.pop();
                if (node != null) {
                    temp = node.left;
                    node.left = node.right;
                    node.right = temp;

                    stack.push(node.right);
                    stack.push(node.left);
                }
            }
        }
    }
}
