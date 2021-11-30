package Leetcode.code;

/**
 * 400. 第 N 位数字
 * <p>
 * 给你一个整数 n ，请你在无限的整数序列[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第n 位数字。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：n = 11
 * 输出：0
 * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
 * <p>
 * 提示：
 * 1 <= n <= 231 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nth-digit
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution400_1 {

    /**
     * 官方题解  直接计算
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/nth-digit/solution/di-n-wei-shu-zi-by-leetcode-solution-mdl2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int findNthDigit(int n) {
        //d数字位数  count表示d位数总共的个数
        int d = 1, count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        //此时能得到这是一个d位数
        int index = n - 1;
        int start = (int) Math.pow(10, d - 1);  //d位数第起始数
        int num = start + index / d; //找到所在的那个数
        int digitIndex = index % d;
        return (num / (int) (Math.pow(10, d - digitIndex - 1))) % 10;
    }

    //eg n = 11
    public int test(int n) {
        int d = 1, count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        //eg d = 2,n = 2
        int index = n - 1;  //eg index = 1
        int start = (int) Math.pow(10, d - 1); //eg start = 10
        int num = start + index / d; //eg num=10
        int digitIndex = index % d; //eg 1
        //eg (10 / 1) % 10
        return (num / (int) Math.pow(10, d - digitIndex - 1)) % 10;
    }
}
