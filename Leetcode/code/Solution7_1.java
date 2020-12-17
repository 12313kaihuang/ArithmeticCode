package Leetcode.code;

/**
 * 7. 整数反转
 * <p>
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例1:
 * 输入: 123
 * 输出: 321
 * <p>
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * <p>
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为[−231, 231− 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution7_1 {

    /**
     * 难点在于反转后整数可能会溢出，如何去判断
     * <p>
     */
    public int reverse(int x) {
        if (x == 0) return x;
        int result = 0;
        while (x != 0) {
            int num = x % 10;
            x /= 10;
            //MAX_VALUE = 2147483647 累加之后的值不能大于它
            if ((result > Integer.MAX_VALUE / 10) || (result == Integer.MAX_VALUE / 10 && num > 7)) return 0;
            //MIN_VALUE = -2147483648
            if ((result < Integer.MIN_VALUE / 10) || (result == Integer.MIN_VALUE / 10 && num < -8)) return 0;
            result = result * 10 + num;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE); //2147483647
        System.out.println(Integer.MAX_VALUE / 10);
        System.out.println(Integer.MIN_VALUE); //-2147483648
        System.out.println(Integer.MIN_VALUE % 10);
        System.out.println(Integer.MIN_VALUE / 10);
        System.out.println(new Solution7_1().reverse(123));
        System.out.println(new Solution7_1().reverse(-123));
        System.out.println(new Solution7_1().reverse(120));
        System.out.println(new Solution7_1().reverse(1534236469));
    }
}
