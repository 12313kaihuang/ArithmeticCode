package ArithmeticCode.SwordToOffer.code;

/**
 * Created by Hy on 2019/11/19 9:37
 * <p>
 * 变态跳台阶：
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Test9 {

    public static void main(String[] args) {
        System.out.println(new Solution().JumpFloorII(3));
        System.out.println(new Solution().JumpFloorII(4));
        System.out.println(new Solution().JumpFloorII(5));
        System.out.println(new Solution2().JumpFloorII(3));
        System.out.println(new Solution2().JumpFloorII(4));
        System.out.println(new Solution2().JumpFloorII(5));

    }

    public static class Solution {
        public int JumpFloorII(int target) {
            if (target == 1) return 1;
            if (target == 2) return 2;

            int result = 0;
            for (int i = 1; i < target; i++) {
                result += JumpFloorII(i);
            }
            return result + 1;
        }
    }

    public static class Solution2 {
        public int JumpFloorII(int target) {
            if (target == 1) return 1;
            if (target == 2) return 2;
            //b = f(n) , c = f(n) + f(n -1) + .. + f(1)
            int a = 1, b = 2, c = a + b;
            while (target-- > 2) {
                // f(n) = f(n-1) + f(n-2) + ... + f(2) + (1) + 1，n > 2
                b = c + 1;
                c += b;
            }
            return b;
        }
    }

    /**
     * 再次简化问题，将每次加的1记为f(0),
     * 即：
     * f(0) = 1
     * f(1) = 1
     * f(2) = 2
     * f(3) = f(2) + f(1) + f(0) = 4
     * ...
     * f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(1) + f(0)
     * = f(n-1) + ( f(n-2) + f(n-3) + ... + f(1) + f(0) )
     * = f(n-1) + f(n-1)
     * = 2 * f(n-1)
     * = 2 ^ (n-1)
     * <p>
     * what??
     */
    public static class Solution3 {
        public int JumpFloorII(int target) {
            int s = target >>> 1;
            if (target == 1) {
                return 1;
            } else {
                return (int) Math.pow(2, target - 1);
            }
        }
    }
}
