package Leetcode.code;

import java.util.Deque;
import java.util.LinkedList;

public class Solution173_2 {

    static class BSTIterator {

        //不用预先遍历，next的时候实时操作栈，这样就可以做到空间复杂度O(h)
        //可能是数据量小了，实际运行效果不如1？？
        private final Deque<Solution173_1.TreeNode> stack = new LinkedList<>();

        public BSTIterator(Solution173_1.TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        /**
         * 思路参照 https://leetcode-cn.com/problems/binary-search-tree-iterator/solution/fu-xue-ming-zhu-dan-diao-zhan-die-dai-la-dkrm/
         * 比官方题解的思路更好理解
         */
        public int next() {
            Solution173_1.TreeNode node = stack.pop();
            int ret = node.val;
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            return ret;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        Solution173_1.TreeNode node = new Solution173_1.TreeNode(7);
        node.left = new Solution173_1.TreeNode(3);
        node.right = new Solution173_1.TreeNode(15);
        node.right.left = new Solution173_1.TreeNode(9);
        node.right.right = new Solution173_1.TreeNode(20);
        Solution173_2.BSTIterator bstIterator = new Solution173_2.BSTIterator(node);
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
    }
}
