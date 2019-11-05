package ArithmeticCode.Others.code;

import java.util.Stack;

/**
 * @Author： Hy
 * @Description： 实现一个栈，可获取栈内最大值
 */
public class Test1 {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        System.out.println(stack.getMax());  //1
        stack.push(3);
        stack.push(2);
        System.out.println(stack.getMax());   //3
        stack.push(8);
        System.out.println(stack.getMax());   //8
        stack.pop();
        System.out.println(stack.getMax());   //3
        stack.pop();
        stack.pop();
        System.out.println(stack.getMax());   //1
    }

    /**
     * 使用两个栈来实现，mValueStack用于存储值，mMaxStack的栈顶元素始终为当前栈内最大值。
     * 入栈：mValueStack入栈。将mMaxStack栈顶元素与要入栈的元素相比较，较大值入栈mMaxStack。
     * 出栈：两个栈同时出栈。
     * 这样mMaxStack的栈顶元素始终为当前栈内最大值。
     */
    public static class MyStack {

        /**
         * 用于存储值
         */
        private Stack<Integer> mValueStack = new Stack<>();

        /**
         * 用于存储当前最大值
         */
        private Stack<Integer> mMaxStack = new Stack<>();

        public void push(int val) {
            mValueStack.push(val);

            if (mMaxStack.isEmpty()) {
                //如果当前栈内空 则该值为当前栈内最大值
                mMaxStack.push(val);
            } else {
                //栈顶元素
                Integer topVal = mMaxStack.peek();
                //放入较大值
                mMaxStack.push(topVal > val ? topVal : val);
            }
        }

        public int pop() {
            mMaxStack.pop();
            return mValueStack.pop();
        }

        /**
         * @return 当前栈内最大元素值
         */
        public int getMax() {
            return mMaxStack.peek();
        }
    }

}
