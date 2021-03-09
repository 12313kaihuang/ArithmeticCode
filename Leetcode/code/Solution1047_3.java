package Leetcode.code;

public class Solution1047_3 {

    /**
     * 这个太难理解了。。
     */
    public String removeDuplicates(String S) {
        char[] chars = S.toCharArray();
        int top = -1;
        for (char ch : chars) {
            if (top != -1 && chars[top] == ch) top--;
            else chars[++top] = ch;
        }
        return new String(chars, 0, top + 1);
    }
}
