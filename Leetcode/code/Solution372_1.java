package Leetcode.code;

/**
 * 372. 超级次方
 * <p>
 * 你的任务是计算ab对1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 * <p>
 * 示例 1：
 * 输入：a = 2, b = [3]
 * 输出：8
 * <p>
 * 示例 2：
 * 输入：a = 2, b = [1,0]
 * 输出：1024
 * <p>
 * 示例 3：
 * 输入：a = 1, b = [4,3,3,8,5,2]
 * 输出：1
 * <p>
 * 示例 4：
 * 输入：a = 2147483647, b = [2,0,0]
 * 输出：1198
 * <p>
 * 提示：
 * 1 <= a <= 2^31 - 1
 * 1 <= b.length <= 2000
 * 0 <= b[i] <= 9
 * b 不含前导 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-pow
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution372_1 {

    /**
     * 前置知识：
     * 在阅读本文前，读者需要掌握快速幂这一算法，具体可以见「50. Pow(x, n) 的官方题解」。
     * 此外，乘法在取模的意义下满足分配律，即
     * (a · b) mod m = [(a mod m) · (b mod m)] mod m
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/super-pow/solution/chao-ji-ci-fang-by-leetcode-solution-ow8j/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    static final int MOD = 1337;

    //计算式子没看懂 = =  倒序遍历
    public int superPow(int a, int[] b) {
        int ans = 1;
        for (int i = b.length - 1; i >= 0; --i) {
            ans = (int) ((long) ans * pow(a, b[i]) % MOD);
            a = pow(a, 10);
        }
        return ans;
    }

    public int pow(int x, int n) {
        int res = 1;
        while (n != 0) {
            if (n % 2 != 0) {
                res = (int) ((long) res * x % MOD);
            }
            x = (int) ((long) x * x % MOD);
            n /= 2;
        }
        return res;
    }

    /**
     * 秦九韶算法 （正序遍历）
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/super-pow/solution/chao-ji-ci-fang-by-leetcode-solution-ow8j/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int superPow2(int a, int[] b) {
        int ans = 1;
        for (int e : b) {
            ans = (int) ((long) pow2(ans, 10) * pow2(a, e) % MOD);
        }
        return ans;
    }

    public int pow2(int x, int n) {
        int res = 1;
        while (n != 0) {
            if (n % 2 != 0) {
                res = (int) ((long) res * x % MOD);
            }
            x = (int) ((long) x * x % MOD);
            n /= 2;
        }
        return res;
    }

}
