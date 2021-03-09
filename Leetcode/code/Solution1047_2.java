package Leetcode.code;

import java.util.Stack;

public class Solution1047_2 {

    /**
     * 用栈就可以实现！！！！
     */
    public String removeDuplicates(String S) {
        char[] arr = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : arr) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        //这里的转化太费时了
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.remove(0));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution1047_2().removeDuplicates("aabc"));
        System.out.println(new Solution1047_2().removeDuplicates("abbaca"));
        System.out.println(new Solution1047_2().removeDuplicates("acbbcacca"));
        System.out.println(new Solution1047_2().removeDuplicates("ibfjcaffccadidiaidchakchchcahabhibdcejkdkfbaeeaecdjhajbkfebebfea"));
    }
}
