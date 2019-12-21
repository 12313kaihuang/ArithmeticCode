package ArithmeticCode.SwordToOffer.code;

import ArithmeticCode.common.RandomListNode;

/**
 * Created by Hy on 2019/12/21 10:13
 * <p>
 * 复杂链表的复制.md
 */
public class Test25 {


    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        //复制每一个节点并放在原节点的后面
        //即复制A节点A1，然后A`.next = A,A.next = A`,
        RandomListNode currentNode = pHead;
        while (currentNode != null) {
            //A`
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            //将A`插入到A的后面
            cloneNode.next = currentNode.next;
            currentNode.next = cloneNode;
            currentNode = cloneNode.next;
        }

        //再次遍历将random值赋上，即A`.random = A.random.next
        currentNode = pHead;
        while (currentNode != null) {
            currentNode.next.random = currentNode.random == null ? null : currentNode.random.next;
            //因为第一步已经复制每个节点并插入到其后了，所以这里currentNode.next不可能为空
            currentNode = currentNode.next.next;
        }

        //拆分链表  将原链表与新链表拆分出来。
        currentNode = pHead;
        RandomListNode pCloneHead = currentNode.next;
        while (currentNode != null) {
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            currentNode = cloneNode.next;
            cloneNode.next = currentNode == null ? null : currentNode.next;
        }
        return pCloneHead;
    }


}
