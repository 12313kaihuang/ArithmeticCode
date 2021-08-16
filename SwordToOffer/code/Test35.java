package SwordToOffer.code;

import Others.code.Test4;
import common.ListNode;

/**
 * Created by Hy on 2020/01/10 9:56
 * <p>
 * 两个链表的第一个公共节点
 */
public class Test35 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);

        ListNode list2 = new ListNode(4);
        list2.next = new ListNode(5);

        ListNode commonNode = new ListNode(6);
        commonNode.next = new ListNode(7);

        list1.next.next = commonNode;  //1 2 3 6 7
        list2.next = commonNode;  //4 5 6 7

        System.out.println(new Test4().findFirstCommonNode(list2, list2).val);
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        //用于统计 pHead1.size - pHead2.size
        int diff = 0;
        ListNode temp = pHead1;
        while (temp != null) {
            diff++;
            temp = temp.next;
        }

        temp = pHead2;
        while (temp != null) {
            diff--;
            temp = temp.next;
        }

        //对齐操作
        if (diff >= 0) {
            while (diff-- > 0) pHead1 = pHead1.next;
        } else {
            while (diff++ < 0) pHead2 = pHead2.next;
        }

        //同步后移寻找公共节点
        while (pHead1 != null && pHead2 != null) {
            if (pHead1 == pHead2) {
                return pHead1;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }
}
