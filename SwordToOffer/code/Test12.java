package ArithmeticCode.SwordToOffer.code;

/**
 * Created by Hy on 2019/11/27 9:35
 *
 * 数值的整数次方
 */
public class Test12 {

    public class Solution {
        public double Power(double base, int exponent) {
            if (base == 0) {
                return 0;
            }
            if (exponent == 0) {
                return 1;
            }
            if (base == 0 && exponent < 0) {
                throw new RuntimeException("分母不能为0");
            }

            double result = 1.0, curBase = base;
            int n = exponent >= 0 ? exponent : -exponent;
            while (n != 0) {
                //最低（右）位为1
                if ((n & 1) == 1) {
                    result *= curBase;
                }
                curBase *= curBase;
                //右移
                n >>= 1;
            }
            return exponent > 0 ? result : 1 / result;
        }

    }
}
