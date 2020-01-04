package ArithmeticCode.Others.code;

import ArithmeticCode.common.ListNode;

/**
 * Created by Hy on 2020/01/04 9:58
 * <p>
 * 找到交叉链表的第一个公共节点
 */
public class Test4 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(2);
        list1.next = new ListNode(5);

        ListNode list2 = new ListNode(7);

        ListNode commonNode = new ListNode(3);
        commonNode.next = new ListNode(4);
        commonNode.next.next = new ListNode(8);  // 3 4 8

        list1.next.next = commonNode;  //2 5 3 4 8
        list2.next = commonNode;  //7 3 4 8

        System.out.println(new Test4().findFirstCommonNode(list2, list2).val);
    }

    public ListNode findFirstCommonNode(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return null;
        }

        //求list1的长度
        //int len1 = 0;
        int diff = 0;
        ListNode temp = list1;
        while (temp != null) {
            diff++;
            temp = temp.next;
        }

        //求list2的长度
        //int len2 = 0;
        temp = list2;
        while (temp != null) {
            //len2++;
            diff--;
            temp = temp.next;
        }

        //对齐操作
        //int diff = len1 - len2;
        if (diff >= 0) {
            //list1较长
            while (diff-- > 0) list1 = list1.next;
        } else {
            while (diff++ < 0) list2 = list2.next;
        }

        //依次向后移动并判断
        while (list1 != null && list2 != null) {
            if (list1 == list2) {
                return list1;
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        return null;
    }
}
