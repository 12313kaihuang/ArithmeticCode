package Leetcode.code;

/**
 * 342. 4的幂
 * <p>
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 * <p>
 * 示例 1：
 * 输入：n = 16
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：n = 5
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：n = 1
 * 输出：true
 * <p>
 * 提示：
 * -231 <= n <= 231 - 1
 * <p>
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-four
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution342_1 {

    /**
     * 先用循环做
     */
    public boolean isPowerOfFour(int n) {
        if (n == 0) return false;
        while (n % 4 == 0) {
            n = n / 4;
        }
        return n == 1;
    }

    /**
     * 官方题解
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/power-of-four/solution/4de-mi-by-leetcode-solution-b3ya/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean isPowerOfFour2(int n) {
//        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0; //思路1
        return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1; //思路2
    }

}
