package Leetcode.code;

import com.sun.source.tree.IfTree;

import java.sql.SQLOutput;

/**
 * 8. 字符串转换整数 (atoi)
 * <p>
 * 请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * <p>
 * 函数myAtoi(string s) 的算法如下：
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231, 231− 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231− 1 的整数应该被固定为 231− 1 。
 * 返回整数作为最终结果。
 * <p>
 * 注意：
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution8_1 {

    public int myAtoi(String s) {
        int sign = 0;  //1+ 2-
        long res = 0;
        char[] chars = s.strip().toCharArray();
//        System.out.println(chars);
        for (Character c : chars) {
            if (Character.isDigit(c)) {
                if (sign != 2) sign = 1; //匹配到数字了，若此时没有检测到符号则说明是正数
                res = res * 10 + c - '0';
            } else {
                if ('+' == c) {
                    if (sign == 0) sign = 1;
                    else break;
                } else if ('-' == c) {
                    if (sign == 0) sign = 2;
                    else break;
                } else break;
            }
//            System.out.println(sign + "," +Integer.MAX_VALUE +  "," + res);
            if (sign != 2 && res > Integer.MAX_VALUE){
                res = Integer.MAX_VALUE;
                break;
            } else if (sign == 2 && -res < Integer.MIN_VALUE) {
                res = Integer.MIN_VALUE;
                break;
            }
        }
        return (int) (sign == 2 ? -res : res);
    }

    public static void main(String[] args) {
//        System.out.println(new Solution8_1().myAtoi("45"));
//        System.out.println(new Solution8_1().myAtoi("-42"));
//        System.out.println(new Solution8_1().myAtoi("4193 with words"));
//        System.out.println(new Solution8_1().myAtoi("words and 987"));
//        System.out.println(new Solution8_1().myAtoi("-91283472332"));
//        System.out.println(new Solution8_1().myAtoi("   +0 123")); //预期结果0
        System.out.println(new Solution8_1().myAtoi("9223372036854775808"));
        System.out.println(new Solution8_1().myAtoi("-9223372036854775808"));
    }
}
