package Leetcode.code;

import java.util.Stack;

/**
 * 20. 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * <p>
 * 示例2：
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * 示例3：
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * 示例4：
 * 输入：s = "([)]"
 * 输出：false
 * <p>
 * 示例5：
 * 输入：s = "{[]}"
 * 输出：true
 * <p>
 * 提示：
 * 1 <= s.length <= 10^4
 * s 仅由括号 '()[]{}' 组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution20_1 {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : chars) {
            switch (ch) {
                case '(', '[', '{' -> stack.push(ch);
                default -> {
                    if (stack.isEmpty()) return false;
                    if (!check(stack.pop(), ch)) return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        int length = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(', '[', '{' -> stack.push(ch);
                default -> {
                    if (stack.isEmpty()) return false;
                    if (!check(stack.pop(), ch)) return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean check(Character pop, char ch) {
        if (ch == ')') return pop == '(';
        if (ch == ']') return pop == '[';
        if (ch == '}') return pop == '{';
        return false;
    }
}
