package Leetcode.code;

/**
 * 633. 平方数之和
 * <p>
 * 给定一个非负整数c，你要判断是否存在两个整数 a 和 b，使得a2 + b2 = c 。
 * <p>
 * 示例 1：
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * <p>
 * 示例 2：
 * 输入：c = 3
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：c = 4
 * 输出：true
 * <p>
 * 示例 4：
 * 输入：c = 2
 * 输出：true
 * <p>
 * 示例 5：
 * 输入：c = 1
 * 输出：true
 * <p>
 * 提示：
 * 0 <= c <= 2^31 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution633_1 {

    /**
     * 暴力解法 会超出时间限制 = =
     */
    public boolean judgeSquareSum(int c) {
        for (int a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) return true;
        }
        return false;
    }

    /**
     * 官方题解2 双指针
     * <p>
     * 定义a=0,b=sqrt(c)，且a<=b
     * 当a^2 + b^2 = c，找到一个解返回true
     * 当a^2 + b^2 < c，a++;
     * 当a^2 + b^2 > c，b--;
     * <p>
     * 当a=b时，结束查找，若此时还没有找到对应的值则说明没有值存在
     *
     * 图解可以看https://leetcode-cn.com/problems/sum-of-square-numbers/solution/shuang-zhi-zhen-de-ben-zhi-er-wei-ju-zhe-ebn3/
     */
    public boolean judgeSquareSum2(int c) {
        long a = 0, b = (long) Math.sqrt(c); //平方和可能会超出限制，所以使用long类型
        while (a <= b) {
            long ret = a * a + b * b;
            if (ret == c) return true;
            else if (ret < c) a++;
            else b--;
        }
        return false;
    }

    /**
     * 官方题解3 费马平方和定理
     * <p>
     * 根据定理可知：一个非负整数c如果能够表示为两个整数的平方和，当且仅当c的所有形如4k+3的质因子的幂均为偶数。
     * 所以下面对c进行质因数分解，再判断所有形如4K+3的质因子的幂是否均为偶数
     *
     * 解法3的翻译有误： 原句：一个非负整数 c 如果能够表示为两个整数的平方和，当且仅当 cc 的所有形如4k+3 的质因子的幂均为偶数。
     * 英文原句： A number n is a sum of two squares if and only if all prime factors of n of the form 4m+3 have even exponent in the prime factorization of n.
     * 应该翻译为：一个非负整数 cc 如果能够表示为两个整数的平方和，当且仅当 cc 的所有形如4k+3 的质因子所对应的指数均为偶数。
     * exponent是指数，不是幂。意思是c进行质因数分解时，分解出来的4k+3形式的质因子都得是偶数个。 例如 9=3*3可以，18=3*3*2可以，27=3*3*3不可以，以为这里质因子3有3个，171=19*3*3不可以因为19也是4k+3形式的但是只有一个。
     */
    public boolean judgeSquareSum3(int c) {
        for (int base = 2; base * base <= c; base++) {
            if (c % base != 0) continue; //不是因子进入下一次循环

            //计算base的幂
            //base ^ exp，叫做base的exp次幂
            int exp = 0;
            while (c % base == 0) {
                c /= base;
                exp++;
            }

            //判断base是否=4K + 3，且exp是偶数
            if (base % 4 == 3 && exp % 2 != 0) {
                return false;
            }
        }
        //例如11这样的案例，除了1和11没有其他的因子，因此不会真正进入循环体，
        //这种情况下幂为1，需要再次判断一下c是否等于4K+3
        return c % 4 != 3; //还是不是很懂这里为什么这么判断
    }
}
