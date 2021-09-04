package Leetcode.swordtooffer;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * <p>
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * F(0) = 0, F(1)= 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：n = 5
 * 输出：5
 * <p>
 * 提示：
 * 0 <= n <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class OfferSolution10_1 {

    static final int MOD = 1_000_000_007;

    /**
     * 动态规划 long还是不够
     * <p>
     * 坑在于n可以达到100，使用这种方法数值位数不够，还是需要通过3个变量来实现
     */
    public int fib(int n) {
        if (n <= 1) return n;
        long a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            a = a + b;
            b = a - b; //如果前面a大于MOD来，取余之后再减就成负数了
            if (i > 50) System.out.println(a);
        }
        return (int) (a % MOD);
    }

    //用三个变量 解决超出上限的问题
    public int fib2(int n) {
        if (n <= 1) return n;
        int a = 0, b = 0, c = 1;
        //循环判断也需要注意
        for (int i = 2; i <= n; i++) {
            a = b;
            b = c;
            c = (a + b) % MOD;
        }
        System.gc();
        return c;
    }


    /**
     * 官方题解 矩阵快速幂
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/solution/fei-bo-na-qi-shu-lie-by-leetcode-solutio-hbss/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int fib3(int n) {
        if (n < 2) {
            return n;
        }
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n - 1);
        return res[0][0];
    }

    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = (int) (((long) a[i][0] * b[0][j] + (long) a[i][1] * b[1][j]) % MOD);
            }
        }
        return c;
    }

}
