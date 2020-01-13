package ArithmeticCode.SwordToOffer.code;

import ArithmeticCode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Hy on 2020/01/13 10:02
 * <p>
 * 二叉树的深度
 */
public class Test37 {
    /*
     public class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;

     }

     }
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(new Test37().TreeDepth(root));
        System.out.println(new Test37().TreeDepth2(root));
    }

    /**
     * 递归版本
     */
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }

    /**
     * 非递归
     * 虽说有两层循环，但实际复杂度应为O(n)
     */
    public int TreeDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        List<TreeNode> queen = new LinkedList<>();
        queen.add(root);
        while (queen.size() != 0) {
            count++;
            //记录当前层节点个数
            int size = queen.size();
            //依次遍历并同步添加非空子节点
            for (int i = 0; i < size; i++) {
                TreeNode node = queen.remove(0);
                if (node.left != null) queen.add(node.left);
                if (node.right != null) queen.add(node.right);
            }
        }
        return count;
    }
}
