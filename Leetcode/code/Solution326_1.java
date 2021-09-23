package Leetcode.code;

import java.util.HashSet;
import java.util.Set;

/**
 * 326. 3的幂
 * <p>
 * 给定一个整数，写一个函数来判断它是否是 3的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 * <p>
 * 示例 1：
 * 输入：n = 27
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：n = 0
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：n = 9
 * 输出：true
 * <p>
 * 示例 4：
 * 输入：n = 45
 * 输出：false
 * <p>
 * 提示：
 * -231 <= n <= 231 - 1
 * <p>
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution326_1 {

    //常规解法
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n > 1) {
            if (n % 3 != 0) return false;
            n /= 3;
        }
        return true;
    }

    /**
     * 常规解法2
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/power-of-three/solution/3de-mi-by-leetcode-solution-hnap/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean isPowerOfThree2(int n) {
        while (n != 0 && n % 3 == 0) n /= 3;
        return n == 1;
    }

    /**
     * 3^19 = 1162261467
     * 判断n是否是其的约数
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/power-of-three/solution/3de-mi-by-leetcode-solution-hnap/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean isPowerOfThree3(int n) {
        return n > 0 && 1162261467 % n == 0;
    }


    private static final Set<Integer> nums = new HashSet<>();

    static {
        int n = 1;
        for (int i = 0; i <= 19; i++) {
            nums.add(n);
            n *= 3;
        }
    }

    /**
     * 打表
     */
    public boolean isPowerOfThree4(int n) {
        return nums.contains(n);
    }
}
