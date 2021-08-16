package Leetcode.swordtooffer;

import common.ListNode;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * <p>
 * 输入两个链表，找出它们的第一个公共节点。
 * <p>
 * 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class OfferSolution52_1 {

    //1.通过栈实现从后向前遍历
    //2.通过set存储一个链表所有节点，然后遍历另一个
    //见https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/solution/gong-shui-san-xie-zhao-liang-tiao-lian-b-ifqw/


    //3.差值法
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        int diff = lenA - lenB;
        //对齐头指针
        if (diff > 0) while (diff-- > 0) headA = headA.next;
        else while (diff++ < 0) headB = headB.next;
        while (headA != null && headB != null) {
            if (headA == headB) break;
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int getLength(ListNode head) {
        ListNode p = head;
        int count = 0;
        while (p != null) {
            p = p.next;
            count++;
        }
        return count;
    }


    /**
     * 等值法
     * <p>
     * 当pa到头后将其指向headB，pb到头后指向headA，
     * 这样也可以达到对齐指针的效果。
     * <p>
     * 证明：
     * 设A链表长度为a，B链表长度为b，公共链表长度为c（0 <= c <= min(a,b)）
     * 当两个链表没有公共节点时：则c=0，循环a+b次后退出
     * 有公共节点时:则循环(a + b - c)次结束
     * <p>
     * 具体可参考官方题解：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/solution/liang-ge-lian-biao-de-di-yi-ge-gong-gong-pzbs/
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }
}
