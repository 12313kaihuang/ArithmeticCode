package ArithmeticCode.SwordToOffer.code;

/**
 * Created by Hy on 2019/11/25 9:45
 * <p>
 * 二进制数中1的个数
 */
public class Test11 {

    public static void main(String[] args) {
        int n = 1;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (n == 0) break;
            System.out.println(" i = " + i);
            n = n << 1;
        }
    }

    public static class Solution {
        public int NumberOf1(int n) {
            int count = 0;
            int flag = 1;
            while (flag != 0) {
                if ((n & flag) != 0) {
                    count++;
                }
                flag = flag << 1;
            }
            return count;
        }

        public int NumberOf2(int n) {
            int count = 0;
            while (n != 0) {
                count++;
                //把最右边的1变成0
                n = (n - 1) & n;
            }
            return count;
        }
    }


}
