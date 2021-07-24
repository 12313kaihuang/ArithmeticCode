package Others.interview;

/**
 * 合并两个有序链表
 */
public class BaiduTest1 {

    static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        else if (head2 == null) return head1;
        ListNode head;
        if (head1.value <= head2.value) {
            head = head1;
            head1 = head1.next;
        } else {
            head = head2;
            head2 = head2.next;
        }

        ListNode p = head;
        while (head1 != null && head2 != null) {
            if (head1.value <= head2.value) {
                p.next = head1;
                head1 = head1.next;
            } else {
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        if (head1 != null) p.next = head1;
        else if (head2 != null) p.next = head2;

        return head;
    }

    public ListNode merge2(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        else if (head2 == null) return head1;
        ListNode head = new ListNode(-1), p = head;
        while (head1 != null && head2 != null) {
            if (head1.value <= head2.value) {
                p.next = head1;
                head1 = head1.next;
            } else {
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        if (head1 != null) p.next = head1;
        if (head2 != null) p.next = head2;

        return head.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(5);
        node1.next.next.next = new ListNode(6);

        ListNode node2 = new ListNode(2);
        node2.next = new ListNode(4);
        node2.next.next = new ListNode(7);

        ListNode node = new BaiduTest1().merge(node1, node2);
        while (node != null) {
            System.out.printf("%d ->", node.value);
            node = node.next;
        }
    }
}
