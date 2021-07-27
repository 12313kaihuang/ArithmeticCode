package SwordToOffer.code;

import common.TreeNode;

import java.util.*;

/**
 * Created by Hy on 2019/12/14 10:05
 * 从上往下打印二叉树
 */
public class Test22 {

    public static void main(String[] args) {

    }

    public static class Solution {
        public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
            ArrayList<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            List<TreeNode> queen = new LinkedList<>();
            queen.add(root);
            while (queen.size() != 0) {
                TreeNode node = queen.remove(0);
                result.add(node.val);
                if (node.left != null) {
                    queen.add(node.left);
                }
                if (node.right != null) {
                    queen.add(node.right);
                }
            }

            return result;
        }

//        private void getValue(TreeNode treeNode,ArrayList<Integer> list) {
//            if (treeNode == null) {
//                return;
//            }
//            list.add(treeNode.val);
//            getValue(treeNode.left);
//            getValue(treeNode.right);
//        }
    }
}
