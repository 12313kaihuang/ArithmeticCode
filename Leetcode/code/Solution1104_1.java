package Leetcode.code;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 1104. 二叉树寻路
 * <p>
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按“之” 字形进行标记。
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 * <p>
 * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，
 * 该路径是由途经的节点标号所组成的。
 * <p>
 * 示例 1：
 * 输入：label = 14
 * 输出：[1,3,4,14]
 * <p>
 * 示例 2：
 * 输入：label = 26
 * 输出：[1,2,6,10,26]
 * <p>
 * 提示：
 * 1 <= label <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution1104_1 {

    /**
     * 树是之字形到，所如果知道节点所在层级和位置，那么是可以计算出节点对应值到
     */
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new LinkedList<>();
        int depth = 1, count = 1;
        for (; label > count; count <<= 1, depth++) {
            label -= count;
        }
        addNode(list, depth, label);
        Collections.reverse(list);
        return list;
    }

    /**
     * @param depth 需要加入到节点层级
     * @param pos   需要加入到节点按所处行的方向的下标（1开始）
     */
    private void addNode(List<Integer> nodes, int depth, int pos) {
        if (depth == 1) {
            nodes.add(1);
            return;
        }
        int count = 1 << (depth - 1); //depth层节点个数
        nodes.add(count + pos - 1); //pos位置对应节点值
//        System.out.println(String.format("addNodes %d %d --> %d", depth, pos, count + pos - 1));
        pos = (count >> 1) - (pos - 1 >> 1); //上一层节点位置，这个值的计算是重点
        addNode(nodes, depth - 1, pos);
    }
}
