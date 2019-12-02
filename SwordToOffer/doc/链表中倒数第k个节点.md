# 链表中倒数第k个节点
链表
## 题目描述
输入一个链表，输出该链表中倒数第k个结点。
## 解题思路
**增加一个`kNode`** 并先指向`head`，然后 **`head`往后移动`k`个节点**，此时，`kNode`与`head`之间刚好差`k`个节点，然后 **`kNode`与`head`同时向后移动**，**当`head`为`null`时，`kNode`即为所求节点**。
### 思路一：
```java
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
}
```

### 思路二：
思路一的简化版。
```java
public class Solution {

    public ListNode FindKthToTail(ListNode head, int k) {
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
```

## Code
[code](../code/Test14.java)<br/>
[kotlin Code](../../kotlin/Test14.kt)

## 相关扩展
* []()
