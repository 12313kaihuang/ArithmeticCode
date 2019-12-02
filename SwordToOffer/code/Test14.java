package ArithmeticCode.SwordToOffer.code;

import ArithmeticCode.common.ListNode;

/**
 * Created by Hy on 2019/12/02 9:43
 * <p>
 * 链表中倒数第k个节点
 */
public class Test14 {

    public class Solution {


        public ListNode FindKthToTail(ListNode head, int k) {
            ListNode kNode = head;

            //head先往后移动k个节点
            for (int i = 0; i < k; i++) {
                if (head == null) {
                    //没有那么多节点
                    return null;
                }
                head = head.next;
            }

            //kNode与head同时往后移  当head为null时 kNode即为倒数第k个节点
            while (head != null) {
                kNode = kNode.next;
                head = head.next;
            }

            return kNode;
        }

        public ListNode FindKthToTail2(ListNode head, int k) {
            ListNode kNode = head;
            int i = 0;
            while (head != null) {
                if (i >= k) {
                    kNode = kNode.next;
                }
                head = head.next;
                i++;
            }
            return i >= k ? kNode : null;
        }
    }
}
