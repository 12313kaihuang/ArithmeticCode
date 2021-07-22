package Others.code;


public class sqrt {

    @SuppressWarnings("SameParameterValue")
    static class Test {

        private static final double PRECISION = 0.0001;

        public double sqr(int x) {
            return sqr(x, PRECISION);
        }

        //二分夹逼法
        private double sqr(int x, double accuracy) {
            double l = 1, r = x, mid = (l + r) / 2;
            while (Math.abs(x - mid * mid) > accuracy) {
                double cur = mid * mid;
                if (cur > x) r = mid - accuracy;
                else l = mid + accuracy;
                mid = (l + r) / 2;
            }
            return mid;
        }

        //牛顿迭代法
        private double sqr2(double num, double accuracy) {
            double guess = num / 2;
            if (num < 0) return Double.NaN;
            while (Math.abs(guess - (num / guess)) > accuracy) {
                guess = (guess + num / guess) / 2;
            }
            return guess;
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        double sqr = test.sqr(2);
        System.out.println(sqr + ", " + sqr * sqr);
        double sqr2 = test.sqr2(2.0d, 0.0001);
        System.out.println(sqr2 + ", " + sqr2 * sqr2);
    }
}
