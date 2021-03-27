package Leetcode.code;

/**
 * 61. 旋转链表
 * <p>
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 * 示例1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * <p>
 * 示例2：
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 */
public class Solution61_1 {

    /**
     * 向右移动k位，即将head向右移动size - (k % size)位
     * <p>
     * 执行用时： 0 ms , 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗： 37.6 MB, 在所有 Java 提交中击败了91.27%的用户
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ListNode node = head;
        int size = 1;
        while (node.next != null) {
            node = node.next;
            size++;
        }
        node.next = head;
        k = size - (k % size);
        System.out.println("size =" + size + ", k=" + k);
        for (int i = 1; i < k; i++) {
            head = head.next;
        }
        node = head;
        head = head.next;
        node.next = null;
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
