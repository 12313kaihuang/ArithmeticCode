package ArithmeticCode.SwordToOffer.code;

/**
 * Created by Hy on 2020/01/06 10:04
 * <p>
 * 整数中1出现的次数
 */
public class Test31 {

    public static void main(String[] args) {
        System.out.println(new Test31().NumberOf1Between1AndN_Solution(1));
        System.out.println(new Test31().NumberOf1Between1AndN_Solution(13));
        System.out.println(new Test31().NumberOf1Between1AndN_Solution2(1));
        System.out.println(new Test31().NumberOf1Between1AndN_Solution2(13));
    }

    //最笨的办法，依次判定每个数的每一位是否是1
    public int NumberOf1Between1AndN_Solution(int n) {
        int num = 0;
        for (int i = 1; i <= n; i++) {
            num += numOf1(i);
        }
        return num;
    }

    //判断每一位（个位、十位、..）是否为1，并累加
    private int numOf1(int n) {
        int num = 0;
        while (n != 0) {
            if (n % 10 == 1) num++;
            n /= 10;
        }
        return num;
    }

    public int NumberOf1Between1AndN_Solution2(int n) {
        int num = 0;
        for (long m = 1; m <= n; m *= 10) {
            num += (n / m + 8) / 10 * m + (n / m % 10 == 1 ? 1 : 0) * (n % m + 1);
        }
        return num;
    }
}
