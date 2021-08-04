package Others.interview;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 * <p>
 * 示例 5：
 * 输入：s = "{[]}"
 * 输出：true
 * <p>
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class ShopeeTest1 {

    public boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (!checkCh(stack, '(')) return false;
                    break;
                case '}':
                    if (!checkCh(stack, '{')) return false;
                    break;
                case ']':
                    if (!checkCh(stack, '[')) return false;
                    break;
            }
        }
        return true;
    }

    private boolean checkCh(Stack<Character> stack, int t) {
        if (stack.isEmpty()) return false;
        int ch = stack.pop();
        return ch == t;
    }

    public static void main(String[] args) {
        ShopeeTest1 s = new ShopeeTest1();
        System.out.println(s.check("()"));
        System.out.println(s.check("()[]{}"));
        System.out.println(s.check("(]"));
        System.out.println(s.check("([)]"));
        System.out.println(s.check("{[]}"));
    }
}
