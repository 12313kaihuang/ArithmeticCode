package common;

/**
 * Created by Hy on 2019/11/12 9:21
 * 链表
 */
public class ListNode {

    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
