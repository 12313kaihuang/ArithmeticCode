package ArithmeticCode.SwordToOffer.code;

import java.util.Stack;

/**
 * Created by Hy on 2019/12/13 11:59
 * 栈的压入、弹出序列.md
 */
public class Test21 {

    public static void main(String[] args) {
        int[] pushA = new int[]{1, 2, 3, 4, 5};
        int[] popA = new int[]{4, 5, 3, 2, 1};
        int[] popA2 = new int[]{4, 3, 5, 1, 2};

        System.out.println(new Solution().IsPopOrder(pushA, popA));
        System.out.println(new Solution().IsPopOrder(pushA, popA2));
    }

    public static class Solution {
        public boolean IsPopOrder(int[] pushA, int[] popA) {
            int pushIndex = 0;
            Stack<Integer> stack = new Stack<>();
            for (int value : popA) {

                //保证栈中是有元素的
                if (stack.isEmpty()) {
                    stack.push(pushA[pushIndex++]);
                }

                //若栈顶元素不等于要出栈的元素，则从pushA中依次将元素压栈
                while (stack.peek() != value) {
                    if (pushIndex >= popA.length) {
                        System.out.printf("%s 无法出去\n", value);
                        return false;
                    }
                    stack.push(pushA[pushIndex++]);
                }
                //走到这里说明栈顶元素 = popA[i]
                stack.pop();
            }
            return true;
        }
    }
}
