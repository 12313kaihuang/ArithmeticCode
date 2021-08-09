package Leetcode.code;

/**
 * 1137. 第 N 个泰波那契数
 * <p>
 * 泰波那契序列Tn定义如下：
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <p>
 * 给你整数n，请返回第 n 个泰波那契数Tn 的值。
 * <p>
 * 示例 1：
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * <p>
 * 示例 2：
 * 输入：n = 25
 * 输出：1389537
 * <p>
 * 提示：
 * 0 <= n <= 37
 * 答案保证是一个 32 位整数，即answer <= 2^31 - 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-th-tribonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1137_1 {

    static int[] sResult = new int[]{0, 1, 1, 2, 4, 7, 13, 24, 44, 81,
            149, 274, 504, 927, 1705, 3136, 5768, 10609, 19513, 35890,
            66012, 121415, 223317, 410744, 755476, 1389537, 2555757, 4700770, 8646064, 15902591,
            29249425, 53798080, 98950096, 181997601, 334745777, 615693474, 1132436852, 2082876103};

    //面向结果编程 = =
    public int tribonacci2(int n) {
        return sResult[n];
    }

    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        int a = 0, b = 1, c = 1, sum = a + b + c;
        while (n-- > 3) {
            a = b;
            b = c;
            c = sum;
            sum = a + b + c;
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(new Solution1137_1().tribonacci(0));
        System.out.println(new Solution1137_1().tribonacci(1));
        System.out.println(new Solution1137_1().tribonacci(2));
        System.out.println(new Solution1137_1().tribonacci(3));
        System.out.println(new Solution1137_1().tribonacci(4));
        System.out.println(new Solution1137_1().tribonacci(25));
    }

}
