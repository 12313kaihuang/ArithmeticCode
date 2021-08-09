package Leetcode.code;

import java.util.Arrays;

/**
 * 313. 超级丑数
 * <p>
 * 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
 * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
 * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
 * <p>
 * 示例 1：
 * 输入：n = 12, primes = [2,7,13,19]
 * 输出：32
 * 解释：给定长度为 4 的质数数组 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 * <p>
 * 示例 2：
 * 输入：n = 1, primes = [2,3,5]
 * 输出：1
 * 解释：1 不含质因数，因此它的所有质因数都在质数数组 primes = [2,3,5] 中。
 * <p>
 * 提示：
 * 1 <= n <= 10^6
 * 1 <= primes.length <= 100
 * 2 <= primes[i] <= 1000
 * 题目数据 保证 primes[i] 是一个质数
 * primes 中的所有值都 互不相同 ，且按 递增顺序 排列
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-ugly-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution313_1 {

    /**
     * 其实和264. 丑数 II思路是一样的
     * <p>
     * 可以采用动态规划(多指针)
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n <= 1) return n;
        int[] uglyNumbers = new int[n + 1];
        Arrays.fill(uglyNumbers, Integer.MAX_VALUE);
        uglyNumbers[1] = 1;

        int[] indexs = new int[primes.length];  //indexs[i]的值表示primes[i]对应的下标位置
        int[] sums = new int[primes.length];    //sum[i]为primes[i] * uglyNumbers[indexs[i]]
        Arrays.fill(indexs, 1);

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < primes.length; j++) {
                sums[j] = primes[j] * uglyNumbers[indexs[j]];
                uglyNumbers[i] = Math.min(uglyNumbers[i], sums[j]);
            }
            for (int j = 0; j < primes.length; j++) {
                if (uglyNumbers[i] == sums[j]) indexs[j]++;
            }
        }
//        System.out.println(Arrays.toString(uglyNumbers));
        return uglyNumbers[n];
    }
}
