package SwordToOffer.code;

import common.TreeNode;

/**
 * Created by Hy on 2019/11/14 9:39
 * <p>
 * 重建二叉树
 */
public class Test4 {

    public static void main(String[] args) {

    }

    public static class Solution {
        /**
         * @param pre 前序遍历结果
         * @param in  中序遍历结果
         */
        public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
            return buildTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        }

        /**
         * @param pre 前序遍历结果
         * @param ps  当前子树所有节点在前序遍历结果中的起始下标
         * @param pe  当前子树所有节点在前序遍历结果中的终止下标
         * @param in  中序遍历结果
         * @param is  当前子树所有节点在中序遍历结果中的起始下标
         * @param ie  当前子树所有节点在中序遍历结果中的终止下标
         */
        private TreeNode buildTree(int[] pre, int ps, int pe, int[] in, int is, int ie) {

            //结束条件
            if (ps > pe || is > ie) {
                return null;
            }

            TreeNode treeNode = new TreeNode(pre[ps]);
            //获取当前子树根节点在中序遍历结果中的下标值
            for (int mrIndex = 0; mrIndex < in.length; mrIndex++) {
                if (in[mrIndex] == pre[ps]) {
                    treeNode.left = buildTree(pre, ps + 1, ps + mrIndex - is, in, is, mrIndex - 1);
                    treeNode.right = buildTree(pre, ps + mrIndex - is + 1, pe, in, mrIndex + 1, ie);
                }
            }
            return treeNode;
        }
    }
}
