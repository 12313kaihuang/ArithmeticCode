package Leetcode.code;

/**
 * 345. 反转字符串中的元音字母
 * <p>
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
 * <p>
 * 示例 1：
 * 输入：s = "hello"
 * 输出："holle"
 * <p>
 * 示例 2：
 * 输入：s = "leetcode"
 * 输出："leotcede"
 * <p>
 * 提示：
 * 1 <= s.length <= 3 * 10^5
 * s 由 可打印的 ASCII 字符组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution345_1 {


    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length, i = 0, j = chars.length - 1;
        while (i <= j) {
            while (i < len && i <= j && isNotVowels(chars[i])) i++;
            while (j >= 0 && i <= j && isNotVowels(chars[j])) j--;
            if (i < j) {
                System.out.println("swap " + chars[i] + "," + chars[j]);
                chars[i] ^= chars[j];
                chars[j] ^= chars[i];
                chars[i] ^= chars[j];
            }
            i++;
            j--;
        }
        return String.valueOf(chars);
    }

    private boolean isNotVowels(char c) {
        return c != 'a' && c != 'A' && c != 'e' && c != 'E' && c != 'i' && c != 'I'
                && c != 'o' && c != 'O' && c != 'u' && c != 'U';
    }
}
