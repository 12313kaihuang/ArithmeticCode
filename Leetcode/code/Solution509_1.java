package Leetcode.code;

/**
 * 509. 斐波那契数
 * <p>
 * 斐波那契数，通常用F(n) 表示，形成的序列称为 斐波那契数列 。
 * 该数列由0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0，F(1)= 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 * <p>
 * 示例 1：
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * <p>
 * 示例 2：
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * <p>
 * 示例 3：
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fibonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution509_1 {

    //应该算是标准动态规划解法
    public int fib(int n) {
        if (n<=1)return n;
        int f0 = 0,f1=1;
        for (int i = 1; i < n; i++) {
            f1 += f0;
            f0 = f1-f0;
        }
        return f1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution509_1().fib(0));
        System.out.println(new Solution509_1().fib(1));
        System.out.println(new Solution509_1().fib(2));
        System.out.println(new Solution509_1().fib(3));
        System.out.println(new Solution509_1().fib(4));
        System.out.println(new Solution509_1().fib(5));
        System.out.println(new Solution509_1().fib(6));
        System.out.println(new Solution509_1().fib(7));
        System.out.println(new Solution509_1().fib(8));
    }
}
