package Leetcode.code;

/**
 * 709. 转换成小写字母
 * <p>
 * 给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。
 * <p>
 * 示例 1：
 * 输入：s = "Hello"
 * 输出："hello"
 * <p>
 * 示例 2：
 * 输入：s = "here"
 * 输出："here"
 * <p>
 * 示例 3：
 * 输入：s = "LOVELY"
 * 输出："lovely"
 * <p>
 * <p>
 * 提示：
 * 1 <= s.length <= 100
 * s 由 ASCII 字符集中的可打印字符组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/to-lower-case
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution709_1 {

    public String toLowerCase(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            //A 65 a 97
            if (c >= 'A' && c <= 'Z') {
                builder.append((char) (c + 32));
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }


    public String toLowerCase2(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                //基于ASCII码只大写字符转小写只需通过或运算即可
                c |= 32;
            }
            builder.append(c);
        }
        return builder.toString();
    }
}
