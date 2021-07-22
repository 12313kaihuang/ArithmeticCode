package Leetcode.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表
 * <p>
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * 构造这个链表的深拷贝。深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，
 * 并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 * <p>
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，
 * 同样有 x.random --> y 。返回复制链表的头节点。
 * <p>
 * 用一个由n个节点组成的链表来表示输入/输出中的链表。每个节点用一个[val, random_index]表示：
 * val：一个表示Node.val的整数。
 * random_index：随机指针指向的节点索引（范围从0到n-1）；如果不指向任何节点，则为null。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 * <p>
 * 提示：
 * 0 <= n <= 1000
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
class Solution138_1 {
    public Node copyRandomList(Node head) {
        int count = 0;
        Node[] nodes = new Node[1001];
        Map<Node, Integer> randomIndexMap = new HashMap<>();  //用于存储原链表node的下标

        //先深拷贝值
        Node temp = head;
        while (temp != null) {
            Node newNode = new Node(temp.val);
            nodes[count] = newNode;
            randomIndexMap.put(temp, count++);
            temp = temp.next;
        }

        //赋值next 和 random
        temp = head;
        for (int i = 0; temp != null; temp = temp.next, i++) {
            if (temp.random != null) {
                nodes[i].random = nodes[randomIndexMap.getOrDefault(temp.random, count)];
            }
            nodes[i].next = nodes[i + 1];
        }
        return nodes[0];
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
