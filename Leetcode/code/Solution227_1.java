package Leetcode.code;

import java.util.Stack;

/**
 * 227. 基本计算器 II
 * <p>
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 整数除法仅保留整数部分。
 * <p>
 * 示例 1：
 * 输入：s = "3+2*2"
 * 输出：7
 * <p>
 * 示例 2：
 * 输入：s = " 3/2 "
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 * <p>
 * 提示：
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution227_1 {

    public int calculate(String s) {
        char[] chars = s.replaceAll(" ","").toCharArray();
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        int index = 0;
        while (index < chars.length) {
            char ch = chars[index++];
            if (isNumber(ch)) {
                int num = ch - '0';
                while (index < chars.length && isNumber(chars[index])) {
                    num = num * 10 + (chars[index++] - '0');
                }
                numStack.push(num);
            } else {
                if (!operatorStack.isEmpty()) {
                    char last = operatorStack.peek();
                    ////两次运算碰到一起了，做优先级高的运算
                    if (checkPriority(last, ch)) {
                        //前面运算符优先级高
                        int n = numStack.pop();
                        numStack.push(doOperate(numStack.pop(), operatorStack.pop(), n));
                        operatorStack.push(ch);
                    } else {
                        //后面运算符优先级高
                        int num = chars[index++] - '0';
                        while (index < chars.length && isNumber(chars[index])) {
                            num = num * 10 + (chars[index++] - '0');
                        }
                        numStack.push(doOperate(numStack.pop(), ch, num));
                    }
                } else {
                    operatorStack.push(ch);
                }
            }
        }
        //最后应该只剩下一次运算
        while (!operatorStack.isEmpty()) {
            int n = numStack.pop();
            numStack.push(doOperate(numStack.pop(), operatorStack.pop(), n));
        }
        return numStack.peek();
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    /**
     * @return 如果c1优先级小于c2则返回false，否则返回true
     */
    private boolean checkPriority(char c1, char c2) {
        //return !((c1 == '+' || c1 == '-') && (c2 == '*' || c2 =='/'));
        return (c1 != '+' && c1 != '-') || (c2 != '*' && c2 != '/');
    }

    private int doOperate(int c1, char operator, int c2) {
//        System.out.println(String.format("doOpearte %d %c %d", c1, operator, c2));
        switch (operator) {
            case '+':
                return c1 + c2;
            case '-':
                return c1 - c2;
            case '*':
                return c1 * c2;
            case '/':
                return c1 / c2;
        }
        throw new RuntimeException("unexpected operator:" + operator);
    }

    public static void main(String[] args) {
        System.out.println(new Solution227_1().calculate("3+2*2"));
        System.out.println(new Solution227_1().calculate("42"));
        System.out.println(new Solution227_1().calculate("3/2 "));
        System.out.println(new Solution227_1().calculate(" 3+5 / 2 "));
        System.out.println(new Solution227_1().calculate("2+3-4"));
        System.out.println(new Solution227_1().calculate("1*2-3/4+5*6-7*8+9/10"));
    }
}

