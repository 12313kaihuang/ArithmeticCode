package Leetcode.code;


/**
 * 443. 压缩字符串
 * <p>
 * 给你一个字符数组 chars ，请使用下述算法压缩：
 * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
 * 如果这一组长度为 1 ，则将字符追加到 s 中。
 * 否则，需要向 s 追加字符，后跟这一组的长度。
 * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
 * <p>
 * 请在 修改完输入数组后 ，返回该数组的新长度。
 * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
 * <p>
 * 示例 1：
 * 输入：chars = ["a","a","b","b","c","c","c"]
 * 输出：返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
 * 解释：
 * "aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
 * <p>
 * 示例 2：
 * 输入：chars = ["a"]
 * 输出：返回 1 ，输入数组的前 1 个字符应该是：["a"]
 * 解释：
 * 没有任何字符串被替代。
 * <p>
 * 示例 3：
 * 输入：chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * 输出：返回 4 ，输入数组的前 4 个字符应该是：["a","b","1","2"]。
 * 解释：
 * 由于字符 "a" 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 “b12” 替代。
 * 注意每个数字在数组中都有它自己的位置。
 * <p>
 * 提示：
 * 1 <= chars.length <= 2000
 * chars[i] 可以是小写英文字母、大写英文字母、数字或符号
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-compression
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution443_1 {

    public int compress(char[] chars) {
        int s = 0, e = 0;
        int cur = 0, len = chars.length;
        while (e < len) {
            while (e < len && chars[s] == chars[e]) e++;
            //记录个数的同时还需要改变原字符数组
            chars[cur++] = chars[s];
            int count = e - s;
            if (count > 1) {
                String s1 = String.valueOf(count);
                for (char c : s1.toCharArray()) chars[cur++] = c;
            }
            System.out.println(String.valueOf(chars).substring(0, cur));
            s = e;
        }
        return cur;
    }

    //改变count转换方式
    public int compress2(char[] chars) {
        int start = 0, end = 0, cur = 0;
        while (end < chars.length) {
            while (end < chars.length && chars[start] == chars[end]) end++;
            //记录个数的同时还需要改变原字符数组
            chars[cur++] = chars[start];
            int count = end - start;
            if (count > 1) {
                //因为length最大2000，count最多也就是千级别的
                for (int mod = 1000; count > 0 && mod > 0; mod /= 10) {
                    int quotient = count / mod;
                    if (quotient > 0 || mod == 1) {
                        chars[cur++] = (char) ('0' + quotient);
                    }
                    count = count % mod;
                }
            }
            System.out.println(String.valueOf(chars).substring(0, cur));
            start = end;
        }
        return cur;
    }
}
