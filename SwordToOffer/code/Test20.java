package ArithmeticCode.SwordToOffer.code;

import java.util.Stack;

/**
 * Created by Hy on 2019/12/12 9:52
 * <p>
 * 包含min函数的栈.md
 */
public class Test20 {

    public class Solution {

        //用于存储数值
        private Stack<Integer> numStack = new Stack<>();
        //用于存储当前最小值
        private Stack<Integer> minStack = new Stack<>();

        public void push(int node) {
            numStack.push(node);

            if (minStack.isEmpty()) {
                minStack.push(node);
            } else {
                int currentMin = minStack.peek();
                minStack.push(Math.min(currentMin, node));
            }
        }

        public void pop() {
            numStack.pop();
            minStack.pop();
        }

        public int top() {
            return numStack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }

}
