package ArithmeticCode.Others.code;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Hy on 2019/11/06 9:41
 */
public class Test2 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(1);
        solution.push(3);
        solution.push(2);
        System.out.println(solution.pop());  //2
        solution.push(5);
        System.out.println(solution.pop());  //5
        System.out.println(solution.pop());  //3
        System.out.println(solution.pop());  //1
    }

    public static class Solution {
        private Queue<Integer> queue1;
        private Queue<Integer> queue2;

        public Solution() {
            queue1 = new ArrayDeque<>();
            queue2 = new ArrayDeque<>();
        }

        public void push(int val) {
            if (queue2.size() == 0) {
                //当前使用queue1
                queue1.add(val);
            } else {
                queue2.add(val);
            }
        }

        @SuppressWarnings("ConstantConditions")
        public int pop() {
            int result;
            if (queue2.size() == 0) {
                while (queue1.size() > 1) queue2.add(queue1.poll());
                result = queue1.poll();
            } else {
                while (queue2.size() > 1) queue1.add(queue2.poll());
                result = queue2.poll();
            }
            return result;
        }
    }

}
