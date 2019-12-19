package ArithmeticCode.Others.code;

import ArithmeticCode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hy on 2019/12/19 9:35
 * <p>
 * 获取树中节点数最多的层数.md
 */
@SuppressWarnings("unused")
public class Test3 {

    /**
     * 获取树中每一层节点最多的那一层层数
     */
    private int getMaxNumRow(TreeNode root) {
        int maxRow = 1, row = 1, maxNum = 0;
        List<TreeNode> temp = new ArrayList<>();
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        while (treeNodes.size() != 0) {
            temp.clear();
            System.out.println("size = " + treeNodes.size());
            if (treeNodes.size() > maxNum) {
                maxNum = treeNodes.size();
                maxRow = row;
            }
            for (TreeNode treeNode : treeNodes) {
                if (treeNode.left != null) {
                    temp.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    temp.add(treeNode.right);
                }
            }
            row++;
            treeNodes.clear();
            treeNodes.addAll(temp);
        }
        return maxRow;
    }
}
