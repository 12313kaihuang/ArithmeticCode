package Leetcode.code;

import common.ListNode;

/**
 * 92. 反转链表 II
 * <p>
 * 给你单链表的头节点head 和两个整数left 和 right ，其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * <p>
 * 示例 2：
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * <p>
 * 提示：
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution92_1 {
    //应该可以使用LinkList（双向链表？），但是不知道实际面试官允不允许

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode p = head, q = null, r = p;
        for (int i = 1; i <= right; i++) { //left <= right <= n 可以保证过程中p,q不会为null
            if (i < left) {
                r = p;
                p = p.next;
            } else q = q == null ? p : q.next;
        }
        //System.out.println("p = " + p.val + ", q= " + q.val + ", r= " + r.val);
        if (p != r) r.next = q; //这里是个坑，left=1时，p=r
        r = p.next;
        p.next = q.next;
        q.next = null;
        while (r.next != null) {
            q = r.next;
            r.next = p;
            p = r;
            r = q;
        }
        r.next = p;
        return left == 1 ? r : head; //如果left=1，则p为头结点，翻转后q就是头结点了
    }


    /**
     * [1,2,3] 1 3
     * [1,2,3,4,5] 2 4
     * [1,2,3,4,5] 3 4
     * [3,5] 1 2
     */
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
//        head1.next.next.next = new ListNode(4);
//        head1.next.next.next.next = new ListNode(5);
        ListNode reverseBetween = new Solution92_1().reverseBetween(head1, 1, 3);
        while (reverseBetween != null) {
            System.out.printf("%d,", reverseBetween.val);
            reverseBetween = reverseBetween.next;
        }
        System.out.println();

        ListNode head2 = new ListNode(3);
        head2.next = new ListNode(5);
        ListNode reverseBetween2 = new Solution92_1().reverseBetween(head2, 1, 2);
        while (reverseBetween2 != null) {
            System.out.printf("%d,", reverseBetween2.val);
            reverseBetween2 = reverseBetween2.next;
        }

    }

    /**
     * 头插法  也挺好理解的，甚至比自己的想法貌似都好理解
     *
     * 作者：mu-yi-cheng-zhou-2
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/java-shuang-zhi-zhen-tou-cha-fa-by-mu-yi-cheng-zho/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode g = dummyHead;
        ListNode p = dummyHead.next;

        int step = 0;
        while (step < m - 1) {
            g = g.next;
            p = p.next;
            step++;
        }

        for (int i = 0; i < n - m; i++) {
            ListNode removed = p.next;
            p.next = p.next.next;

            removed.next = g.next;
            g.next = removed;
        }

        return dummyHead.next;
    }

}
