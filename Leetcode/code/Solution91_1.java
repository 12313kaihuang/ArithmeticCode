package Leetcode.code;

/**
 * 91. 解码方法
 * <p>
 * 一条包含字母A-Z 的消息通过以下映射进行了 编码 ：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。
 * 例如，"11106" 可以映射为：
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * <p>
 * 示例 1：
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * <p>
 * 示例 2：
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * <p>
 * 示例 3：
 * 输入：s = "0"
 * 输出：0
 * 解释：没有字符映射到以 0 开头的数字。
 * 含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
 * 由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
 * <p>
 * 示例 4：
 * 输入：s = "06"
 * 输出：0
 * 解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。
 * <p>
 * 提示：
 * 1 <= s.length <= 100
 * s 只包含数字，并且可能包含前导零。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution91_1 {

    //动态规划
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();  //空间换时间
        int[] f = new int[chars.length + 1];
        f[0] = 1;
        //f[i]代表到第i位可以解码出的组数
        for (int i = 1; i <= chars.length; i++) {
            //看自己能不能组成一个码
            if (chars[i - 1] != '0') {
                f[i] += f[i - 1]; //可以的话那么到第i位的结果就至少跟到第i-1位相同
            }

            //看跟前一位能不能组成一个码
            //这里chars[i - 2] != '0'的判断也很重要
            if (i > 1 && chars[i - 2] != '0' && ((chars[i - 2] - '0') * 10 + chars[i - 1] - '0') <= 26) {
                f[i] += f[i - 2];  //如果可以那么就再加上f[i - 2]  这个+=很灵性
            }
        }
        return f[chars.length];
    }

    //其实交换只涉及到三个数，所以可以省去一个数组
    public int numDecodings2(String s) {
        char[] chars = s.toCharArray();  //空间换时间
        int a = 0, b = 1, c = 0;  //f[i-2] f[i-1] f[i]
        //f[i]代表到第i位可以解码出的组数
        for (int i = 1; i <= chars.length; i++) {
            c = 0;
            //看自己能不能组成一个码
            if (chars[i - 1] != '0') {
                c += b; //可以的话那么到第i位的结果就至少跟到第i-1位相同
            }

            //看跟前一位能不能组成一个码
            //这里chars[i - 2] != '0'的判断也很重要
            if (i > 1 && chars[i - 2] != '0' && ((chars[i - 2] - '0') * 10 + chars[i - 1] - '0') <= 26) {
                c += a;  //如果可以那么就再加上f[i - 2]  这个+=很灵性
            }
            a = b;
            b = c;
        }
        return c;
    }

    /**
     * 不用空间换时间
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/decode-ways/solution/jie-ma-fang-fa-by-leetcode-solution-p8np/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int numDecodings3(String s) {
        int n = s.length();
        // a = f[i-2], b = f[i-1], c=f[i]
        int a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; ++i) {
            c = 0;
            if (s.charAt(i - 1) != '0') {
                c += b;
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                c += a;
            }
            a = b;
            b = c;
        }
        return c;
    }
}
