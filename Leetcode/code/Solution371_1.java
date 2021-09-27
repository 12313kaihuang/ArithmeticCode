package Leetcode.code;

/**
 * 371. 两整数之和
 * <p>
 * 给你两个整数 a 和 b ，不使用 运算符+ 和-，计算并返回两整数之和。
 * <p>
 * 示例 1：
 * 输入：a = 1, b = 2
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：a = 2, b = 3
 * 输出：5
 * <p>
 * 提示：
 * -1000 <= a, b <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution371_1 {

    /**
     * 官方题解 位运算
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = (a & b) << 1; //进位
            a ^= b; //不考虑进位的和
            b = temp;
        }
        return a;
    }
}
