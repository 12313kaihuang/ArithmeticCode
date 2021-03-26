package Leetcode.code;

/**
 * 83. 删除排序链表中的重复元素
 * <p>
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * 返回同样按升序排列的结果链表。
 * <p>
 * 示例1：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * <p>
 * 示例2：
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 */
public class Solution83_1 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.val == node.next.val) node.next = node.next.next;
            else node = node.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        ListNode node = new Solution83_1().deleteDuplicates(head);
        StringBuilder builder = new StringBuilder();
        while (node != null) {
            builder.append(node.val).append(",");
            node = node.next;
        }
        System.out.println(builder.toString());
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
