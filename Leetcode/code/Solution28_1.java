package Leetcode.code;

/**
 * 28. 实现 strStr()
 * <p>
 * 实现strStr()函数。
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置
 * （下标从 0 开始）。如果不存在，则返回 -1 。
 * <p>
 * 说明：
 * 当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当needle是空字符串时我们应当返回 0 。这与 C 语言的strstr()以及 Java 的indexOf()定义相符。
 * <p>
 * 示例 1：
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * <p>
 * 示例 3：
 * 输入：haystack = "", needle = ""
 * 输出：0
 * <p>
 * 提示：
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack 和 needle 仅由小写英文字符组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution28_1 {

    //超出时间限制
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (needle.length() > haystack.length()) return -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 1;
                for (; i + j < haystack.length() && j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                }
                if (j == needle.length()) return i;
            }
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (needle.length() > haystack.length()) return -1;
        char[] chars = haystack.toCharArray();
        char[] target = needle.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == target[0]) {
                int j = 1;
                for (; i + j < chars.length && j < target.length; j++) {
                    if (chars[i + j] != target[j]) {
                        break;
                    }
                }
                if (j == target.length) return i;
            }
        }
        return -1;
    }

    public int strStr3(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
