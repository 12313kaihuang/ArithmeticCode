package Leetcode.code;

/**
 * 1716. 计算力扣银行的钱
 * <p>
 * Hercy 想要为购买第一辆车存钱。他 每天 都往力扣银行里存钱。
 * 最开始，他在周一的时候存入 1块钱。从周二到周日，他每天都比前一天多存入 1块钱。
 * 在接下来每一个周一，他都会比 前一个周一 多存入 1块钱。
 * 给你n，请你返回在第 n天结束的时候他在力扣银行总共存了多少块钱。
 * <p>
 * 示例 1：
 * 输入：n = 4
 * 输出：10
 * 解释：第 4 天后，总额为 1 + 2 + 3 + 4 = 10 。
 * <p>
 * 示例 2：
 * 输入：n = 10
 * 输出：37
 * 解释：第 10 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37 。注意到第二个星期一，Hercy 存入 2 块钱。
 * <p>
 * 示例 3：
 * 输入：n = 20
 * 输出：96
 * 解释：第 20 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 + 4 + 5 + 6 + 7 + 8) = 96 。
 * <p>
 * 提示：
 * 1 <= n <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/calculate-money-in-leetcode-bank
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Solution1716_1 {
    public int totalMoney(int n) {
        int sum = 0;
        for (int j = 0; j < n; j++) {
            int s = j / 7 + 1;
            int extra = j % 7;
            sum += (s + extra);
            System.out.print(" +" + (s + extra));
        }
        System.gc();
        return sum;
    }

    /**
     * 直接计算
     * 第一周共存28，第二周存28+7 = 35
     */
    public int totalMoney2(int n) {
        int sum = 0;
        int week = n / 7;
        for (int i = 0; i < week; i++) {
            sum += 28;
            sum += i * 7;
        }
        int day = n % 7;
        ++week;
//        System.out.println(sum);
        for (int i = 0; i < day; i++) {
            sum += week;
            sum += i;
//            System.out.print("+ " + (week + i));
        }
        return sum;
    }

    public int totalMoney3(int n) {
        int sum = 0;
        int week = n / 7;
        sum += 28 * week;
        if (week > 0) sum += 7 * (week * week - week) / 2;
        System.out.println( "week sum:" + sum);
        int day = n % 7;
        sum += ++week * day;  //++week
        if (day > 0) sum += (day * day - day) / 2;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1716_1().totalMoney(4));
        System.out.println(new Solution1716_1().totalMoney(10));
        System.out.println(new Solution1716_1().totalMoney3(4));
        System.out.println(new Solution1716_1().totalMoney3(10));
        System.out.println(new Solution1716_1().totalMoney3(20));
        System.out.println(new Solution1716_1().totalMoney3(26));
    }
}
