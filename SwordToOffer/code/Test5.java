package ArithmeticCode.SwordToOffer.code;

import java.util.Stack;

/**
 * @Author：
 * @Date：
 * @Description： 用两个栈实现队列
 */
public class Test5 {

    /**
     * 暴力破解
     * stack1 用于存储值
     * stack2 用于翻转stack1并取值
     */
    public static class Solution1 {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            //清空stack2
            stack2.clear();

            //翻转到stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }

            //取值
            int result = stack2.pop();

            //还原
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            return result;
        }
    }

    /**
     * 思路不变，逻辑优化处理
     *入栈操作：扔将元素放入stack1
     * 出栈操作：先判断stack2是否为空，如果不为空则直接去stack2栈顶元素返回；否则将stack1全部元素翻转至stack2
     */
    public static class Solution2 {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if (stack1.isEmpty() && stack2.isEmpty()) {
                throw new RuntimeException("No data in stack!");
            }

            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}
