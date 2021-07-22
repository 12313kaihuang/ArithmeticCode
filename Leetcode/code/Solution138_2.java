package Leetcode.code;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class Solution138_2 {

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    Map<Node, Node> cachedNode = new HashMap<>();

    /**
     * 官方题解  回溯+哈希
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer/solution/fu-zhi-dai-sui-ji-zhi-zhen-de-lian-biao-rblsf/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }

    /**
     * 算是上述解法的非递归版本
     * <p>
     * 见官方题解下评论
     */
    public Node copyRandomList2(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }

    /**
     * 迭代+节点拆分
     * <p>
     * 我们首先将该链表中每一个节点拆分为两个相连的节点，
     * 例如对于链表A→B→C，我们可以将其拆分为A→A′→B→B′→C→C′。
     * 对于任意一个原节点 SS，其拷贝节点 S'即为其后继节点。
     * <p>
     * 这样，我们可以直接找到每一个拷贝节点 S'的随机指针应当指向的节点，
     * 即为其原节点 S 的随机指针指向的节点 T 的后继节点 T'。
     * 需要注意原节点的随机指针可能为空，我们需要特别判断这种情况。
     * 当我们完成了拷贝节点的随机指针的赋值，我们只需要将这个链表按照原节点与拷贝节点的种类进行拆分即可，
     * 只需要遍历一次。同样需要注意最后一个拷贝节点的后继节点为空，我们需要特别判断这种情况。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer/solution/fu-zhi-dai-sui-ji-zhi-zhen-de-lian-biao-rblsf/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public Node copyRandomList3(Node head) {
        if (head == null) return null;
        Node temp = head;
        //拷贝字节点
        while (temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = newNode.next;
        }

        for (temp = head; temp != null; temp = temp.next.next) {
            if (temp.random != null) temp.next.random = temp.random.next;
        }

        Node newHead = head.next;
        for (temp = head; temp != null; temp = temp.next) {
            Node nodeNew = temp.next;
            temp.next = temp.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return newHead;
    }

    //减少一次遍历
    public Node copyRandomList4Error(Node head) {
        if (head == null) return null;
        Node temp = head;
        //拷贝字节点
        while (temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = newNode.next;
        }

        //不能在设置next的时候赋值random，因为若是后面的random指向前面，
        //temp.random.next并不是预期的Node节点
        //所以需要想办法在拷贝的时候给random赋值
        Node newHead = head.next;
        for (temp = head; temp != null; temp = temp.next) {
            Node tempNext = temp.next;
            if (temp.random != null) tempNext.random = temp.random.next;
            if (tempNext.next == null) break;
            temp.next = tempNext.next;
            tempNext.next = temp.next;
        }
        return newHead;
    }

    //todo 有思路但是没时间做了
    public Node copyRandomList4TODO(Node head) {
        if (head == null) return null;
        Node temp = head;
        //拷贝字节点
        while (temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            //此时temp.random对应的newNode可能还没创建，
            //获取可以通过set来辅助
            temp = newNode.next;
        }

        Node newHead = head.next;
        for (temp = head; temp != null; temp = temp.next) {
            Node nodeNew = temp.next;
            temp.next = temp.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return newHead;
    }
}
