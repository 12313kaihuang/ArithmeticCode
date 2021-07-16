package Others.code;


public class sqrt {

    static class Test {

        private static final double PRECISION = 0.0001;

        public double sqr(int x) {
            double l = 1, r = x, mid = (l + r) / 2;
            int count = 0;
            while (Math.abs(x - mid * mid) > PRECISION) {
                double cur = mid * mid;
                if (cur > x) r = mid - PRECISION;
                else l = mid + PRECISION;
                mid = (l + r) / 2;
//                System.out.println(count++ + ", " + mid + "," + (mid * mid - x));
            }
            return mid;
        }
    }

    public static void main(String[] args) {
        double sqr = new Test().sqr(2);
        System.out.println(sqr + ", " + sqr * sqr);
    }
}
