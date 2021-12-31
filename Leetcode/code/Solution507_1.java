package Leetcode.code;

/**
 * 507. 完美数
 * <p>
 * 对于一个正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 * 给定一个整数n，如果是完美数，返回 true，否则返回 false
 * <p>
 * 示例 1：
 * 输入：num = 28
 * 输出：true
 * 解释：28 = 1 + 2 + 4 + 7 + 14
 * 1, 2, 4, 7, 和 14 是 28 的所有正因子。
 * <p>
 * 示例 2：
 * 输入：num = 6
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：num = 496
 * 输出：true
 * <p>
 * 示例 4：
 * 输入：num = 8128
 * 输出：true
 * <p>
 * 示例 5：
 * 输入：num = 2
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * 1 <= num <= 108
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution507_1 {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int sum = 1, sqrt = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                sum += i;
                sum += (num / i);
            }
        }
        return sum == num;
    }

    /**
     * 根据欧几里得-欧拉定理，每个偶完全数都可以写成
     * 2^{p-1}(2^p-1)的形式，其中 p 为素数且 2^p-1为素数。
     * 由于目前奇完全数还未被发现，因此题目范围 [1,10^8]内的完全数都可以写成上述形式。
     * <p>
     * 这一共有如下 5 个：
     * 6, 28, 496, 8128, 33550336
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/perfect-number/solution/wan-mei-shu-by-leetcode-solution-d5pw/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean checkPerfectNumber2(int num) {
        return num == 6 || num == 28 || num == 496 || num == 8128 || num == 33550336;
    }
}
