package SwordToOffer.code;


import common.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Hy on 2019/11/12 9:24
 * <p>
 * 从尾到头打印链表
 */
public class Test3 {

    //暴力破解  利用栈后进先出特点，先遍历链表并压入栈中，再依次打印出栈元素。
    public class Solution {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            Stack<Integer> stack = new Stack<>();
            //压栈
            while (listNode != null) {
                stack.push(listNode.val);
                listNode = listNode.next;
            }
            ArrayList<Integer> list = new ArrayList<>();
            //出栈并打印
            while (!stack.isEmpty()) {
                list.add(stack.pop());
            }
            return list;
        }
    }

    //使用递归
    public class Solution2 {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ArrayList<Integer> list = new ArrayList<>();
            getList(listNode, list);
            return list;
        }

        //递归，如果node不为空，递归判断next，然后再将本结点val加入list
        private void getList(ListNode listNode, ArrayList<Integer> list) {
            if (listNode != null) {
                getList(listNode.next, list);
                list.add(listNode.val);
            }
        }
    }
}
