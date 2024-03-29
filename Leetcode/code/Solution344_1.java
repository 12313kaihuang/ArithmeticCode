package Leetcode.code;

/**
 * 344. 反转字符串
 * <p>
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * <p>
 * 示例 1：
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * <p>
 * 示例 2：
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution344_1 {

    public void reverseString(char[] chars) {
        for (int s = 0, e = chars.length - 1; s < e; s++, e--) {
            chars[s] += chars[e];
            chars[e] = (char) (chars[s] - chars[e]);
            chars[s] = (char) (chars[s] - chars[e]);
        }
    }

    //异或？
    public void reverseString2(char[] chars) {
        for (int s = 0, e = chars.length - 1; s < e; s++, e--) {
            chars[s] ^= chars[e];
            chars[e] ^= chars[s];
            chars[s] ^= chars[e];
        }
    }
}
