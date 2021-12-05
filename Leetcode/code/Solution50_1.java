package Leetcode.code;

/**
 * 50. Pow(x, n)
 * <p>
 * 实现pow(x, n)，即计算 x 的 n 次幂函数（即，xn）。
 * <p>
 * <p>
 * 示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * <p>
 * 示例 2：
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * <p>
 * 示例 3：
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2^-2 = (1/2)^2 = 1/4 = 0.25
 * <p>
 * 提示：
 * -100.0 <x< 100.0
 * -231<= n <=2^31-1
 * -104 <= xn <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution50_1 {

    //朴素解法会超时
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        x = n > 0 ? x : 1 / x;
        double res = 1;
        n = Math.abs(n);
        for (int i = 0; i < n; i++) {
            res *= x;
        }
        return res;
    }


    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public double myPow2(double x, int n) {
        long N = n;
        return N >= 0 ? quickMull(x, N) : 1 / quickMull(x, -N);
    }

    //快速幂 递归版本
    private double quickMull(double x, long n) {
        if (n == 0) return 1.0;
        double y = quickMull(x, n / 2);
        //eg: x ^ 12 = (x^6)^2, x^13 = (x^6)^2 * x
        return n % 2 == 0 ? y * y : y * y * x;
    }

    public double myPow3(double x, int n) {
        long N = n;
        return N >= 0 ? quickMull2(x, N) : 1 / quickMull2(x, -N);
    }

    /**
     * 快速幂 迭代版本
     * <p>
     * 发现规律，详见官方题解
     * <p>
     * 以x^77为例，77转化为2进制为1001101,即
     * 77 = 2^0 + 2^2 + 2^3 + 2^6,则
     * x^77 = x^(2^0) * x^(2^2) * x^(2^3) * x^(2^6)
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private double quickMull2(double x, long n) {
        double x_contribute = x;
        double ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) ans *= x_contribute;
            x_contribute *= x_contribute; //底数
            n = n >> 1; //n /2
        }
        return ans;
    }
}
