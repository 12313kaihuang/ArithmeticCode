package Leetcode.code;

import common.ListNode;

/**
 * 876. 链表的中间结点
 * <p>
 * 给定一个头结点为 head的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p>
 * 示例 1：
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * <p>
 * 示例2：
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 * <p>
 * 提示：
 * 给定链表的结点数介于1和100之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/middle-of-the-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution876_1 {

    //快慢指针 不需要count
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        while (head != null && head.next != null) {
            slow = slow.next;
            head = head.next.next;
        }
        return slow;
    }

    //self
    public ListNode middleNode2(ListNode head) {
        int count = 0;
        ListNode mid = head;
        while (head != null) {
            head = head.next;
            ++count;
            if ((count & 1) == 0) mid = mid.next;
        }
        return mid;
    }
}
