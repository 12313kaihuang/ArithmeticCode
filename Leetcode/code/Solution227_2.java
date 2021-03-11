package Leetcode.code;

import java.util.Deque;
import java.util.LinkedList;

public class Solution227_2 {

    /**
     * 遍历字符串 ss，并用变量preSign 记录每个数字之前的运算符，对于第一个数字，
     * 其之前的运算符视为加号。每次遍历到数字末尾时，根据preSign
     * 来决定计算方式：
     * <p>
     * 加号：将数字压入栈；
     * 减号：将数字的相反数压入栈；
     * 乘除号：计算数字与栈顶元素，并将栈顶元素替换为计算结果。
     * <p>
     * 简单来说就是将乘除法和减法都转成加法存入栈中，最后统一执行加法。
     */
    public int calculate(String s) {
        //Deque 双端队列
        Deque<Integer> stack = new LinkedList<>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
