package ArithmeticCode.SwordToOffer.code;

import ArithmeticCode.common.ListNode;

/**
 * Created by Hy on 2019/12/04 9:57
 * <p>
 * 合并两个排序的链表
 */
@SuppressWarnings("unused")
public class Test16 {

    //依次遍历
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode current = new ListNode(0); //实际上当前节点是没有用的
        ListNode head = current;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                current.next = list2;
                list2 = list2.next;
            } else if (list2 == null) {
                current.next = list1;
                list1 = list1.next;
            } else {
                if (list1.val > list2.val) {
                    current.next = list2;
                    list2 = list2.next;
                } else {
                    current.next = list1;
                    list1 = list1.next;
                }
            }
            current = current.next;
        }
        return head.next;
    }

    public ListNode Merge2(ListNode list1, ListNode list2) {
        ListNode current = new ListNode(0); //实际上当前节点是没有用的
        ListNode head = current;
        while (list1 != null && list2 != null) {

            if (list1.val > list2.val) {
                current.next = list2;
                list2 = list2.next;
            } else {
                current.next = list1;
                list1 = list1.next;
            }
            current = current.next;
        }

        //将未结束的链表加上
        // 此时肯定list1与list2至少有一个为null，
        // 所以当list1不为null时list2肯定为null，所以else if (list2 == null)其实可以换成else
        if (list1 == null) {
            current.next = list2;
        } else if (list2 == null) {
            current.next = list1;
        }
        return head.next;
    }

    //递归版本
    public ListNode Merge3(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val > list2.val) {
            list2.next = Merge3(list1, list2.next);
            return list2;
        } else {
            list1.next = Merge3(list1.next, list2);
            return list1;
        }
    }
}
