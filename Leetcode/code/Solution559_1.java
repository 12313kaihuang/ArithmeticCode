package Leetcode.code;

import common.Node;

/**
 * 559. N 叉树的最大深度
 * <p>
 * 给定一个 N 叉树，找到其最大深度。
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 * <p>
 * 示例 1：
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：5
 * <p>
 * 提示：
 * 树的深度不会超过1000 。
 * 树的节点数目位于 [0,104] 之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution559_1 {


    public int maxDepth(Node root) {
        if (root == null) return 0;
        int max = 0;
        for (int i = 0; i < root.children.size(); i++) {
            int deep = maxDepth(root.children.get(i));
            max = Math.max(deep, max);
        }
        return max + 1;
    }
}
