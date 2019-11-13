package ArithmeticCode.SwordToOffer.code;

/**
 * Created by Hy on 2019/11/13 9:47
 * <p>
 * 斐波那契数列
 */
public class Test7 {

    public static void main(String[] args) {
        System.out.println(new Solution().Fibonacci(6));
    }

    //递归
    public static class Solution {
        public int Fibonacci(int n) {
            if (n == 0 )return 0;
            if (n ==1 || n==2)return 1;
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }
    }

    //循环
    public static class Solution1 {
        public int Fibonacci(int n) {
            if (n == 0) return 0;
            if (n == 1 || n == 2) return 1;
            int a = 1, b = 1;
            while (n-- > 2) {
                b = a + b;
                a = b - a;
            }
            return b;
        }
    }


}
