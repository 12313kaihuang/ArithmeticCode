package Leetcode.code;

/**
 * 541. 反转字符串 II
 * <p>
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * 示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * <p>
 * 示例 2：
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 * <p>
 * 提示：
 * 1 <= s.length <= 10^4
 * s 仅由小写英文组成
 * 1 <= k <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution541_1 {

    //s = "abcdefg", k = 2
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int len = chars.length, start = 0;
        while (start < len) {
            revert(chars, start, Math.min(len - 1, start + k - 1));
            start += (k << 1);
        }
        return String.valueOf(chars);
    }

    private void revert(char[] chars, int start, int end) {
        System.out.println("revert " + start + "," + end);
        while (start < end) {
            chars[start] ^= chars[end];
            chars[end] ^= chars[start];
            chars[start] ^= chars[end];
            start++;
            end--;
        }
    }

    public String reverseStr2(String s, int k) {
        char[] chars = s.toCharArray();
        int len = chars.length, curStart = 0;
        while (curStart < len) {
            int start = curStart, end = Math.min(len - 1, curStart + k - 1);
            while (start < end) {
                chars[start] ^= chars[end];
                chars[end] ^= chars[start];
                chars[start] ^= chars[end];
                start++;
                end--;
            }
            curStart += (k << 1);
        }
        return String.valueOf(chars);
    }

    //提成for循环，少了一个全局变量
    public String reverseStr3(String s, int k) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int cur = 0; cur < len; cur += (k << 1)) {
            int start = cur, end = Math.min(len, cur + k) - 1;
            while (start < end) {
                chars[start] ^= chars[end];
                chars[end] ^= chars[start];
                chars[start] ^= chars[end];
                start++;
                end--;
            }
        }
        return String.valueOf(chars);
    }
}
