package Leetcode.code;

/**
 * 557. 反转字符串中的单词 III
 * <p>
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例：
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * <p>
 * 提示：
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution557_1 {

    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String sp : split) {
            builder.append(" ");
            for (int i = sp.length() - 1; i >= 0; i--) {
                builder.append(sp.charAt(i));
            }
        }
        return builder.substring(1, builder.length());
    }

    public String reverseWords2(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length, l = 0, r = 0;
        do {
            while (r < n && chars[r] != ' ') ++r;
            for (int st = l, en = r - 1; st < en; st++, en--) {
                chars[st] ^= chars[en];
                chars[en] ^= chars[st];
                chars[st] ^= chars[en];
            }
            l = r + 1;
            r++;
        } while (l < n);
        return String.valueOf(chars);
    }
}
