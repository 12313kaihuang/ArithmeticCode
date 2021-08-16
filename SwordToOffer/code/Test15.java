package SwordToOffer.code;

import common.ListNode;

/**
 * Created by Hy on 2019/12/02 21:02
 */
public class Test15 {

    public class Solution {

        public ListNode ReverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode p = head, q = head.next, r;
            p.next = null;
            r = q.next;
            q.next = p;
            while (r != null) {
                p = q;
                q = r;
                r = r.next;
                q.next = p;
            }
            return q;
        }

        //next = head.next; 这一句的顺序也很巧妙
        public ListNode ReverseList2(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode pre = null, next;
            while (head != null) {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }

    }
}
